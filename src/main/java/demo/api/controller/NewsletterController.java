package demo.api.controller;

import demo.api.dto.NewsletterDto;
import demo.api.request.NewsletterRequest;
import demo.api.request.UpdateNewsletterRequest;
import demo.domain.facade.NewsletterFacade;
import demo.domain.service.NewsletterService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NewsletterController {

    private final NewsletterFacade facade;

    public NewsletterController(NewsletterFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/newsletters")
    List<NewsletterDto> readAllNewsletters() {
        return facade.readAll();
    }

    @PostMapping("/create/newsletter")
    String createNewsletter(@RequestBody @Valid NewsletterRequest request) {
        return facade.createNewsletter(request.validate());
    }

    @RequestMapping(value = "/newsletter/{idClient}", method = RequestMethod.PUT)
    NewsletterDto updateTask(@PathVariable(value = "idClient") String id, @RequestBody UpdateNewsletterRequest request) {
        return facade.updateNewsletter(id, request);
    }

    @DeleteMapping("delete/newsletter/{idClient}")
    public String deleteNewsletter(@PathVariable(value = "idClient") String id) {
       return facade.deleteNewsletter(id);
    }
}
