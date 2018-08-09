package com.accp.liu.sbwallpaper.entity;

public class Usertab {
    private String userid;

    private String username;
    
    private String userhead;

    private Double sbsum;

    public String getUserhead() {
		return userhead;
	}

	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}

	public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getSbsum() {
        return sbsum;
    }

    public void setSbsum(Double sbsum) {
        this.sbsum = sbsum;
    }
}