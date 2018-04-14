package cn.merryyou.user.vo;

import lombok.Data;

/**
 * Created on 2018/4/14 0014.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
