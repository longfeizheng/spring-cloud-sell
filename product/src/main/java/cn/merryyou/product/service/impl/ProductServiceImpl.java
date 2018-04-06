package cn.merryyou.product.service.impl;

import cn.merryyou.product.dataobject.ProductInfo;
import cn.merryyou.product.enums.ProductStatusEnum;
import cn.merryyou.product.repository.ProductInfoRepository;
import cn.merryyou.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
