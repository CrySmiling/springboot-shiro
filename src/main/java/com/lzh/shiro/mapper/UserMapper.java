package com.lzh.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzh.shiro.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
public interface UserMapper extends BaseMapper<User> {
	@Select("select * from user where name = #{name}")
	User findByName(@Param("name") String name);
}
