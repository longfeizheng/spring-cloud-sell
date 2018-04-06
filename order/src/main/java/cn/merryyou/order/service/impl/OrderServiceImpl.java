package cn.merryyou.order.service.impl;

import cn.merryyou.order.dataobject.OrderMaster;
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

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        /**
         * 1. 参数校验//TODO
         * 2. 查询商品信息（调用商品服务）//TODO
         * 3. 计算总价//TODO
         * 4. 扣库存（调用商品服务）//TODO
         * 5. 订单入库
         */
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
