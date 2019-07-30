package com.lzh.shiro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.shiro.mapper.PermissionMapper;
import com.lzh.shiro.pojo.Permission;
import com.lzh.shiro.service.IPermissionService;
import org.springframework.stereotype.Service;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
}
