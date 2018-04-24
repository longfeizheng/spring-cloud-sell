package cn.merryyou.user.repository;

import cn.merryyou.user.dataobject.UserInfo;
import cn.merryyou.user.enums.RoleEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2018/4/24 0024.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void findByOpenid() {
        UserInfo userInfo = userInfoRepository.findByOpenid("abc");
        Assert.assertTrue(userInfo!=null);
        Assert.assertTrue(userInfo.getRole()== RoleEnum.BUYER.getCode());
    }

    @Test
    public void findByUsername() {
        UserInfo userInfo = userInfoRepository.findByUsername("admin");
        Assert.assertTrue(userInfo!=null);
        Assert.assertTrue(userInfo.getRole()== RoleEnum.BUYER.getCode());
    }
}