package com.yyh.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyh.cms.dao.SlideMapper;
import com.yyh.cms.domain.Slide;
import com.yyh.cms.service.SlideService;
/**
 * 
 * @ClassName: SlideServiceImpl 
 * @Description: 广告
 * @author: dell
 * @date: 2020年5月8日 上午10:07:45
 */
@Service
public class SlideServiceImpl implements SlideService {
	
	@Resource
	private SlideMapper slideMapper;
	
	@Override
	public List<Slide> selectsSlides() {
		// TODO Auto-generated method stub
		return slideMapper.selectsSlides();
	}

}
