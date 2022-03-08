package demo.api.request;

import demo.domain.entity.Newsletter;

import javax.validation.constraints.Email;

public class UpdateNewsletterRequest {
    private String name;
    private String lastName;
    @Email
    private String email;

    public void updateEntity(Newsletter newsletter) {
        newsletter.setName(this.name);
        newsletter.setLastName(this.lastName);
        newsletter.setEmail(this.email);
    }

    public UpdateNewsletterRequest() {
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
