package demo.domain.service;

import demo.api.dto.NewsletterDto;
import demo.api.request.NewsletterRequest;
import demo.api.request.UpdateNewsletterRequest;
import demo.domain.entity.Newsletter;
import demo.domain.facade.NewsletterFacade;
import demo.domain.repository.NewsletterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NewsletterService implements NewsletterFacade {

    private final NewsletterRepository repository;

    public NewsletterService(NewsletterRepository repository) {
        this.repository = repository;
    }

    public List<NewsletterDto> readAll() {
        return repository.findAll().stream().map(NewsletterDto::new).collect(Collectors.toList());
    }

    public String createNewsletter(NewsletterRequest request) {

        checkIfEmailAlreadyExist(request);

        String randomId = UUID.randomUUID().toString().replace("-", "");

        Newsletter newsletter = new Newsletter(
             randomId,
             request.getName(),
             request.getLastName(),
             request.getEmail()
        );

        repository.save(newsletter);

        return "Object was created";
    }

    public NewsletterDto updateNewsletter(String id, UpdateNewsletterRequest request) {
        Newsletter newsletter = repository.findByIdClient(id).orElseThrow();
        request.updateEntity(newsletter);
        repository.save(newsletter);
        return new NewsletterDto(newsletter);
    }

    public String deleteNewsletter(String id) {
        Newsletter newsletter = repository.findByIdClient(id).orElseThrow();
        repository.delete(newsletter);
        return "Object" + id + "was deleted";
    }

    private void checkIfEmailAlreadyExist(NewsletterRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Error: Email jest już zajęty");
        }
    }

}
