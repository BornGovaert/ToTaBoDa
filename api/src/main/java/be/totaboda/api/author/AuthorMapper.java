package be.totaboda.api.author;

import be.totaboda.domain.author.Author;

public class AuthorMapper {

    public AuthorDto authorToAuthorDto(Author author){
        return new AuthorDto()
                .withFirstName(author.getFirstName())
                .withLastName(author.getLastName());
    }

    public Author authorDtoToAuthor(AuthorDto author){
return null;
    }
}
