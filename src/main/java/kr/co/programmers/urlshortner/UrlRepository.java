package kr.co.programmers.urlshortner;

import java.util.Optional;
import kr.co.programmers.urlshortner.domain.UrlHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlHolder, Long> {

    Optional<UrlHolder> findByOrigin(String origin);
}
