package kr.co.programmers.urlshortner.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "origin_url", nullable = false)
    private String originUrl;

    @Column(name = "shorten_url")
    private String shortenUrl;

    @Column(name = "view_count")
    private Long viewCount = 0L;

    @Builder
    public Url(Long id, String originUrl, String shortenUrl, Long viewCount) {
        this.id = id;
        this.originUrl = originUrl;
        this.shortenUrl = shortenUrl;
        this.viewCount = viewCount;
    }

}
