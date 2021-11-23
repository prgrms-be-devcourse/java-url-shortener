package kr.co.programmers.urlshortner;

import kr.co.programmers.urlshortner.domain.UrlHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("url/{id}/edit")
    public String editUrlForm(@PathVariable Long id, Model model) {
        UrlHolder urlHolder = urlService.getUrlHolder(id);
        model.addAttribute("urlHolder", urlHolder);
        return "edit";
    }

    @PostMapping("url/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute UrlHolder urlHolder) {
        urlService.update(id, urlHolder);
        return "redirect:/";
    }

    @PostMapping
    public String shortenUrl(@RequestParam String url, Model model) {
        UrlHolder urlHolder = urlService.getUrlHolder(url);
        model.addAttribute("urlHolder", urlHolder);
        return "home";
    }
}
