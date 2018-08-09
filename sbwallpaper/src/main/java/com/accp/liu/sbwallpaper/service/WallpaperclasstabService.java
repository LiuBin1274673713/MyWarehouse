package com.accp.liu.sbwallpaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.liu.sbwallpaper.entity.Wallpaperclasstab;
import com.accp.liu.sbwallpaper.mapper.WallpaperclasstabMapper;

@Service
public class WallpaperclasstabService {

	@Autowired
	WallpaperclasstabMapper wallpaperclasstabMapper;
	
	public List<Wallpaperclasstab> selectAll(){
		return wallpaperclasstabMapper.selectAll();
	}
}
