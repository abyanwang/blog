package com.fuyu.repository.mybatis.mapper;

import com.fuyu.domain.bo.BlogUserDO;
import com.fuyu.domain.bo.BlogUserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogUserDOMapper {
    long countByExample(BlogUserDOExample example);

    int deleteByExample(BlogUserDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogUserDO record);

    int insertSelective(BlogUserDO record);

    List<BlogUserDO> selectByExampleWithRowbounds(BlogUserDOExample example, RowBounds rowBounds);

    List<BlogUserDO> selectByExample(BlogUserDOExample example);

    BlogUserDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogUserDO record, @Param("example") BlogUserDOExample example);

    int updateByExample(@Param("record") BlogUserDO record, @Param("example") BlogUserDOExample example);

    int updateByPrimaryKeySelective(BlogUserDO record);

    int updateByPrimaryKey(BlogUserDO record);
}