package cn.merryyou.order.service.impl;

import cn.merryyou.order.client.ProductClient;
import cn.merryyou.order.dataobject.CardDTO;
import cn.merryyou.order.dataobject.OrderDetail;
import cn.merryyou.order.dataobject.OrderMaster;
import cn.merryyou.order.dataobject.ProductInfo;
import cn.merryyou.order.dto.OrderDTO;
import cn.merryyou.order.enums.OrderStatusEnum;
import cn.merryyou.order.enums.PayStatusEnum;
import cn.merryyou.order.repository.OrderDetailRepository;
import cn.merryyou.order.repository.OrderMasterRepository;
import cn.merryyou.order.service.OrderService;
import cn.merryyou.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        /**
         * 1. 参数校验/
         * 2. 查询商品信息（调用商品服务）
         * 3. 计算总价
         * 4. 扣库存（调用商品服务）
         * 5. 订单入库
         */
        String orderId = KeyUtil.genUniqueKey();
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        //扣库存
        List<CardDTO> cardDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CardDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cardDTOList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
