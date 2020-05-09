package com.yyh.cms.dao;

import java.util.List;

import com.yyh.cms.domain.Article;
/**
 * 
 * @ClassName: ArticleMapper 
 * @Description: 文章mapper
 * @author: dell
 * @date: 2020年4月27日 下午8:59:54
 */
public interface ArticleMapper {
	
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
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	
	/**
	 * 
	 * @Title: 文章的列表查询 
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article article);
}
