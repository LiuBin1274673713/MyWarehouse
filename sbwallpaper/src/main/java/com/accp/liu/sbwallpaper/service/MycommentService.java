package com.accp.liu.sbwallpaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.liu.sbwallpaper.entity.Mycomment;
import com.accp.liu.sbwallpaper.mapper.MycommentMapper;

@Service
public class MycommentService {

	@Autowired
	MycommentMapper mycommentMapper;
	
	public List<Mycomment> selectWallpaperComment(Integer wallpaperid){
		return mycommentMapper.selectWallpaperComment(wallpaperid);
	}
	
	public int insertSelective(Mycomment record) {
		return mycommentMapper.insertSelective(record);
	}
	
	public Mycomment selectByPrimaryKey(Integer mycommentid) {
		return mycommentMapper.selectByPrimaryKey(mycommentid);
	}
}
