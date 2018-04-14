package cn.merryyou.user.service;

import cn.merryyou.user.dataobject.UserInfo;

/**
 * Created on 2018/4/14 0014.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface UserService {

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
