package com.yyh.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yyh.cms.domain.Comments;

/**
 * 
 * @ClassName: CommentsService 
 * @Description: TODO
 * @author: dell
 * @date: 2020年5月10日 上午9:04:51
 */
public interface CommentsService {
	
	/**
	 * 
	 * @Title: intsert 
	 * @Description: 增加评论
	 * @param comments
	 * @return
	 * @return: int
	 */
	boolean intsert(Comments comments);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 获取所有评论
	 * @param articleId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Comments>
	 */
	PageInfo<Comments> selects(Integer articleId,Integer pageNum,Integer pageSize);
	
}
