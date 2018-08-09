package com.accp.liu.sbwallpaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.liu.sbwallpaper.entity.Wallpapertab;
import com.accp.liu.sbwallpaper.mapper.WallpapertabMapper;

@Service
public class WallpapertabService {

	@Autowired
	WallpapertabMapper wallpapertabMapper;
	public List<Wallpapertab> selectRecommend(){
		return wallpapertabMapper.selectRecommend();
	}
	
	public int updateByPrimaryKeySelective(Wallpapertab record) {
		return wallpapertabMapper.updateByPrimaryKeySelective(record);
	}
	
	public  Wallpapertab selectByPrimaryKey(Integer wallpaperid) {
		return wallpapertabMapper.selectByPrimaryKey(wallpaperid);
	}
	
	public List<Wallpapertab> selectClassAll(Integer wallpaperclassid){
		return wallpapertabMapper.selectClassAll(wallpaperclassid);
	}
	
	public int insertSelective(Wallpapertab record) {
		return wallpapertabMapper.insertSelective(record);
	}
	
	public List<Wallpapertab> selectTop(Integer type){
		return wallpapertabMapper.selectTop(type);
	}
	
}
