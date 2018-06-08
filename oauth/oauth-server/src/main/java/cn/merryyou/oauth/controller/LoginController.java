package cn.merryyou.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 2018/6/8.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
public class LoginController {

    @GetMapping("/authentication/require")
    public ModelAndView require() {
        return new ModelAndView("ftl/login");
    }

    @GetMapping("/test")
    public ModelAndView test(){
        return new ModelAndView("ftl/test");
    }
}
