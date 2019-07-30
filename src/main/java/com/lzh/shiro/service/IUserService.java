package com.lzh.shiro.service;

import com.baomidou.mybatisplus.service.IService;
import com.lzh.shiro.pojo.User;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
public interface IUserService extends IService<User> {
	User findByName(String name);
}
