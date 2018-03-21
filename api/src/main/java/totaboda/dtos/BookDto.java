package totaboda.dtos;

public class BookDto {

        public String isbn;
        public String title;
        public String authorFirstName;
        public String authorLastName;

    public BookDto(String isbn, String title, String authorFirstName, String authorLastName) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
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
