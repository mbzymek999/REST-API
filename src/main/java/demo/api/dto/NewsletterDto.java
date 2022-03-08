package demo.api.dto;

import demo.domain.entity.Newsletter;


public class NewsletterDto {

    private String idClient;
    private String name;
    private String lastName;
    private String email;

    public NewsletterDto(Newsletter newsletter) {
        this.idClient = newsletter.getIdClient();
        this.name = newsletter.getName();
        this.lastName = newsletter.getLastName();
        this.email = newsletter.getEmail();
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
