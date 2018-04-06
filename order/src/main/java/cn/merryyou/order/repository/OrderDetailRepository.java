package cn.merryyou.order.repository;

import cn.merryyou.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/4/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
