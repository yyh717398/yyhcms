package com.yyh.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yyh.cms.domain.Article;
/**
 * 
 * @ClassName: ArticleService 
 * @Description: 
 * @author: dell
 * @date: 2020年4月28日 下午3:32:43
 */
public interface ArticleService {
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 读取单个文章
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);

	
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 文章列表
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Article>
	 */
	
	PageInfo<Article> selects(Article article,Integer pageNum,Integer pageSize);
	/**
	 * 
	 * @Title: selectsOrderComments 
	 * @Description: 按照评论数量显示文章
	 * @param article
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> selectsOrderComments(Article article,Integer pageNum,Integer pageSize);
}
