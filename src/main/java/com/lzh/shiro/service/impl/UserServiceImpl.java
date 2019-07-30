package com.lzh.shiro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.shiro.mapper.UserMapper;
import com.lzh.shiro.pojo.User;
import com.lzh.shiro.service.IUserService;
import org.springframework.stereotype.Service;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	@Override
	public User findByName(String name) {
		return baseMapper.findByName(name);
	}
}
