package cn.merryyou.product.repository;

import cn.merryyou.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer status);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
