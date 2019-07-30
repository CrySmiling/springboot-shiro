package com.lzh.shiro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.shiro.mapper.UserRoleMapper;
import com.lzh.shiro.pojo.UserRole;
import com.lzh.shiro.service.IUserRoleService;
import org.springframework.stereotype.Service;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
}
