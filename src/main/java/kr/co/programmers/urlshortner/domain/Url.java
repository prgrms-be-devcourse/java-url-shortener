package kr.co.programmers.urlshortner.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
//@Table(uniqueConstraints = {@UniqueConstraint(or)})
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private Integer id;

    @Column(name = "original_url", unique = true, nullable = false)
    private String originalUrl;

    @Column(name = "short_url", unique = true, nullable = true)
    private String shortUrl;

    public void setShortUrl(String shortUrl){
        this.shortUrl = shortUrl;
    }



    @Builder
    public Url(String originalUrl, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }

    @Builder
    public Url(String originalUrl){
        this.originalUrl = originalUrl;
    }
}
