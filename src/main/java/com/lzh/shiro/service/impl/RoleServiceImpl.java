package com.lzh.shiro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.shiro.mapper.RoleMapper;
import com.lzh.shiro.pojo.Role;
import com.lzh.shiro.service.IRoleService;
import org.springframework.stereotype.Service;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
