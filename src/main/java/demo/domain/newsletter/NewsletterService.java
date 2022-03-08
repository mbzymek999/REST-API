package demo.domain.newsletter;

import demo.api.exceptions.AlreadyExistsException;
import demo.api.exceptions.ResourceNotFoundException;
import demo.api.newsletter.NewsletterDto;
import demo.api.newsletter.NewsletterRequest;
import demo.api.newsletter.UpdateNewsletterRequest;
import demo.domain.values.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class NewsletterService implements NewsletterFacade {

    private final NewsletterRepository repository;

    @Autowired
    public NewsletterService(NewsletterRepository repository) {
        this.repository = repository;
    }


    @Override
    public NewsletterDto readByClientId(String clientId) {
        return repository.findByClientId(clientId)
                .map(NewsletterDto::new)
                .orElseThrow(
                        () -> new ResourceNotFoundException("newsletter not found fo client : " + clientId)
                );
    }

    @Override
    public List<NewsletterDto> readAll() {
        return repository.findAll().stream().map(NewsletterDto::new).collect(Collectors.toList());
    }

    @Override
    public NewsletterDto createNewsletter(NewsletterRequest request) {

        checkIfEmailAlreadyExist(request);

        Newsletter newsletter = new Newsletter(
                request.getName(),
                request.getLastName(),
                new Email(request.getEmail())
        );

        repository.save(newsletter);

        return new NewsletterDto(newsletter);
    }

    @Override
    public NewsletterDto updateNewsletter(String clientId, UpdateNewsletterRequest request) {
        Newsletter newsletter = repository.findByClientId(clientId).orElseThrow();
        request.updateEntity(newsletter);
        repository.save(newsletter);
        return new NewsletterDto(newsletter);
    }

    @Override
    public NewsletterDto deleteNewsletter(String clientId) {
        Newsletter newsletter = repository.findByClientId(clientId).orElseThrow();
        repository.delete(newsletter);
        return new NewsletterDto(newsletter);
    }


    private void checkIfEmailAlreadyExist(NewsletterRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsException("Error: Email jest już zajęty");
        }
    }
}
