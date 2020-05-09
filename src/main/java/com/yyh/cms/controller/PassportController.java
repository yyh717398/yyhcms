package com.yyh.cms.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyh.cms.domain.User;
import com.yyh.cms.service.UserService;
import com.yyh.cms.util.CMSException;
import com.yyh.cms.util.CMSResult;

/**
 * 
 * @ClassName: PassportController
 * @Description: 登录注册
 * @author: dell
 * @date: 2020年5月8日 下午3:24:41
 */
@Controller
@RequestMapping("passport")
public class PassportController {
	@Resource
	private UserService userService;
	/**
	 * 
	 * @Title: login 
	 * @Description: 普通用户去登录
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login(){
		return "passport/login";
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 普通用户执行登录
	 * @param user
	 * @return
	 * @return: CMSResult<User>
	 */
	@ResponseBody
	@PostMapping("login")
	public CMSResult<User> login(User user,HttpSession session){
		System.out.println("========");
		CMSResult<User> result = new CMSResult<>();
		//捕获异常并封装消息
		try {
			User u = userService.login(user);
			if(u.getRole()==1){//是管理员
				session.setAttribute("admin", u);
			}
			//登录成功 存入session 普通用户
			session.setAttribute("user", u);
			result.setCode(200);
			result.setMsg("恭喜登录成功");
		} catch (CMSException e) {
			result.setCode(300);
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统崩溃，请联系管理员");
		}
		return result;
		 
	}
	
	/**
	 * 
	 * @Title: reg
	 * @Description: 去注册
	 * @return
	 * @return: String
	 */
	@GetMapping("reg")
	public String reg() {
		return "passport/reg";
	}
	/**
	 * 
	 * @Title: reg 
	 * @Description: 执行注册
	 * @param user
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("reg")
	public CMSResult<User> reg(User user){
		CMSResult<User> result = new CMSResult<>();

		try {
			userService.insertUser(user);
			result.setCode(200);
			result.setMsg("恭喜注册成功,请登录");
		} catch (CMSException e) {
			result.setCode(300);
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统崩溃，请联系管理员");
		}
		return result;
		 
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 管理员用户
	 * @param user
	 * @return
	 * @return: CMSResult<User>
	 */
	@ResponseBody
	@PostMapping("admin/login")
	public CMSResult<User> adminLogin(User user,HttpSession session){
		System.out.println("========");
		CMSResult<User> result = new CMSResult<>();
		//捕获异常并封装消息
		try {
			User u = userService.login(user);
			if(u.getRole()==0){
				throw new CMSException("请以合适的用户登录");
			}
			//登录成功 存入session
			session.setAttribute("admin", u);
			result.setCode(200);
			result.setMsg("恭喜登录成功");
		} catch (CMSException e) {
			result.setCode(300);
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统崩溃，请联系管理员");
		}
		System.out.println("======="+result.getMsg());
		return result;
		 
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 管理员登录
	 * @return
	 * @return: String
	 */
	@GetMapping("admin/login")
	public String adminLogin(){
		return "passport/admin_login";
	}
	
	/**
	 * 
	 * @Title: logout 
	 * @Description: 注销当前用户
	 * @return
	 * @return: String
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		//重定向到系统首页
		return "redirect:/";
	}
}
