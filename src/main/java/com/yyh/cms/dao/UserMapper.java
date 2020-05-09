package com.yyh.cms.dao;


import java.util.List;

import com.yyh.cms.domain.User;
/**
 * 
 * @ClassName: UserMapper 
 * @Description: 管理文章
 * @author: dell
 * @date: 2020年5月6日 下午7:11:24
 */
public interface UserMapper {
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
	List<User> selects(User user);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改用户
	 * @param user
	 * @return
	 * @return: int
	 */
	int update(User user);
	
	
	
}
