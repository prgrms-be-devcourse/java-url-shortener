package kr.co.programmers.urlshortner.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import kr.co.programmers.urlshortner.dto.UrlRequest;
import kr.co.programmers.urlshortner.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    @ResponseBody
    public String createShortenUrl(@RequestBody UrlRequest urlRequest) {
        return urlService.createShortenUrl(urlRequest.getUrl());
    }


    @GetMapping("/{shortenUrl}")
    public void callShortenUrl(@PathVariable("shortenUrl") String shortenUrl, HttpServletResponse response) throws IOException {
        String originalUrl = urlService.findOriginalUrl(shortenUrl);

        response.setStatus(HttpStatus.PERMANENT_REDIRECT.value());
        response.sendRedirect(originalUrl);
    }


}
