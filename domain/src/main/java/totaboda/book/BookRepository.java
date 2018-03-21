package totaboda.book;

import totaboda.author.Author;
import totaboda.author.AuthorRepository;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookRepository {

    private AuthorRepository authorRepository = new AuthorRepository();

    private  HashMap<String, Book> bookDatabase =
            Maps.newHashMap(
                    new ImmutableMap.Builder<String, Book>()
                            .put("123", new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1")))
                            .put("111", new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2")))
                            .put("666", new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3")))
                            .put("999", new Book("999", "Zorro", authorRepository.getAuthorDatabase().get("4")))
                            .build()
            );

    public List<Book> getBookInformationISBN(String isbn) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();
        for (Book book : bookDatabase.values()) {
            if (book.getIsbn().equals(isbn)) {
                listOfBooks.add(bookDatabase.get(isbn));
            } else if (book.getIsbn().startsWith(isbn)) {
                listOfBooks.add(book);
            }
        }
        if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException(String.format("No book found for isbn:%s", isbn));
        }
        return listOfBooks;
    }

    public List<Book> getBookInformationTitle(String title) throws IllegalArgumentException {
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

    public List<Book> getBooksGivenAuthor(String author) throws IllegalArgumentException {
        List<Book> listOfBooks = new ArrayList<>();
        String concatenatedName;
        for (Book book : bookDatabase.values()) {
            concatenatedName = (book.getAuthor().getFirstName()+ book.getAuthor()
                    .getLastName()).toLowerCase();
            if (concatenatedName.contains((author.replaceAll("[^a-zA-Z]","")).toLowerCase())) {
                listOfBooks.add(book);
            }
        }
        if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException(String.format("No books found for author:%s", author));
        }
        return listOfBooks;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(bookDatabase.values());
    }

    public Book createBook(String isbn, String title, String lastName) {
        ArrayList<Author> authorList = new ArrayList<>();
        for (Author author : authorRepository.getAuthorDatabase().values()) {
            if (author.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
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

    public void deleteBook(String isbn) throws IllegalArgumentException {
        if (bookDatabase.containsKey(isbn)) {
            backupBookList.add(bookDatabase.get(isbn));
            bookDatabase.remove(isbn);
        } else {
            throw new IllegalArgumentException("Can't find a book with that isbn");
        }

    }

    public void updateBook(Book book) {
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

    public void restoreBook(Book book) {
        for (Book bookInList : backupBookList) {
            if (bookInList.getIsbn().equals(book.getIsbn())) {
                bookDatabase.put(bookInList.getIsbn(), bookInList);

            }
        }
    }

}
