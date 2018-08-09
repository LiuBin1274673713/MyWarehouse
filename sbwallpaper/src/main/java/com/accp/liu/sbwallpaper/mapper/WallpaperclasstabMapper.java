package com.accp.liu.sbwallpaper.mapper;

import java.util.List;

import com.accp.liu.sbwallpaper.entity.Wallpaperclasstab;

public interface WallpaperclasstabMapper {
    int deleteByPrimaryKey(Integer wallpaperclassid);

    int insert(Wallpaperclasstab record);

    int insertSelective(Wallpaperclasstab record);

    Wallpaperclasstab selectByPrimaryKey(Integer wallpaperclassid);
    
    List<Wallpaperclasstab> selectAll();

    int updateByPrimaryKeySelective(Wallpaperclasstab record);

    int updateByPrimaryKey(Wallpaperclasstab record);
}