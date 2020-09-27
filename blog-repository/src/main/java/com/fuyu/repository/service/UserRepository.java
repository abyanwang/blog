package com.fuyu.repository.service;

import com.fuyu.domain.bo.BlogUserDO;

public interface UserRepository {
    /**
     * 插入用户
     * @param blogUserDO
     * @return
     */
    Integer insertUserDO(BlogUserDO blogUserDO);

    /**
     * 通过uid或者username来更新用户信息.
     * @param blogUserDO
     * @return
     */
    Integer updateUserDO(BlogUserDO blogUserDO);

    /**
     * 通过uid或者username来查询个人信息.
     * 登陆时可以使用username 其余不可.
     * @param uid
     * @param username
     * @return
     */
    BlogUserDO selectUserDO(Long uid,String username);

    /**
     * 删除用户.
     * @param uid
     * @param username
     * @return
     */
    Integer deleteUserDO(Long uid,String username);
}
