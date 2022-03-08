package demo.api.newsletter;

import demo.domain.newsletter.Newsletter;


public class NewsletterDto {

    private final String idClient;
    private final String name;
    private final String lastName;
    private final String email;

    public NewsletterDto(Newsletter newsletter) {
        this.idClient = newsletter.getClientId();
        this.name = newsletter.getName();
        this.lastName = newsletter.getLastName();
        this.email = newsletter.getEmail().getValue();
    }

    public String getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
