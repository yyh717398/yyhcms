package com.yyh.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyh.cms.dao.ChannelMapper;
import com.yyh.cms.domain.Category;
import com.yyh.cms.domain.Channel;
import com.yyh.cms.service.ChannelService;
/**
 * 
 * @ClassName: ChannelServiceImpl 
 * @Description: TODO
 * @author: dell
 * @date: 2020年4月29日 下午8:29:54
 */
@Service
public class ChannelServiceImpl implements ChannelService{
	
	@Autowired 
	private ChannelMapper channelMapper;
	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelMapper.selects();
	}

	@Override
	public List<Category> selectCategoryByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return channelMapper.selectCategoryByChannelId(channelId);
	}

	


	

}
