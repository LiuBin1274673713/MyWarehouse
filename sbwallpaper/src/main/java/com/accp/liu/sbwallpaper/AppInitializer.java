package com.accp.liu.sbwallpaper;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 取代web.xml
 * @author Administrator
 *
 */
public class AppInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context=null;
		{
			//注册配置文件，启动上下文
			context = new AnnotationConfigWebApplicationContext();
			//指定主配置文件
			context.register(AppConfiguration.class);
		}
		{
			//注册DispatcherServlet
			DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
			ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
			servlet.setLoadOnStartup(1);
			servlet.addMapping("/");
		}
		{
			//注册过滤器
			CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("utf-8");
			
			FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
			//过滤器拦截路径
			filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		}
		
	}

}
