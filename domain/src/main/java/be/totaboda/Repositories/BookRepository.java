package be.totaboda.Repositories;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;

public class BookRepository {

    private static HashMap<String, Book>bookDatabase =
            Maps.newHashMap(
                    new ImmutableMap.Builder<String, Book>()
                            .put("123", new Book("123","Azkaban",  new Author("1234","JK", "Rowling")))
                    .build()
            );
}
