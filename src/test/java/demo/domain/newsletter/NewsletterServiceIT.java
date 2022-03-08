package demo.domain.newsletter;

import demo.api.newsletter.NewsletterDto;
import demo.domain.values.Email;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


public class NewsletterServiceIT {

    private NewsletterService newsletterService;

    private NewsletterRepository newsletterRepository;

    @BeforeEach
    public void setUp() {
        newsletterRepository = Mockito.mock(NewsletterRepository.class);
        newsletterService = new NewsletterService(newsletterRepository);
    }

    @Test
    public void whenCallingFindAllServiceCallsRepositoryOnce() {
        when(newsletterRepository.findAll()).thenReturn(Collections.emptyList());

        List<NewsletterDto> newsletterDtos = newsletterService.readAll();

        Assertions.assertThat(newsletterDtos).isEmpty();
        Mockito.verify(newsletterRepository, times(1)).findAll();
    }


    @Test
    public void whenCallingFindAllServiceMapsValuesProperly() {

        String name = "John";
        String clientId = "ClientId";
        String lastName = "lastName";
        Email email = new Email("email@example.com");
        Newsletter newsletter = Mockito.spy(new Newsletter(name,lastName,email));
        when(newsletter.getName()).thenReturn(name);
        when(newsletter.getClientId()).thenReturn(clientId);
        when(newsletter.getEmail()).thenReturn(email);
        when(newsletter.getLastName()).thenReturn(lastName);

        when(newsletterRepository.findAll()).thenReturn(List.of(newsletter));

        List<NewsletterDto> newsletterDtos = newsletterService.readAll();

        Assertions.assertThat(newsletterDtos).hasSize(1);
        NewsletterDto newsletterDto = newsletterDtos.get(0);
        Assertions.assertThat(newsletterDto).isNotNull();
        Assertions.assertThat(newsletterDto.getEmail()).isEqualTo(email.getValue());
        Assertions.assertThat(newsletterDto.getLastName()).isEqualTo(lastName);
        Assertions.assertThat(newsletterDto.getIdClient()).isEqualTo(clientId);
        Assertions.assertThat(newsletterDto.getName()).isEqualTo(name);

        Mockito.verify(newsletterRepository, times(1)).findAll();
    }


}
