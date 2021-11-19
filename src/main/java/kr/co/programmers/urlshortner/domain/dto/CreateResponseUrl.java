package kr.co.programmers.urlshortner.domain.dto;

import lombok.Getter;

@Getter
public class CreateResponseUrl {
    private String shortUrl;

    public CreateResponseUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
