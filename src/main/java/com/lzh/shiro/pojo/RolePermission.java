package com.lzh.shiro.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
@Data
public class RolePermission implements Serializable {
	private String roleId;
	private String permissionId;
	private Date createDate;
}
