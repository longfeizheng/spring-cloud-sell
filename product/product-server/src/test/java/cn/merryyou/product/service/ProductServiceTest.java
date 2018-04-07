package cn.merryyou.product.service;

import cn.merryyou.product.ProductTests;
import cn.merryyou.product.dataobject.ProductInfo;
import cn.merryyou.product.dto.CardDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
public class ProductServiceTest extends ProductTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }
    @Test
    public void findListTest() throws Exception{
        List<ProductInfo> productInfoList = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStockTest() throws Exception{
        CardDTO cardDTO = new CardDTO("157875196366160022",2);
        productService.decreaseStock(Arrays.asList(cardDTO));
    }
}