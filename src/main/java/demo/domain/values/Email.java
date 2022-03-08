package demo.domain.values;

import demo.api.exceptions.BadRequestException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    final String value;

    public Email(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.isEmpty()) {
            throw new BadRequestException("E-mail is empty");
        }
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (!Pattern.compile(regexPattern)
                .matcher(value)
                .matches()) {
            throw new BadRequestException("E-mail is invalid");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
