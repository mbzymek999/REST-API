package demo.domain.newsletter;

import demo.api.newsletter.NewsletterDto;
import demo.api.newsletter.NewsletterRequest;
import demo.api.newsletter.UpdateNewsletterRequest;

import java.util.List;

public interface NewsletterFacade {

    NewsletterDto readByClientId(String clientId);

    List<NewsletterDto> readAll();

    NewsletterDto createNewsletter(NewsletterRequest request);

    NewsletterDto updateNewsletter(String id, UpdateNewsletterRequest request);

    NewsletterDto deleteNewsletter(String id);

}
