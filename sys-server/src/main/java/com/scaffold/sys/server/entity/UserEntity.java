package com.scaffold.sys.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.scaffold.common.base.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_user")
public class UserEntity extends BaseEntity {

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	@JSONField(serialize=false)
	private String password;
}