package com.accp.liu.sbwallpaper.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accp.liu.sbwallpaper.entity.Encodes;
import com.accp.liu.sbwallpaper.entity.Mycomment;
import com.accp.liu.sbwallpaper.entity.Mywallpapertab;
import com.accp.liu.sbwallpaper.entity.Usertab;
import com.accp.liu.sbwallpaper.entity.Wallpaperclasstab;
import com.accp.liu.sbwallpaper.entity.Wallpapertab;
import com.accp.liu.sbwallpaper.service.MycommentService;
import com.accp.liu.sbwallpaper.service.MywallpapertabService;
import com.accp.liu.sbwallpaper.service.UsertabService;
import com.accp.liu.sbwallpaper.service.WallpaperclasstabService;
import com.accp.liu.sbwallpaper.service.WallpapertabService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/sbwallpaper/testing/")
public class ControllerAPI {

	@Autowired
	UsertabService usertabService;
	@Autowired
	WallpapertabService wallpapertabService;
	@Autowired
	WallpaperclasstabService wallpaperclasstabService;
	@Autowired
	MywallpapertabService mywallpapertabService;
	@Autowired
	MycommentService mycommentService;
	
	@RequestMapping("login")
	public Object login(Usertab user,HttpSession session) {
		Usertab userM=usertabService.selectByPrimaryKey(user.getUserid());
		if(userM==null) {
			int res=usertabService.insertSelective(user);
			if(res==1)
				userM=usertabService.selectByPrimaryKey(user.getUserid());
		}
		session.setAttribute("userM", userM);
		return userM;
	}
	@RequestMapping(value="imgupload")
	public Object imgUpload(@RequestParam String imgBase64Data,String wallpapername,Integer wallpaperclassid, HttpServletRequest request){
	    String res="";
	    HttpSession session=request.getSession();
	    Usertab userM=(Usertab)session.getAttribute("userM");
	    Wallpapertab addObject=new Wallpapertab();
	    try {

	        if(imgBase64Data == null || "".equals(imgBase64Data)){
	        	return res="上传失败，上传图片数据为空！";
	        }
	       String projectPath = request.getSession().getServletContext().getRealPath("/");
	        String imgFilePath ="/img/";
	        File uploadPathFile = new File(projectPath+imgFilePath);

	        //创建父类文件
	        if(!uploadPathFile.exists() && !uploadPathFile.isDirectory()){
	            uploadPathFile.mkdirs();
	        }
	        String imgname=new Date().getTime()+".jpg";
	        File imgeFile = new File(projectPath+imgFilePath,imgname);
	        if(!imgeFile.exists()){
	            imgeFile.createNewFile();
	        }
	        {
		        addObject.setWallpapername(wallpapername);
			    addObject.setWallpaperclassid(wallpaperclassid);
			    addObject.setUploaddate(new Date());
			    addObject.setUploaduser(userM.getUserid());
			    addObject.setWallpaperurl("img/"+imgname);
	        }
	        //对base64进行解码
	        byte[] result = Encodes.decodeBase64(imgBase64Data);
	        //使用Apache提供的工具类将图片写到指定路径下
	        FileUtils.writeByteArrayToFile(imgeFile,result);
	        res=imgFilePath+imgeFile.getName();
	        wallpapertabService.insertSelective(addObject);
	    }catch (Exception e){
	        e.printStackTrace();
	        res="上传失败，系统异常";
	    }
	    return res;
	}

	@RequestMapping("selectRecommend")
	public Object selectRecommend() {
		return wallpapertabService.selectRecommend();
	}
	
	@RequestMapping("updateWallpapertab/{val}")
	public int updateWallpapertab(@PathVariable Integer val,HttpSession session) {
		Usertab userM=(Usertab) session.getAttribute("userM");
		Wallpapertab wallpapertab=wallpapertabService.selectByPrimaryKey(val);
		wallpapertab.setDownloadsum(wallpapertab.getDownloadsum()+1);
		wallpapertabService.updateByPrimaryKeySelective(wallpapertab);
		
		Mywallpapertab mywallpapertab=mywallpapertabService.selectMyUse(userM.getUserid(), val);
		if(mywallpapertab==null) {
			mywallpapertab=new Mywallpapertab();
			mywallpapertab.setUsedate(new Date());
			mywallpapertab.setUserid(userM.getUserid());
			mywallpapertab.setWallpaperid(val);
			mywallpapertabService.insertSelective(mywallpapertab);
		}else {
			mywallpapertab.setUsedate(new Date());
			mywallpapertabService.updateByPrimaryKeySelective(mywallpapertab);
		}
		return wallpapertab.getDownloadsum();
	}
	
	@RequestMapping("selectWallpapertabByid/{val}")
	public Object selectWallpapertabByid(@PathVariable Integer val) {
		Wallpapertab wallpapertab=wallpapertabService.selectByPrimaryKey(val);
		return wallpapertab;
	}
	
	@RequestMapping("selectWallpaperclassAll")
	public Object selectWallpaperclassAll() {
		List<Wallpaperclasstab> wallpaperclasstab=wallpaperclasstabService.selectAll();
		return wallpaperclasstab;
	}
	
	@RequestMapping("selectClassAllWallpaper/{val}")
	public Object selectClassAllWallpaper(@PathVariable Integer val) {
		return wallpapertabService.selectClassAll(val);
	}
	
	@RequestMapping("selectMyAllWallpaper")
	public Object selectMyAllWallpaper(HttpSession session) {
		Usertab userM=(Usertab) session.getAttribute("userM");
		return mywallpapertabService.selectAll(userM.getUserid());
	}
	
	@RequestMapping("selectWallpaperComment/{val}")
	public Object selectWallpaperComment(@PathVariable Integer val) {
		return mycommentService.selectWallpaperComment(val);
	}
	
	@RequestMapping("insertWallpaperComment")
	public Object insertWallpaperComment(Mycomment record,HttpSession session) {
		Usertab userM=(Usertab) session.getAttribute("userM");
		record.setUserid(userM.getUserid());
		record.setCommentdate(new Date());
		int res=mycommentService.insertSelective(record);
		Mycomment resMycomment=new Mycomment();
		if(res>0) {
			resMycomment=mycommentService.selectByPrimaryKey(record.getMycommentid());
		}
		return resMycomment;
	}
	
	@RequestMapping("selectWallpaperTop")
	public Object selectWallpaperTop(Integer type,Integer pages) {
		PageHelper.startPage(pages, 6);
		List<Wallpapertab> list=wallpapertabService.selectTop(type);
		PageInfo<Wallpapertab> pageinfo=new PageInfo<Wallpapertab>(list);
		return pageinfo;
	}
	

}
