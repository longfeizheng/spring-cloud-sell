package cn.merryyou.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 2018/4/24 0024.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
@SpringBootApplication
//@EnableDiscoveryClient
public class OauthApplication {
    public static void main(String[] args) {

        SpringApplication.run(OauthApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "hello world!";
    }

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
