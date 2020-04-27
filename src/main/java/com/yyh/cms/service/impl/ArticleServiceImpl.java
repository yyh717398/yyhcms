package com.yyh.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.cms.dao.ArticleMapper;
import com.yyh.cms.domain.Article;
import com.yyh.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper mapper;

	@Override
	public List<Article> selects() {
		// TODO Auto-generated method stub
		return mapper.selects();
	}
	
	
}
