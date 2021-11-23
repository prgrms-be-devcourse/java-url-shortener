package kr.co.programmers.urlshortner;

import kr.co.programmers.urlshortner.domain.UrlHolder;
import kr.co.programmers.urlshortner.utils.Base62;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlHolder getUrlHolder(String origin) {
        UrlHolder urlHolder = new UrlHolder(origin);
        UrlHolder saved = urlRepository.save(urlHolder);
        saved.setEncodedUrl(Base62.encode(saved.getId()));
        return saved;
    }

    @Transactional(readOnly = true
    )
    public UrlHolder getUrlHolder(Long id) {
        return urlRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No such id = " + id));
    }

    @Transactional(readOnly = true)
    public String getOriginUrl(long id) {
        UrlHolder urlHolder = urlRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No such id = " + id));
        return urlHolder.getOrigin();
    }

    public void changeOriginUrl(String origin) {
        UrlHolder urlHolder = urlRepository.findByOrigin(origin)
            .orElseThrow(() -> new IllegalArgumentException("No such url = " + urlRepository));
        urlHolder.changeOriginUrl(origin);
    }

    public void update(Long id, UrlHolder urlHolder) {
        UrlHolder findUrlHolder = urlRepository.findById(id).orElseThrow();
        findUrlHolder.changeOriginUrl(urlHolder.getOrigin());
    }
}
