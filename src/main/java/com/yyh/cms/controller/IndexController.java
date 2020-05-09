package com.yyh.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.yangyuhao.common.utils.DateUtil;
import com.yyh.cms.domain.Article;
import com.yyh.cms.domain.Category;
import com.yyh.cms.domain.Channel;
import com.yyh.cms.domain.Slide;
import com.yyh.cms.service.ArticleService;
import com.yyh.cms.service.ChannelService;
import com.yyh.cms.service.SlideService;
/**
 * 
 * @ClassName: IndexController 
 * @Description: 首页
 * @author: dell
 * @date: 2020年5月6日 下午8:17:44
 */
@Controller
public class IndexController {
	@Resource
	private ChannelService channelService;
	@Resource
	private ArticleService articleService;
	@Resource
	private SlideService slideService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入首页三种方式
	 * @return
	 * @return: String
	 */
	@RequestMapping(value={"","/","index"})
	public String index(Model model,Article article,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize){
		//1.查询所有栏目
		List<Channel> channels = channelService.selects();
		//只显示审核通过的文章
		article.setStatus(1);
		model.addAttribute("channels", channels);
		//2.根据栏目id查询所有分类
		List<Category> categorys = channelService.selectCategoryByChannelId(article.getChannelId());
		model.addAttribute("categorys", categorys);
		model.addAttribute("article", article);
		//3.查询栏目下的文章
			//3.判断栏目id是否为空
		if(article.getChannelId()!=null){
			PageInfo<Article> selects = articleService.selects(article, pageNum, pageSize);
			model.addAttribute("info", selects);
		}
		//4显示热点文章 和广告 
		if(article.getChannelId()==null){
			//热点文章
			article.setHot(1);
			PageInfo<Article> selects = articleService.selects(article, pageNum, pageSize);
			model.addAttribute("info", selects);
			//广告
			List<Slide> slides = slideService.selectsSlides();
			model.addAttribute("slides", slides);
		}
		
		//右侧边栏显示24小时内文章
		Article article2 = new Article();
		//只显示审核通过的文章
		article2.setStatus(1);
		article2.setHot(1);//热点文章
		article2.setCreated(DateUtil.SubDate(new Date(), 24));//当前系统时间减去24小时
		PageInfo<Article> hot24Articles = articleService.selects(article2, 1, 5);
		model.addAttribute("hot24Articles", hot24Articles);
		return "index/index";
	}
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 文章详情
	 * @return
	 * @return: String
	 */
	@GetMapping("articleDetail")
	public String articleDetail(Integer id,Model model){
		
		Article article = articleService.select(id);
		model.addAttribute("article", article);
		return "index/articleDetail";
	}
	
}
