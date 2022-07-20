package com.example.sbadmin01.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    public String hello(){
        /*URI uri = UriComponentsBuilder
                .fromUriString("http://localhost")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();*/
        URI uri = UriComponentsBuilder
                .fromUriString("https://ehdvudee.tistory.com/50")
                .path("")
                .encode()
                .build()
                .toUri();
        log.info(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
