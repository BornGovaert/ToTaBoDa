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
                            .put("111", new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2")))
                            .put("666", new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3")))
                            .build()
            );

    public static List<Book> getBookInformationISBN(String isbn) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();

        for (Book book : bookDatabase.values()) {
            String test = book.getIsbn();

            if (book.getIsbn().equals(isbn)) {
                listOfBooks.add(bookDatabase.get(isbn));
            } else if (test.contains(isbn)) {
                listOfBooks.add(book);
            }//isbn.matches("[a-zA-Z0-9]*{" + test + "} +[a-zA-Z0-9]*")
        }
        if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException(String.format("No book found for isbn:%s", isbn));
        }
        return listOfBooks;
    }

    public static List<Book> getBookInformationTitle(String title) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();

        for (Book book : bookDatabase.values()) {
            String test = book.getTitle();

            if (book.getTitle().equals(title)) {
                listOfBooks.add(book);
            } else if (test.contains(title)) {
                listOfBooks.add(book);
            }
        }
        if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException(String.format("No book found for title:%s", title));
        }
        return listOfBooks;
    }

    public static List<Book> getBooksGivenAuthor(Author author) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();
        for (Book book : bookDatabase.values()) {
            if (book.getAuthor().equals(author)) {
                listOfBooks.add(book);
            }
        }
        if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException(String.format("No books found for author:%s", author));
        }

        return listOfBooks;
    }

    public static List<Book> getBookGivenPartialAuthor(String author) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();
        for (Book book : bookDatabase.values()) {
            if (author.contains(" ")) {
                String[] parts = author.split(" ");

                if (book.getAuthor().getFirstName().contains(parts[1])) {
                    listOfBooks.add(book);
                } else if (book.getAuthor().getLastName().contains(parts[1])) {
                    listOfBooks.add(book);
                } else if (book.getAuthor().getFirstName().contains(parts[2])) {
                    listOfBooks.add(book);
                } else if (book.getAuthor().getLastName().contains(parts[2])) {
                    listOfBooks.add(book);
                }
            } else {
                if (book.getAuthor().getFirstName().contains(author)) {
                    listOfBooks.add(book);
                } else if (book.getAuthor().getLastName().contains(author)) {
                    listOfBooks.add(book);
                }
            }
        }
        if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException(String.format("No books found for author:%s", author));
        }
        return listOfBooks;
    }

    public static List<Book> getBooks() {
        return new ArrayList<Book>(bookDatabase.values());
    }

    public static Book createBook(String isbn, Book book) {
        return bookDatabase.put("", book);
    }

    public static void deleteBook(String isbn) throws IllegalArgumentException {
        for (Book book : bookDatabase.values()) {
            if (book.getIsbn().equals(isbn)) {
                bookDatabase.remove(isbn);
            } else {
                throw new IllegalArgumentException(String.format("No book found for isbn:%s", isbn));
            }
        }
    }
}
