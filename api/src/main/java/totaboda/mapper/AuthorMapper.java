package totaboda.mapper;

import totaboda.author.Author;
import totaboda.dtos.AuthorDto;

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
