package kr.co.programmers.urlshortner.controller;

import kr.co.programmers.urlshortner.domain.dto.CreateRequestUrl;
import kr.co.programmers.urlshortner.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private  final UrlService urlService;

//    @PostMapping("/api/url")
//    public ResponseEntity<String> createShortUrl(@RequestBody CreateRequestUrl requestUrl){
//        String shortUrl = urlService.createShortUrl(requestUrl);
//
//        return ResponseEntity.ok(shortUrl);
//    }

    @PostMapping("/api/url")
    public String createShortUrl(@RequestBody CreateRequestUrl requestUrl){
        String shortUrl = urlService.createShortUrl(requestUrl);
        return shortUrl;
    }


    @GetMapping("/{shorten}")
    public void redirect(@PathVariable(value = "shorten") String shorten, HttpServletResponse httpServletResponse)
            throws IOException{
        String originalUrl = urlService.findOriginalUrl(shorten);
        httpServletResponse.sendRedirect(originalUrl);
    }

}
