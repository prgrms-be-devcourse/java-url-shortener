package kr.co.programmers.urlshortner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlGenController {


    private final UrlService urlService;

    public UrlGenController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String shortenUrl(@RequestParam String url, Model model) {
        String encodedUrl = urlService.getEncodedUrl(url);
        model.addAttribute("encodedUrl", encodedUrl);
        return "home";
    }
}
