package cn.merryyou.apigetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created on 2018/4/14 0014.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGetwayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGetwayApplication.class, args);
    }

//    @ConfigurationProperties("zuul")
//    @RefreshScope
//    public ZuulProperties zuulProperties() {
//        return new ZuulProperties();
//    }
}
