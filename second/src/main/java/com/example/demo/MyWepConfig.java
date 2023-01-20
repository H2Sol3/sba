package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration //내가 설정클래스 파일
public class MyWepConfig implements WebMvcConfigurer {

	//	<resources mapping="/upload/**" location="file:///c:/upload/" ></resources>
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
	}

}
