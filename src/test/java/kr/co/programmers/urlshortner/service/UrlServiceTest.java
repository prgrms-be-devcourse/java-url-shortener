package kr.co.programmers.urlshortner.service;

import kr.co.programmers.urlshortner.domain.dto.CreateRequestUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlServiceTest {

    @Autowired
    private UrlService urlService;

    @Test
    public void test(){
        CreateRequestUrl requestUrl = new CreateRequestUrl("www.naver.com");
        String responseUrl = urlService.createShortUrl(requestUrl);
//
        System.out.println(responseUrl);
//
//        String findUrl = urlService.findShortUrlByOriginalUrl(new FindRequestUrl("www.naver.com")).getShortUrl();
//        System.out.println(findUrl);
    }
}