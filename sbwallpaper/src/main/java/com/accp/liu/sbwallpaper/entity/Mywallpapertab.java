package com.accp.liu.sbwallpaper.entity;

import java.util.Date;

public class Mywallpapertab {
    private Integer mywallpaperid;

    private Integer wallpaperid;

    private String userid;

    private Date usedate;
    
    private Wallpapertab wallpapertab;

    public Wallpapertab getWallpapertab() {
		return wallpapertab;
	}

	public void setWallpapertab(Wallpapertab wallpapertab) {
		this.wallpapertab = wallpapertab;
	}

	public Integer getMywallpaperid() {
        return mywallpaperid;
    }

    public void setMywallpaperid(Integer mywallpaperid) {
        this.mywallpaperid = mywallpaperid;
    }

    public Integer getWallpaperid() {
        return wallpaperid;
    }

    public void setWallpaperid(Integer wallpaperid) {
        this.wallpaperid = wallpaperid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getUsedate() {
        return usedate;
    }

    public void setUsedate(Date usedate) {
        this.usedate = usedate;
    }
}