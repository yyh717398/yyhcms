package com.yyh.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yangyuhao.common.utils.StringUtil;
import com.yyh.cms.domain.Article;
import com.yyh.cms.domain.User;
import com.yyh.cms.service.ArticleService;
import com.yyh.cms.service.UserService;
/**
 * 
 * @ClassName: AdminController 
 * @Description: 管理员
 * @author: dell
 * @date: 2020年5月10日 下午8:42:03
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Resource
	private ArticleService articleService;
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @Title: index 
	 * @Description: 管理员首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value={"","/","index"})
	public String index(){
		
		return "admin/index";
	}
	
	/**
	 * 
	 * @Title: articles 
	 * @Description: 显示系统所有文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Article article,
			@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10")Integer pageSize,
			Model model			){
		if(article.getStatus()==null){
			article.setStatus(0);
		}
		
		PageInfo<Article> info = articleService.selects(article, pageNum, pageSize);
		
		model.addAttribute("info", info);
		return "admin/articles";
	}
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 修改文章状态
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("updateArticle")
	public boolean updateArticle(Article article){
		
		return articleService.update(article)>0;
	}
	
	/**
	 * 
	 * @Title: selectsUser 
	 * @Description: 查询所有用户
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String selectsUser(User user,
			@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="8")Integer pageSize,
			Model model			){
		PageInfo<User> selects = userService.selects(user, pageNum, pageSize);
		model.addAttribute("info", selects);
		model.addAttribute("user", user);
		return "admin/users";
		
	}
	
	/**
	 * 
	 * @Title: updateUser
	 * @Description: 修改用户状态
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("updateUser")
	public boolean updateUser(User user){
		
		return userService.update(user)>0;
	}
	
}
