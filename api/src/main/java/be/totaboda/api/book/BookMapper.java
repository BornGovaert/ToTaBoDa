package be.totaboda.api.book;

import be.totaboda.domain.author.Author;
import be.totaboda.domain.book.Book;

public class BookMapper {

    public static BookDto bookToDto(Book bookToMap) {
        return new BookDto()
                .withIsbn(bookToMap.getIsbn())
                .withTitle(bookToMap.getTitle())
                .withAuthorFirstName(bookToMap.getAuthor().getFirstName())
                .withAuthorLastName((bookToMap.getAuthor().getLastName()));
    }

    public static Book dtoToBook(BookDto book) {
        return new Book(book.isbn,book.title,
                new Author(book.authorFirstName,book.authorLastName));
    }

}
