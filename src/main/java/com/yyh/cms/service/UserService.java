package com.yyh.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yyh.cms.domain.User;

public interface UserService {
	/**
	 * 
	 * @Title: insertUser 
	 * @Description: 注册用户
	 * @param user
	 * @return
	 * @return: int
	 */
	int insertUser(User user);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 用户列表
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	PageInfo<User> selects(User user,Integer pageNum,Integer pageSize);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改用户
	 * @param user
	 * @return
	 * @return: int
	 */
	int update(User user);
	
	/**
	 * 
	 * @Title: selectByName 
	 * @Description: 根据用户名查询用户
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByName(String username);
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录校验
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);
}
