package com.accp.liu.sbwallpaper.entity;

import java.util.Date;

public class Mycomment {
    private Integer mycommentid;

    private Integer wallpaperid;

    private String userid;

    private Date commentdate;

    private String commenttext;
    
    private Usertab user;

    public Usertab getUser() {
		return user;
	}

	public void setUser(Usertab user) {
		this.user = user;
	}

	public Integer getMycommentid() {
        return mycommentid;
    }

    public void setMycommentid(Integer mycommentid) {
        this.mycommentid = mycommentid;
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

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext == null ? null : commenttext.trim();
    }
}