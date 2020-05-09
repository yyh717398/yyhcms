package com.yyh.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangyuhao.common.utils.StringUtil;
import com.yyh.cms.dao.UserMapper;
import com.yyh.cms.domain.User;
import com.yyh.cms.service.UserService;
import com.yyh.cms.util.CMSException;
import com.yyh.cms.util.Md5Util;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;


	@Override
	public PageInfo<User> selects(User user, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<>(userMapper.selects(user));
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

	@Override
	public int insertUser(User user) {
		//进行注册的规则校验
		//1.用户名不能为空
		if(!StringUtil.hasText(user.getUsername())){
			throw new CMSException("用户名不能为空");
		}
		//2.用户名长度在5-10之间
		if(!(user.getUsername().length()>=5)||!(user.getUsername().length()<=10)){
			throw new CMSException("用户名名长度在5-10之间");
		}
		//3.密码不能为空
		if(!StringUtil.hasText(user.getPassword())){
			throw new CMSException("密码不能为空");
		}
		//4.用户名长度在6-10之间
		if(!(user.getPassword().length()>=6)||!(user.getPassword().length()<=10)){
			throw new CMSException("用户名名长度在6-10之间");
		}
		//5.两次密码是否一致
		if(!user.getPassword().equals(user.getRepassword())){
			throw new CMSException("两次密码输入不一致");
		}
		//6对密码进行加密
		user.setPassword(Md5Util.endcode(user.getPassword()));
		
		return userMapper.insertUser(user);
	}
	
	@Override
	public User selectByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByName(username);
	}
	
	@Override
	public User login(User user) {
		//进行登录规则校验
		//1.用户名不能为空
		if(!StringUtil.hasText(user.getUsername())){
			throw new CMSException("用户名不能为空");
		}
		//2.检查是否有该用户
		User u = selectByName(user.getUsername());
		if(null==u){
			throw new CMSException("无此用户");
		}
		//3检查密码是否正确
		 //3.1密码不能为空
		if(!StringUtil.hasText(user.getPassword())){
			throw new CMSException("密码不能为空");
		}
		 //3.2密码是否正确
		System.out.println(Md5Util.endcode(user.getPassword()));
		System.out.println(u.getPassword());
		if(!Md5Util.endcode(user.getPassword()).equals(u.getPassword())){
			throw new CMSException("密码不正确");
		}
		//4.如果用户状态被禁用 则不能登录
		if(u.getLocked()==1){
			throw new CMSException("账号异常，请联系管理员");
		}
		return u;
	}
}
