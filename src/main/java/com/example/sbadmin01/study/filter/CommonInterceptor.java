package com.example.sbadmin01.study.filter;

import com.example.sbadmin01.study.annotation.Auth;
import com.example.sbadmin01.study.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * 스프링 컨텍스트에 등록된다 AOP와 유사한 기능 제공
 * 인증 단계, 로깅 선/후처리로 서비스 비즈니스 로직과 분리(서비스는 서비스로직에만 집중)
 */
@Slf4j
@Component
public class CommonInterceptor implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler --> 정보들을 활용해야한다.
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 필터에서 선언했기 때문에 형변환이 가능하다.
        //(ContentCachingRequestWrapper) request;

        String url = request.getRequestURI();
        log.info("request url: {}", url);

        URI uri = UriComponentsBuilder.fromUriString(url)
                .query(request.getQueryString())
                .build()
                .toUri();

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("hasAnnotation: {}", hasAnnotation);

        // 나의 서버는 모두 public 동작
        // 단 Auth권한을 가진 요청은 쿠키, 세션등 검증
        if(hasAnnotation){
            //권한 체크

            String query = uri.getQuery();
            if(query.equals("name=steve")){
                return true;
            }

            throw new AuthException();

        }

        // false가 리턴될 경우 컨트롤러까지 닿지 않는다.
        return true;
    }

    public boolean checkAnnotation(Object handler, Class clazz){
        // resource javascript, html .. etc
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(null != handlerMethod.getMethodAnnotation(clazz)
        || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            //Auth annotation 있을 경우 true
            return true;
        }

        return false;
    }
}
