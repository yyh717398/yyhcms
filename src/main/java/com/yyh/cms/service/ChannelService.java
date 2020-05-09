package com.yyh.cms.service;

import java.util.List;

import com.yyh.cms.dao.ChannelMapper;
import com.yyh.cms.domain.Category;
import com.yyh.cms.domain.Channel;

public interface ChannelService {
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有栏目
	 * @return
	 * @return: List<ChannelMapper>
	 */
	List<Channel> selects();
	/**
	 * 
	 * @Title: selectCategoryByChannelId 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectCategoryByChannelId(Integer channelId);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
}
