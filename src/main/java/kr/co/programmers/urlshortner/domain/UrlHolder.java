package kr.co.programmers.urlshortner.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UrlHolder {

    @Id @GeneratedValue
    @Column(name = "url_holder_id")
    private Long id;

    private String origin;

    private String encoded;
    private static final String HOST = "http://localhost:8080/";

    protected UrlHolder() {
    }

    public UrlHolder(String origin) {
        this.origin = origin;
    }

    public String getEncodedUrl() {
        return encoded;
    }

    public void setEncodedUrl(String encodedValue) {
        this.encoded = HOST + encodedValue;
    }

    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }
}
