package com.fuyu.repository;

import com.fuyu.common.utils.SecurityUtil;
import com.fuyu.domain.bo.BlogUserDO;
import com.fuyu.repository.service.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogRepositoryApplication.class)
@Transactional
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUserTest() {
        BlogUserDO userDO = new BlogUserDO();
        userDO.setUid(1L);
        userDO.setUserName("zw");
        userDO.setPassword(SecurityUtil.md5Encode("zw".getBytes()));
        Assert.assertEquals(Integer.valueOf(1),
                userRepository.insertUserDO(userDO));
        Assert.assertEquals(Integer.valueOf(0),
                userRepository.insertUserDO(userDO));
    }

    @Test
    public void updateUserTest() {
        BlogUserDO userDO = new BlogUserDO();
        userDO.setUid(1L);
        userDO.setUserName("zw");
        userDO.setPassword(SecurityUtil.md5Encode("zw".getBytes()));
        userRepository.insertUserDO(userDO);
        userDO.setPassword(SecurityUtil.md5Encode("xx".getBytes()));
        BlogUserDO userDO1 = new BlogUserDO();
        Assert.assertEquals(Integer.valueOf(0), userRepository.updateUserDO(userDO1));
        Assert.assertEquals(Integer.valueOf(1), userRepository.updateUserDO(userDO));
    }

    @Test
    public void deleteUserTest() {
        BlogUserDO userDO = new BlogUserDO();
        userDO.setUid(1L);
        userDO.setUserName("zw");
        userDO.setPassword(SecurityUtil.md5Encode("zw".getBytes()));
        userRepository.insertUserDO(userDO);
        userRepository.deleteUserDO(1L, null);
        Assert.assertEquals(null, userRepository.selectUserDO(1L, null));
    }
}
