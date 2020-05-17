package com.yyh.cms.dao;

import java.util.List;

import com.yyh.cms.domain.Comments;

/**
 * 
 * @ClassName: CommentsMapper 
 * @Description: 评论接口
 * @author: dell
 * @date: 2020年5月10日 上午8:57:05
 */
public interface CommentsMapper {
	/**
	 * 
	 * @Title: intsert 
	 * @Description: 增加评论
	 * @param comments
	 * @return
	 * @return: int
	 */
	int intsert(Comments comments);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据文章查询文章评论
	 * @param articleId
	 * @return
	 * @return: List<Comments>
	 */
	List<Comments> selects(Integer articleId);
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 文章评论数量字段+1
	 * @param articleId
	 * @return
	 * @return: int
	 */
	int updateArticle(Integer articleId);
}
