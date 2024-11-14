package io.mybatis.example.springboot.mapper;

import io.mybatis.example.springboot.model.User;

/**
 * UserMapper
 *
 * @author WangChen
 * Created on 2023/5/6
 * @since 1.0
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends BaseMapper<User, String> {

}
