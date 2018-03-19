package be.totaboda.Repositories;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

public class BookRepository {

    private AuthorRepository authorRepository = new AuthorRepository();


    private static HashMap<String, Book> bookDatabase =
            Maps.newHashMap(
                    new ImmutableMap.Builder<String, Book>()
                            .put("123", new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1")))
                            .build()
            );

    public static List<Book> getBookInformationISBN(String isbn) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();
        for (Book book : bookDatabase.values()) {
            if (book.getIsbn().equals(isbn)) {
                listOfBooks.add(bookDatabase.get(isbn));
            } else if (isbn.matches("(.*)" + book.getIsbn() + "(.*)")) {
                listOfBooks.add(book);
            } else {
                throw new IllegalArgumentException(String.format("No book found for isbn:%s", isbn));
            }
        }
        return listOfBooks;
    }

    public static List<Book> getBookInformationTitle(String title) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();
        for (Book book : bookDatabase.values()) {
            if (book.getIsbn().equals(title)) {
                listOfBooks.add(bookDatabase.get(title));
            } else if (title.matches("(.*)" + book.getTitle() + "(.*)")) {
                listOfBooks.add(book);
            } else {
                throw new IllegalArgumentException(String.format("No book found for title:%s", title));
            }
        }
        return listOfBooks;
    }

    public static List<Book> getBooksGivenAuthor(Author author) throws IllegalArgumentException {
        List<Book> books = new ArrayList<>();
        for (Book book : bookDatabase.values()) {
            if (book.getAuthor() == author) {
                books.add(book);
            } else {
                throw new IllegalArgumentException(String.format("No books found for author:%s", author));
            }
        }
        return books;
    }

    public static List<Book> getBookGivenPartialAuthor(String author) throws IllegalArgumentException {
        List<Book> books = new ArrayList<>();
        for (Book book : bookDatabase.values()) {

            String[] parts = author.split(" ");
            if (author.matches("(.*)" + book.getAuthor().getFirstName() + "(.*)")) {
                books.add(book);
            } else if (author.matches("(.*)" + book.getAuthor().getFirstName() + "(.*)")) {
                books.add(book);
            } else {
                throw new IllegalArgumentException(String.format("No books found for author:%s", author));
            }
        }
        return books;
    }

    public static List<Book> getBooks() {
        return new ArrayList<Book>(bookDatabase.values());
    }


}
