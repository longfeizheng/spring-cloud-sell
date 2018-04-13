package cn.merryyou.order.controller;

import cn.merryyou.order.dto.OrderDTO;
import cn.merryyou.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created on 2018/4/13 0013.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1234556");
//        streamClient.output().send(MessageBuilder.withPayload("now:"+new Date()).build());
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
