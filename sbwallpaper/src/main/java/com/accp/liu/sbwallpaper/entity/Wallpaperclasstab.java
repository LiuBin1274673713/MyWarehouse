package com.accp.liu.sbwallpaper.entity;

public class Wallpaperclasstab {
    private Integer wallpaperclassid;

    private String wallpaperclassname;

    private Wallpapertab wallpapertab;
    
    public Wallpapertab getWallpapertab() {
		return wallpapertab;
	}

	public void setWallpapertab(Wallpapertab wallpapertab) {
		this.wallpapertab = wallpapertab;
	}

	public Integer getWallpaperclassid() {
        return wallpaperclassid;
    }

    public void setWallpaperclassid(Integer wallpaperclassid) {
        this.wallpaperclassid = wallpaperclassid;
    }

    public String getWallpaperclassname() {
        return wallpaperclassname;
    }

    public void setWallpaperclassname(String wallpaperclassname) {
        this.wallpaperclassname = wallpaperclassname == null ? null : wallpaperclassname.trim();
    }
}