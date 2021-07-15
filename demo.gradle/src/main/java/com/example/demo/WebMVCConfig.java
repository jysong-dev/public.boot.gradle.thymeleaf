package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.util.FileUploadUtils;
import com.example.demo.util.LoginInterceptor;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        LoginInterceptor loginIntercepter = new LoginInterceptor();
        
        registry.addInterceptor(loginIntercepter)
                .addPathPatterns("/admin/**")
				.excludePathPatterns("/user/**")
        		.excludePathPatterns("/login")
        		.excludePathPatterns("/logout");
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("file:///" + FileUploadUtils.fileStorePath);
				//.addResourceLocations("file:/DATA/video/"); //리눅스 root에서 시작하는 폴더 경로
	}

}