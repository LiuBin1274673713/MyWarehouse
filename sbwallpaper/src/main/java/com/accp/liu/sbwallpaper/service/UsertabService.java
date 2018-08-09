package com.accp.liu.sbwallpaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.liu.sbwallpaper.entity.Usertab;
import com.accp.liu.sbwallpaper.mapper.UsertabMapper;

@Service
public class UsertabService {

	@Autowired
	UsertabMapper usertabMapper;
	public Usertab selectByPrimaryKey(String userid) {
		return usertabMapper.selectByPrimaryKey(userid);
	}
	
	public int insertSelective(Usertab record) {
		return usertabMapper.insertSelective(record);
	}
}
