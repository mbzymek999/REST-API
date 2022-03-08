package demo.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "newsletters")
public class Newsletter {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;

    @Column(unique = true, nullable = false)
    private String idClient;

    private String name;

    private String lastName;

    private String email;

    public Newsletter(String idClient, String name, String lastName, String email) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public Newsletter() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
