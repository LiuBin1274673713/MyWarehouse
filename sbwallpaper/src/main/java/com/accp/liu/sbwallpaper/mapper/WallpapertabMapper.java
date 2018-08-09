package com.accp.liu.sbwallpaper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.liu.sbwallpaper.entity.Wallpapertab;

public interface WallpapertabMapper {
    int deleteByPrimaryKey(Integer wallpaperid);

    int insert(Wallpapertab record);

    int insertSelective(Wallpapertab record);

    Wallpapertab selectByPrimaryKey(Integer wallpaperid);
    
    List<Wallpapertab> selectRecommend();
    
    List<Wallpapertab> selectClassAll(Integer wallpaperclassid);
    
    List<Wallpapertab> selectTop(@Param("type") Integer type);

    int updateByPrimaryKeySelective(Wallpapertab record);

    int updateByPrimaryKey(Wallpapertab record);
}