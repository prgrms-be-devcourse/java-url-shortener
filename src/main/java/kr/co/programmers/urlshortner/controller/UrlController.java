package kr.co.programmers.urlshortner.controller;

import kr.co.programmers.urlshortner.dto.UrlRequest;
import kr.co.programmers.urlshortner.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    public String createShortenUrl(@RequestBody UrlRequest urlRequest) {
        return urlService.createShortenUrl(urlRequest.getUrl());
    }

}
