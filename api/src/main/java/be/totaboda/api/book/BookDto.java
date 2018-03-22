package be.totaboda.api.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    public String isbn;
    public String title;
    public String authorFirstName;
    public String authorLastName;


    public BookDto withAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookDto withAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookDto withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookDto withTitle(String title) {
        this.title = title;
        return this;
    }
}
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthorFirstName() {
//        return authorFirstName;
//    }
//
//    public String getAuthorLastName() {
//        return authorLastName;
//    }

