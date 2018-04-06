package cn.merryyou.order.dataobject;

import lombok.Data;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class CardDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CardDTO() {
    }

    public CardDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
