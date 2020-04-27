package com.yyh.cms.dao;

import java.util.List;

import com.yyh.cms.domain.Article;
/**
 * 
 * @ClassName: ArticleMapper 
 * @Description: TODO
 * @author: dell
 * @date: 2020年4月27日 下午8:59:54
 */
public interface ArticleMapper {
	
	List<Article> selects();
}
