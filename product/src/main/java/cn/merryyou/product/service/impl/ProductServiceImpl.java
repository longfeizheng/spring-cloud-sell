package cn.merryyou.product.service.impl;

import cn.merryyou.product.dataobject.ProductInfo;
import cn.merryyou.product.dto.CardDTO;
import cn.merryyou.product.enums.ProductStatusEnum;
import cn.merryyou.product.enums.ResultEnum;
import cn.merryyou.product.exception.ProductException;
import cn.merryyou.product.repository.ProductInfoRepository;
import cn.merryyou.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CardDTO> cardDTOList) {
        for (CardDTO cardDTO : cardDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cardDTO.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cardDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
