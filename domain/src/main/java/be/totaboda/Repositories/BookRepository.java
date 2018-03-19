package be.totaboda.Repositories;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookRepository {

    private AuthorRepository authorRepository = new AuthorRepository();


    private static HashMap<String, Book>bookDatabase =
            Maps.newHashMap(
                    new ImmutableMap.Builder<String, Book>()
                            .put("123", new Book("123","Azkaban", AuthorRepository.getAuthorDatabase().get("1")))
                    .build()
            );


    public static Book getBookInformation(String isbn) throws IllegalArgumentException {
        if (bookDatabase.containsKey(isbn)) {
            return bookDatabase.get(isbn);
        } else {
            throw new IllegalArgumentException(String.format("No book found for isbn:%s", isbn));
        }
    }




    public static List<Book> getBooks() {
        return new ArrayList<Book>(bookDatabase.values());
    }


}
