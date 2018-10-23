package com.yst.business.repository;

import com.yst.common.bean.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByUsername(@Param("username")String username);
}