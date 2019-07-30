package com.lzh.shiro.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
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
public class Permission implements Serializable {
	private String id;
	private String name;
	private Date createDate;
	@TableField(update = "new()")
	private Date modifiedDate;
}
