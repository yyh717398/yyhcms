package com.yyh.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyh.cms.dao.ArticleMapper;
import com.yyh.cms.domain.Article;
import com.yyh.cms.domain.Article;
import com.yyh.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> selects(Article article, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Article> selects = articleMapper.selects(article);
		return new PageInfo<Article>(selects);
	}

	@Override
	public Article select(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.select(id);
	}

	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insert(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}

	@Override
	public PageInfo<Article> selectsOrderComments(Article article,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<Article> selects = articleMapper.selectsOrderComments(article);
		return new PageInfo<Article>(selects);
	}

}
