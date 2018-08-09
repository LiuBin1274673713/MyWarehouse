package com.accp.liu.sbwallpaper.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accp.liu.sbwallpaper.entity.Mywallpapertab;
import com.accp.liu.sbwallpaper.mapper.MywallpapertabMapper;

@Service
public class MywallpapertabService {

	@Autowired
	MywallpapertabMapper mywallpapertabMapper;
	
	public List<Mywallpapertab> selectAll(String userid){
		return mywallpapertabMapper.selectAll(userid);
	}
	
	public int insertSelective(Mywallpapertab record) {
		return mywallpapertabMapper.insertSelective(record);
	}
	
	public int updateByPrimaryKeySelective(Mywallpapertab record) {
		return mywallpapertabMapper.updateByPrimaryKeySelective(record);
	}
	
	public Mywallpapertab selectMyUse(String userid,Integer wallpaperid) {
		return mywallpapertabMapper.selectMyUse(userid, wallpaperid);
	}
	
}
