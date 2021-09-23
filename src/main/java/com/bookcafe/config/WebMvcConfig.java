package com.bookcafe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bookcafe.common.FileManagerSurvice;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**") // http://localhost/images/1_1620995857660/sun.png �� 媛숈씠 �젒洹� 媛��뒫�븯寃� 留ㅽ븨�빐以��떎. 
		.addResourceLocations("file:///"+FileManagerSurvice.FILE_UPLOAD_PATH);
		//실제 파일 저장위치
	}
	
}
