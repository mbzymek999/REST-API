package demo.api.newsletter;

import demo.domain.newsletter.NewsletterFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
class NewsletterController {

    private final NewsletterFacade facade;

    @Autowired
    public NewsletterController(NewsletterFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/newsletter/{clientId}")
    NewsletterDto readById(@PathVariable(value = "clientId") @Size(min = 10, max = 10) String clientId) {
        return facade.readByClientId(clientId);
    }


    @GetMapping("/newsletter")
    List<NewsletterDto> readAllNewsletters() {
        return facade.readAll();
    }

    @PostMapping("/create/newsletter")
    NewsletterDto createNewsletter(@RequestBody @Valid NewsletterRequest request) {
        return facade.createNewsletter(request.validate());
    }

    @PutMapping("/newsletter/{clientId}")
    NewsletterDto updateTask(@PathVariable(value = "clientId") @Size(min = 10, max = 10) String clientId, @RequestBody UpdateNewsletterRequest request) {
        return facade.updateNewsletter(clientId, request);
    }

    @DeleteMapping("delete/newsletter/{clientId}")
    NewsletterDto deleteNewsletter(@PathVariable(value = "clientId") @Size(min = 10, max = 10) String clientId) {
        return facade.deleteNewsletter(clientId);
    }
}
