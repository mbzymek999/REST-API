package demo.api.request;


import javax.validation.constraints.Email;

public class NewsletterRequest {
    private String name;
    private String lastName;
    @Email
    private String email;

    public NewsletterRequest() {
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

    public NewsletterRequest validate() throws IllegalArgumentException {
        if(email.isEmpty()) {
            throw new IllegalArgumentException("E-mail is empty");
        }
        return this;
    }
}
