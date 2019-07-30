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
public class UserRole implements Serializable {
	private String userId;
	private String roleId;
	private Date createDate;
}
