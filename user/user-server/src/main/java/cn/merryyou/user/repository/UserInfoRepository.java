package cn.merryyou.user.repository;

import cn.merryyou.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/4/14 0014.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);

    UserInfo findByUsername(String username);
}
