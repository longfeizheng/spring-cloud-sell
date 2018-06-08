package cn.merryyou.oauth.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Created on 2018/6/6.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Configuration
@EnableAuthorizationServer//
public class MerryyouAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 客户端一些配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("merryyou")
                .secret(new BCryptPasswordEncoder().encode("merryyou"))
                .authorizedGrantTypes("authorization_code", "refresh_token","password")
//                .redirectUris("http://sso-taobao:8083/client1")
                .scopes("all")
                .autoApprove(true);
    }
}
