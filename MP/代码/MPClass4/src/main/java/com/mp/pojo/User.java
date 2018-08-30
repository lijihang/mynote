package com.mp.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author:Li
 * @mender:Li
 * @version:1.0.0
 * @time:2018年7月31日上午11:41:28
 * @docs:UserDo.java
 */

/**
 * 设置表明
 */
@TableName("user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 设置主键
	 */
	@TableId(type = IdType.AUTO)
	Integer id;

	/**
	 * 设置字段
	 */
	@TableField(value = "account")
	String account;

	String password;

	/**
	 * 设置自动填充
	 * 插入和修改会进行填充
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	Integer salt;

	/**
	 * 设置乐观锁
	 */
	@Version
	Integer version;
	
	/**
	 * 设置逻辑删除
	 */
	@TableLogic
	Integer logicFalg;

	/**
	 * 进行数据库操作时忽略此字段
	 */
	@TableField(exist = false)
	String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSalt() {
		return salt;
	}

	public void setSalt(Integer salt) {
		this.salt = salt;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLogicFalg() {
		return logicFalg;
	}

	public void setLogicFalg(Integer logicFalg) {
		this.logicFalg = logicFalg;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", salt=" + salt + "]";
	}

}
