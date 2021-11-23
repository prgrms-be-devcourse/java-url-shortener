package kr.co.programmers.urlshortner;

import javax.servlet.http.HttpServletResponse;
import kr.co.programmers.urlshortner.utils.Base62;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedirectController {

    private final UrlService urlService;

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("{encoded}")
    public void redirectToOrigin(@PathVariable String encoded, HttpServletResponse response) {
        long id = Base62.decode(encoded);
        String originUrl = urlService.getOriginUrl(id);
        response.setHeader("Location", originUrl);
        response.setStatus(302);
    }

}
