package cn.merryyou.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

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

        //3. 第三种方式 使用@LoadBalanced注解
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        return response;
    }
}
