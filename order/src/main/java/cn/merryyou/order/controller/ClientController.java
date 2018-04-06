package cn.merryyou.order.controller;

import cn.merryyou.order.client.ProductClient;
import cn.merryyou.order.dataobject.CardDTO;
import cn.merryyou.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1. 第一种方式(直接使用restTemplate)
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        log.info("【response】={}",response);

        //2. 第二种方式，利用LoadBalancerClient获取url
//        ServiceInstance instance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/msg");
//        String response = restTemplate.getForObject(url, String.class);

        //3. 第三种方式 使用@LoadBalanced注解 RestTemplateConfig类
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        // 使用feign调用product
        String response = productClient.msg();
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CardDTO("164103465734242707", 3)));
        return "ok";
    }
}
