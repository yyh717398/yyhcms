package com.yyh.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyh.cms.dao.CommentsMapper;
import com.yyh.cms.domain.Comments;
import com.yyh.cms.service.CommentsService;
import com.yyh.cms.util.CMSException;
/**
 * 
 * @ClassName: CommentsServiceImpl 
 * @Description: TODO
 * @author: dell
 * @date: 2020年5月10日 上午9:06:01
 */

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Resource
	private CommentsMapper commentsMapper;
	
	@Override
	public boolean intsert(Comments comments) {
		try {
			//1 增加评论表
			commentsMapper.intsert(comments);
			//2更新文章表comments数值 递增1
			commentsMapper.updateArticle(comments.getArticleId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMSException("评论失败");
		}
		
	}

	@Override
	public PageInfo<Comments> selects(Integer articleId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<>(commentsMapper.selects(articleId));
	}
	
	

}
