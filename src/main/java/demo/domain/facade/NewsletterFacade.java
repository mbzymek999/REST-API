package demo.domain.facade;

import demo.api.dto.NewsletterDto;
import demo.api.request.NewsletterRequest;
import demo.api.request.UpdateNewsletterRequest;

import java.util.List;

public interface NewsletterFacade {

    List<NewsletterDto> readAll();

    String createNewsletter(NewsletterRequest request);

    NewsletterDto updateNewsletter(String id, UpdateNewsletterRequest request);

    String deleteNewsletter(String id);

}
