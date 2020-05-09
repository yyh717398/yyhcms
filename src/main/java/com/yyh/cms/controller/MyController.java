package com.yyh.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.yangyuhao.common.utils.FileUtil;
import com.yangyuhao.common.utils.StringUtil;
import com.yyh.cms.domain.Article;
import com.yyh.cms.domain.Category;
import com.yyh.cms.domain.Channel;
import com.yyh.cms.domain.User;
import com.yyh.cms.service.ArticleService;
import com.yyh.cms.service.ChannelService;

/**
 * 
 * @ClassName: MyController 
 * @Description: 个人中心
 * @author: dell
 * @date: 2020年4月28日 下午7:49:48
 */
@RequestMapping("my")
@Controller
public class MyController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ChannelService channelService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入个人中心首页
	 * @return
	 * @return: String
	 * 地址栏可以输入 my my/ my/index 都能进入首页
	 */
	@RequestMapping(value={"","/","index"})
	public String index(){
		return "my/index";
	}
	
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 文章列表 我的文章
	 * @param model
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String selectArticles(Model model,Article article,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="6")Integer pageSize,
			HttpSession session){
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		PageInfo<Article> info = articleService.selects(article, pageNum, pageSize);
		
		model.addAttribute("info", info);
		return "my/articles";
	}
	/**
	 * 
	 * @Title: article 
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: Article
	 */
	@RequestMapping("article")
	@ResponseBody
	public Article selectArticle(Integer id){
		
		return articleService.select(id);
	}
	
	/**
	 * 
	 * @Title: publish 
	 * @Description: 去发布文章
	 * @return
	 * @return: String
	 */
	@GetMapping("publish")
	public String publish(){
		
		return "my/publish";
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 执行发布文章
	 * @return
	 * @return: boolean
	 */
	@PostMapping("publish")
	@ResponseBody
	public boolean publish(MultipartFile file,
			Article article,
			HttpSession session){
		//判断是否选中文件
		System.out.println(file.getOriginalFilename());
		if(null!=file && !file.isEmpty()){
			
			//文件上传地址
			String path = "e:/pic/";
			//防止文件重复 拿后缀名
			String extendName = FileUtil.getExtendName(file.getOriginalFilename());
			extendName = UUID.randomUUID().toString()+extendName;
			File file2 = new File(path,extendName);//根据地址构建新的文件名
			try {
				file.transferTo(file2);//文件写入硬盘
				article.setPicture(extendName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());//发布人
		article.setStatus(0);//文章状态 默认待审核
		article.setCreated(new Date());//发布时间
		article.setUpdated(new Date());//修改时间
		article.setDeleted(0);//正常
		article.setHot(0);//非热门
		article.setContentType("0");//文章类型 表示html 1代表json
		System.out.println(article);
		return articleService.insert(article)>0;
	}
	
	@RequestMapping("channels")
	@ResponseBody
	public List<Channel> selectChannels(){
		
		return channelService.selects();
		
	}
	
	/**
	 * 
	 * @Title: selectCategoryByChannelId 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	@RequestMapping("selectCategoryByChannelId")
	@ResponseBody
	public List<Category> selectCategoryByChannelId(Integer channelId){
		
		return channelService.selectCategoryByChannelId(channelId);
		
	}
	
	
}
