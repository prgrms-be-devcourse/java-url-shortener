package kr.co.programmers.urlshortner.service;

import kr.co.programmers.urlshortner.domain.dto.CreateRequestUrl;
import kr.co.programmers.urlshortner.domain.dto.CreateResponseUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UrlServiceTest {

    @Autowired
    private UrlService urlService;

    @Test
    public void test(){
        CreateRequestUrl requestUrl = new CreateRequestUrl("www.naver.com");
        CreateResponseUrl responseUrl = urlService.createShortUrl(requestUrl);

        System.out.println(responseUrl.getShortUrl());

    }

}