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
public class User implements Serializable {
	private String id;
	private String name;
	private String password;
	private String sex;
	private Date createDate;
	private Date modifiedDate;
}
