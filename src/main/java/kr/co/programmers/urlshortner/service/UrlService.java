package kr.co.programmers.urlshortner.service;

import java.util.List;
import kr.co.programmers.urlshortner.domain.Url;
import kr.co.programmers.urlshortner.domain.UrlRepository;
import kr.co.programmers.urlshortner.util.Base62;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UrlService {

    private final UrlRepository urlRepository;

    @Transactional
    public String createShortenUrl(String originUrl) {
        List<Url> foundUrls = urlRepository.findUrlByOrOriginUrl(originUrl);
        // 이미 등록된 URL 이라면 등록되어있는 단축 URL을 반환한다.
        if(foundUrls.size() > 0) {
            return foundUrls.get(0).getShortenUrl();
        }

        Url savedUrl = urlRepository.save(
                Url.builder()
                .originUrl(originUrl)
                .build()
        );

        // 저장된 ID를 가지고 인코딩을 통해 Shorten URL을 만든다.
        savedUrl.updateShortenUrl(Base62.encodeToLong(savedUrl.getId()));

        return savedUrl.getShortenUrl();
    }

}
