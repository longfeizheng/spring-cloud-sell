package cn.merryyou.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/4/6.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableOAuth2Sso
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }

    @GetMapping("/api")
    public Authentication api(Authentication user) {
        return user;
    }
    @GetMapping("/roleAdmin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String roleAdmin(Authentication user) {
        return "hello World!";
    }

    @GetMapping(value = {"/index","/"})
    public String index(){
        return "hello world!";
    }

}
