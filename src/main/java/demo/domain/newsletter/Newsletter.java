package demo.domain.newsletter;


import demo.domain.values.Email;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String clientId;

    private String name;

    private String lastName;

    private String email;

    public Newsletter(String name, String lastName, Email email) {
        this.clientId = generateNewClientId();
        this.name = name;
        this.lastName = lastName;
        this.email = email.getValue();
    }

    public Newsletter() {
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return new Email(email);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private static String generateNewClientId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
