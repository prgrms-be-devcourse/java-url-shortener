package kr.co.programmers.urlshortner.domain.dto;

import lombok.Getter;

@Getter
public class CreateRequestUrl {
    private String originalUrl;

    public CreateRequestUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
