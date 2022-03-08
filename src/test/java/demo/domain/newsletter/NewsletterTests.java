package demo.domain.newsletter;

import demo.domain.values.Email;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewsletterTests {

    @Test
    public void newNewsletterShouldHaveRandomGeneratedClientId()
    {
        Newsletter newsletter = new Newsletter("name", "last", new Email("email@email.com"));
        Assertions.assertThat(newsletter.getClientId()).isNotEmpty();
        Assertions.assertThat(newsletter.getClientId()).isNotBlank();
        Assertions.assertThat(newsletter.getClientId()).hasSize(10);
    }
}
