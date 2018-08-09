package com.accp.liu.sbwallpaper.mapper;

import java.util.List;

import com.accp.liu.sbwallpaper.entity.Mycomment;

public interface MycommentMapper {
    int deleteByPrimaryKey(Integer mycommentid);

    int insertSelective(Mycomment record);

    Mycomment selectByPrimaryKey(Integer mycommentid);
    
    List<Mycomment> selectWallpaperComment(Integer wallpaperid);

    int updateByPrimaryKeySelective(Mycomment record);

}