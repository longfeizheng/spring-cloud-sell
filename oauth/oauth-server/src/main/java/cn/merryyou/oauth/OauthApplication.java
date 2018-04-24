package cn.merryyou.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created on 2018/4/24 0024.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OauthApplication {
    public static void main(String[] args) {

        SpringApplication.run(OauthApplication.class, args);
    }
}
