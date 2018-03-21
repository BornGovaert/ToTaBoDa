package totaboda.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    public String isbn;
    public String title;
    public String authorFirstName;
    public String authorLastName;

    public BookDto() {

    }

    public BookDto(String isbn, String title, String authorFirstName, String authorLastName) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public void withAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void withAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void withIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void withTitle(String title) {
        this.title = title;
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
}
