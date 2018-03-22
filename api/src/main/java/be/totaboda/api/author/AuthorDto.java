package be.totaboda.api.author;

public class AuthorDto {
    public String firstName;
    public String lastName;

    public AuthorDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AuthorDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
