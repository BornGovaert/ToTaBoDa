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
                            .put("999", new Book("999", "Zorro", AuthorRepository.getAuthorDatabase().get("4")))
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
            if (book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                listOfBooks.add(book);
            } else if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
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
        return new ArrayList<>(bookDatabase.values());
    }

    public static Book createBook(String isbn, String title, String lastName) {
        ArrayList<Author> authorList = new ArrayList<>();
        for (Author author : AuthorRepository.getAuthorDatabase().values()) {
            if (author.getLastName().equals(lastName)) {
                authorList.add(author);
            }
        }
        if (authorList.size() > 1) {
            throw new IllegalArgumentException("More then one author found with that last name");
        } else if (authorList.size() == 0) {
            throw new IllegalArgumentException("Author doesn't exist, create author first");
        } else {
            return bookDatabase.put(isbn, new Book(isbn, title, authorList.get(0)));
        }
    }

    private static ArrayList<Book> backupBookList = new ArrayList<>();

    public static void deleteBook(String isbn) throws IllegalArgumentException {
        if (bookDatabase.containsKey(isbn)) {
            // backupBookList.add(bookDatabase.get(isbn));
            bookDatabase.remove(isbn);
        } else if (!(bookDatabase.containsKey(isbn))) {
            throw new IllegalArgumentException("Can't find a book with that isbn");
        }

    }

    public static void updateBook(Book book) {
        if (bookDatabase.containsKey(book.getIsbn())) {
            bookDatabase.put(book.getIsbn(), book);
        } else if (!(bookDatabase.containsKey(book.getIsbn())))

        {
            throw new IllegalArgumentException("Can't find a book with that isbn");
        }
        for (
                Book bookInList : backupBookList)

        {
            if (bookInList.getIsbn().equals(book.getIsbn())) {
                backupBookList.set(backupBookList.indexOf(bookInList), book);
            }
        }

    }

    public static void restoreBook(Book book) {
        for (Book bookInList : backupBookList) {
            if (bookInList.getIsbn().equals(book.getIsbn())) {
                bookDatabase.put(bookInList.getIsbn(), bookInList);

            }
        }
    }

}
