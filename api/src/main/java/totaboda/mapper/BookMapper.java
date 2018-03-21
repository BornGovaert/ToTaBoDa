package totaboda.mapper;

import totaboda.book.Book;
import totaboda.dtos.BookDto;

public class BookMapper {

    public static BookDto bookMapper(Book bookToMap){
        return new BookDto(bookToMap.getIsbn(),
                bookToMap.getTitle(),
                bookToMap.getAuthor().getFirstName(),
                bookToMap.getAuthor().getLastName());
    }

    public static Book dtoToBook(BookDto book){
        return null;
    }

}
