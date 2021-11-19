package kr.co.programmers.urlshortner.service;

import kr.co.programmers.urlshortner.domain.Url;
import kr.co.programmers.urlshortner.domain.dto.CreateRequestUrl;
import kr.co.programmers.urlshortner.domain.dto.CreateResponseUrl;
import kr.co.programmers.urlshortner.repository.UrlRepository;
import kr.co.programmers.urlshortner.util.Base62;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UrlService {

    private UrlRepository urlRepository;
    private Base62 base62;

    public CreateResponseUrl createShortUrl(CreateRequestUrl url) {
        Url createdUrl = Url.builder()
                .originalUrl(url.getOriginalUrl())
                .build();

        urlRepository.save(createdUrl);
        createdUrl.setShortUrl(base62.encoding(createdUrl.getId()));

        CreateResponseUrl shortUrl = new CreateResponseUrl(createdUrl.getShortUrl());
        return shortUrl;
    }

}
