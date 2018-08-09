package com.accp.liu.sbwallpaper;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.github.pagehelper.PageHelper;

@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter{

	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		// TODO Auto-generated method stub
//		 registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF/");  
//	     registry.addResourceHandler("*.jsp").addResourceLocations("/");  
//		super.addResourceHandlers(registry);
//	}

		//������ͼ������
		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setViewClass(JstlView.class);
			resolver.setPrefix("/WEB-INF/page/");
			resolver.setSuffix(".jsp");
			
			registry.viewResolver(resolver);
			
			super.configureViewResolvers(registry);
		}
		
		//���þ�̬��Դ����<mvc:default-servlet-handler />
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
			// TODO Auto-generated method stub
			super.configureDefaultServletHandling(configurer);
		}
		
		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			{
				//Stringת����
				StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("utf-8"));
				List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
				//������Ӧͷ���룬text/html;charset=utf-8
				supportedMediaTypes.add(new MediaType(MediaType.TEXT_HTML, Charset.defaultCharset()));
				converter.setSupportedMediaTypes(supportedMediaTypes);
				
				converters.add(converter);
			}
			
			{
				//����fastjson
				FastJsonHttpMessageConverter4 converter4 = new FastJsonHttpMessageConverter4();
				
				//conttype������
				List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
			       supportedMediaTypes.add(MediaType.APPLICATION_JSON);
			       supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
			       supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
			       supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
			       supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
			       supportedMediaTypes.add(MediaType.APPLICATION_PDF);
			       supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
			       supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
			       supportedMediaTypes.add(MediaType.APPLICATION_XML);
			       supportedMediaTypes.add(MediaType.IMAGE_GIF);
			       supportedMediaTypes.add(MediaType.IMAGE_JPEG);
			       supportedMediaTypes.add(MediaType.IMAGE_PNG);
			       supportedMediaTypes.add(MediaType.TEXT_PLAIN);
			       supportedMediaTypes.add(MediaType.TEXT_HTML);
			       supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
			       supportedMediaTypes.add(MediaType.TEXT_PLAIN);
			       supportedMediaTypes.add(MediaType.TEXT_XML); 
			    converter4.setSupportedMediaTypes(supportedMediaTypes);
			    
			    //�ر��ظ�����,�ظ��������õ�ַҳ����ʾ�����ַ
			    JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
			    
			    //���ñ���
				converter4.setDefaultCharset(Charset.forName("utf-8"));
				FastJsonConfig fastJsonConfig = new FastJsonConfig();
//				fastJsonConfig.setDateFormat("yyy-MM-dd");
				converter4.setFastJsonConfig(fastJsonConfig);
				converters.add(converter4);
			}
			super.configureMessageConverters(converters);
		}
		
		@MapperScan("com.accp.liu.sbwallpaper.mapper")
		@PropertySource("classpath:database.properties")
		public class MybatisConfiguration {

			//���ڶ�ȡ*.properties�ļ� ������springע��
			@Autowired
			Environment env;
			
			/**
			 * ��ȡ����Դ
			 * @return
			 */
			@Bean
			public DataSource dataSource() {
				DriverManagerDataSource datasource=new DriverManagerDataSource(env.getProperty("url"),
						env.getProperty("name"),
						env.getProperty("password"));
				datasource.setDriverClassName(env.getProperty("driverName"));
				return datasource;
			}
			
			
			@Bean
			public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
				SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
				sqlSessionFactoryBean.setDataSource(dataSource);
				//���ñ�����
				sqlSessionFactoryBean.setTypeAliasesPackage("com.accp.liu.sbwallpaper.entity");
				
				//��ȡmybatis��xml�����ļ�
				//sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
				
				//���÷�ҳ���
				PageHelper pagehelper=new PageHelper();
				Properties properties=new Properties();
				properties.setProperty("dialect", "mysql");
				pagehelper.setProperties(properties);
				
				sqlSessionFactoryBean.setPlugins(new Interceptor[] {pagehelper});
				return sqlSessionFactoryBean;
			}
			
			@Bean
			public CommonsMultipartResolver multipartResolver() {
				CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
				commonsMultipartResolver.setMaxInMemorySize(104857600);
				commonsMultipartResolver.setMaxUploadSize(104857600);
				commonsMultipartResolver.setDefaultEncoding("UTF-8");
				return commonsMultipartResolver;
			}
		}
		
}
