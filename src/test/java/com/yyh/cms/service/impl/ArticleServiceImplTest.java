package com.yyh.cms.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyh.cms.domain.Article;
import com.yyh.cms.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class ArticleServiceImplTest {
	
	@Resource
	private ArticleService articleService;
	

	@Test
	public void testSelects() {
		List<Article> selects = articleService.selects();
		
	}

}
