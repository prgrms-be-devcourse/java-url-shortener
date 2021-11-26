package kr.co.programmers.urlshortner.repository;

import kr.co.programmers.urlshortner.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
    Optional<Url> findByOriginalUrl(String originalUrl);
}
