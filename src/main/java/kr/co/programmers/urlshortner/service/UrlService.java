package kr.co.programmers.urlshortner.service;

import kr.co.programmers.urlshortner.domain.Url;
import kr.co.programmers.urlshortner.domain.dto.CreateRequestUrl;
import kr.co.programmers.urlshortner.repository.UrlRepository;
import kr.co.programmers.urlshortner.util.Base62;
import kr.co.programmers.urlshortner.util.UrlFormatter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final Base62 base62;
    private final UrlFormatter urlFormatter;

    public String createShortUrl(CreateRequestUrl url) {
        Url createdUrl = Url.builder()
                .originalUrl(url.getOriginalUrl())
                .build();
        urlRepository.save(createdUrl);

        String  shortUrl = urlFormatter.format(base62.encoding(createdUrl.getId()));

        return shortUrl;
    }

    public String findOriginalUrl(String shortUrl){
        int id = base62.decoding(shortUrl);

        Url url = urlRepository.findById(id).get();

        return url.getOriginalUrl();
    }

}
