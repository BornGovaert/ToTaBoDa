package totaboda.dtos;

public class BookDto {

        private String isbn;
        private String title;
        private String authorFirtsName;
        private String authorLastName;

    public BookDto(String isbn, String title, String authorFirtsName, String authorLastName) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirtsName = authorFirtsName;
        this.authorLastName = authorLastName;
    }
}
