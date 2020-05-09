package com.yyh.cms.dao;

import java.util.List;

import com.yyh.cms.domain.Slide;
/**
 * 
 * @ClassName: SlideMapper 
 * @Description: 广告
 * @author: dell
 * @date: 2020年5月8日 上午10:05:04
 */
public interface SlideMapper {
	/**
	 * 
	 * @Title: selectsSlides 
	 * @Description: 查询广告
	 * @return
	 * @return: List<Slide>
	 */
	List<Slide> selectsSlides();
}
