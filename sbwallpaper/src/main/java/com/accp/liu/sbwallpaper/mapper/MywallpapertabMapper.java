package com.accp.liu.sbwallpaper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.liu.sbwallpaper.entity.Mywallpapertab;

public interface MywallpapertabMapper {
    int deleteByPrimaryKey(Integer mywallpaperid);

    int insert(Mywallpapertab record);

    int insertSelective(Mywallpapertab record);

    Mywallpapertab selectByPrimaryKey(Integer mywallpaperid);
    
    List<Mywallpapertab> selectAll(String userid);
    
    Mywallpapertab selectMyUse(@Param("userid") String userid,@Param("wallpaperid") Integer wallpaperid);

    int updateByPrimaryKeySelective(Mywallpapertab record);

    int updateByPrimaryKey(Mywallpapertab record);
}