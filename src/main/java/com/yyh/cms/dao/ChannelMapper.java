package com.yyh.cms.dao;

import java.util.List;
/**
 * 
 * @ClassName: ChannelMapper 
 * @Description: 栏目
 * @author: dell
 * @date: 2020年4月29日 下午8:25:01
 */

import com.yyh.cms.domain.Category;
import com.yyh.cms.domain.Channel;
public interface ChannelMapper {
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
	 * @Description: 分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectCategoryByChannelId(Integer channelId);
}
