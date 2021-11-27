package kr.co.programmers.urlshortner.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

    List<Url> findUrlByOrOriginUrl(String originUrl);

}
