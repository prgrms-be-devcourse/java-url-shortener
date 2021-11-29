package kr.co.programmers.urlshortner.util;

import org.springframework.stereotype.Component;

@Component
public class UrlFormatter {
    private final String host = "localhost";
    private final String port = "8080";

    public String format(String shortUrl) {
        return "http://" + host + ":" + port + "/" + shortUrl;
    }
}
