package kr.co.programmers.urlshortner;

import kr.co.programmers.urlshortner.domain.UrlHolder;
import kr.co.programmers.urlshortner.utils.Base62;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String getEncodedUrl(String origin) {
        UrlHolder urlHolder = new UrlHolder(origin);
        UrlHolder saved = urlRepository.save(urlHolder);
        saved.setEncodedUrl(Base62.encode(saved.getId()));
        return saved.getEncodedUrl();
    }

    public String getOriginUrl(long id) {
        UrlHolder urlHolder = urlRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No such id = " + id));
        return urlHolder.getOrigin();
    }
}
