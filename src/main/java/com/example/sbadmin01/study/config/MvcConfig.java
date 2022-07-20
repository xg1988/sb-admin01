package com.example.sbadmin01.study.config;

import com.example.sbadmin01.study.filter.CommonInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor // CommonInterceptor - 생성자 주입 (Autowired하거나- 순환참조 가능성)
public class MvcConfig implements WebMvcConfigurer {

    private final CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(commonInterceptor).addPathPatterns("/api/private/*");
    }
}
