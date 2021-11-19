package kr.co.programmers.urlshortner.repository;

import kr.co.programmers.urlshortner.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
}
