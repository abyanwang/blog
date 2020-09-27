package com.fuyu.repository.service.impl;

import com.fuyu.common.constant.DeleteConstant;
import com.fuyu.domain.bo.BlogUserDO;
import com.fuyu.domain.bo.BlogUserDOExample;
import com.fuyu.repository.mybatis.mapper.BlogUserDOMapper;
import com.fuyu.repository.service.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private BlogUserDOMapper blogUserDOMapper;

    @Override
    public Integer insertUserDO(BlogUserDO blogUserDO) {
        return blogUserDOMapper.insertSelective(blogUserDO);
    }

    @Override
    public Integer updateUserDO(BlogUserDO blogUserDO) {
        //判断uid和username都为空的话不能调用接口逻辑.
        if (blogUserDO.getUid() == null)return 0;
        BlogUserDOExample blogUserDOExample = new BlogUserDOExample();
        BlogUserDOExample.Criteria criteria = blogUserDOExample.createCriteria();
        if (blogUserDO.getUid() != null) {
            criteria.andUidEqualTo(blogUserDO.getUid());
        }
        //没有被删除的才改.
        criteria.andIsDeletedEqualTo(DeleteConstant.notdelete);
        return blogUserDOMapper.updateByExampleSelective(blogUserDO, blogUserDOExample);
    }

    @Override
    public BlogUserDO selectUserDO(Long uid, String username) {
        if (uid == null && StringUtils.isEmpty(username)) return null;
        BlogUserDOExample blogUserDOExample = new BlogUserDOExample();
        BlogUserDOExample.Criteria criteria = blogUserDOExample.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUserNameEqualTo(username);
        }
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        //判断有没有被删除.
        criteria.andIsDeletedEqualTo(DeleteConstant.notdelete);
        List<BlogUserDO> blogUserDOList =
                blogUserDOMapper.selectByExample(blogUserDOExample);
        if (!CollectionUtils.isEmpty(blogUserDOList)) return blogUserDOList.get(0);
        else return null;
    }

    @Override
    public Integer deleteUserDO(Long uid, String username) {
        if (uid == null && StringUtils.isEmpty(username)) return 0;
        BlogUserDOExample blogUserDOExample = new BlogUserDOExample();
        BlogUserDOExample.Criteria criteria = blogUserDOExample.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUserNameEqualTo(username);
        }
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        BlogUserDO record = new BlogUserDO();
        record.setIsDeleted(DeleteConstant.deleted);
        return blogUserDOMapper.updateByExampleSelective(record, blogUserDOExample);
    }
}
