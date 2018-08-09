package com.accp.liu.sbwallpaper.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Wallpapertab {
    private Integer wallpaperid;

    private String wallpapername;

    private String uploaduser;

    private Integer downloadsum;

    private Integer wallpaperclassid;

    private Double wallpaperprice;

    @JSONField(format="yyyy-MM-dd")
    private Date uploaddate;

    private String wallpaperurl;
    
    private Usertab usertab;

    public Usertab getUsertab() {
		return usertab;
	}

	public void setUsertab(Usertab usertab) {
		this.usertab = usertab;
	}

	public Integer getWallpaperid() {
        return wallpaperid;
    }

    public void setWallpaperid(Integer wallpaperid) {
        this.wallpaperid = wallpaperid;
    }

    public String getWallpapername() {
        return wallpapername;
    }

    public void setWallpapername(String wallpapername) {
        this.wallpapername = wallpapername == null ? null : wallpapername.trim();
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser == null ? null : uploaduser.trim();
    }

    public Integer getDownloadsum() {
        return downloadsum;
    }

    public void setDownloadsum(Integer downloadsum) {
        this.downloadsum = downloadsum;
    }

    public Integer getWallpaperclassid() {
        return wallpaperclassid;
    }

    public void setWallpaperclassid(Integer wallpaperclassid) {
        this.wallpaperclassid = wallpaperclassid;
    }

    public Double getWallpaperprice() {
        return wallpaperprice;
    }

    public void setWallpaperprice(Double wallpaperprice) {
        this.wallpaperprice = wallpaperprice;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getWallpaperurl() {
        return wallpaperurl;
    }

    public void setWallpaperurl(String wallpaperurl) {
        this.wallpaperurl = wallpaperurl == null ? null : wallpaperurl.trim();
    }
}