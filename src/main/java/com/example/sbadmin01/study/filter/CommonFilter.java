package com.example.sbadmin01.study.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 유일하게 ServletRequest, ServletResponse의 객체를 변환 할 수 있다.
 * 주로 request, response Logging용도로 활용하거나 , 인증과 관련된 Logic 처리
 */
@Slf4j
@Component
@WebFilter(urlPatterns = "/study/api/*")
public class CommonFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 전처리

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);
        String url = httpServletRequest.getRequestURI();

        // 한번 읽어버리면 사용을 못하기 때문에 조치 - ContentCachingRequestWrapper 몇번이든 읽을 수 있음
        /*BufferedReader br = httpServletRequest.getReader();

        log.info("#####filter test#####");
        br.lines().forEach(line ->{
            log.info("url: {}, line: {}", url, line);
        });*/

        filterChain.doFilter(servletRequest, servletResponse);

        // 후처리
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url:{}, requestBody: {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();
        log.info("response status:{}, responseBody: {}", httpStatus, resContent);
        //httpServletResponse

    }
}
