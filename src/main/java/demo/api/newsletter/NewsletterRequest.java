package demo.api.newsletter;


import demo.api.exceptions.BadRequestException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewsletterRequest {

    @NotBlank(message = "name can not be blank")
    @NotNull(message = "name can not be null")
    @Size(min = 1,max = 40, message = "Name is not valid")
    private String name;


    @NotBlank(message = "last name can not be blank")
    @NotNull(message = "last name can not be null")
    @Size(min = 1,max = 50, message = "Last name is not valid")
    private String lastName;

    @Email(message = "Email is invalid")
    @NotNull(message = "email can not be null")
    @Size(min = 1,max = 40, message = "Email is not valid")
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
            throw new BadRequestException("E-mail is empty");
        }
        return this;
    }
}
