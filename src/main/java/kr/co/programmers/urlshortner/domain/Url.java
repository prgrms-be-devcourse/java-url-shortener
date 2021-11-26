package kr.co.programmers.urlshortner.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private Integer id;

    @Column(name = "original_url", unique = true, nullable = false)
    private String originalUrl;

    @Builder
    public Url(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
