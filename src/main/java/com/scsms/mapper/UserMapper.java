package com.scsms.mapper;

import com.scsms.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectOne(String username);

    void register(User user);
}
