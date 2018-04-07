package cn.merryyou.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String mesage() {
        return "this is product msg";
    }
}
