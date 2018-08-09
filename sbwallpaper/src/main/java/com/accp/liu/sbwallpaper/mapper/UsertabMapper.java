package com.accp.liu.sbwallpaper.mapper;

import com.accp.liu.sbwallpaper.entity.Usertab;

public interface UsertabMapper {
    int deleteByPrimaryKey(String userid);

    int insertSelective(Usertab record);

    Usertab selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(Usertab record);
}