package com.yyh.cms.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyh.cms.dao.ArticleMapper;
import com.yyh.cms.domain.Article;
import com.yyh.cms.util.EsUtils;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-beans.xml"})
public class YyhEsUtil {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private ArticleMapper mapper;
	
	@Test
	public void es(){
		
		List<Article> selects = mapper.selects_(null);
		for (Article article : selects) {
			
		
		EsUtils.saveObject(elasticsearchTemplate, article.getId().toString(), article);
		}
	}
	
	
}
