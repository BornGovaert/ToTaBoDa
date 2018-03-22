package be.totaboda.domain.author;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AuthorRepository {

    private static Map<String, Author> authorDatabase;
    private int authorCounter = 5;

    public AuthorRepository() {
        authorDatabase= new HashMap<>();
        authorDatabase.put("1", new Author("1","JK", "Rowling"));
        authorDatabase.put("2", new Author("2","Dan", "Brown"));
        authorDatabase.put("3", new Author("3","Willem", "Elsschot"));
        authorDatabase.put("4", new Author("4","Mighty", "Zorro"));
    }

    public Map<String, Author> getAuthorDatabase() {
        return Collections.unmodifiableMap(authorDatabase);
    }

    public Author addNewAuthor(Author author){
        if (!verifyIfAuthorExists(author)) {
            author.setId(String.valueOf(authorCounter));
            authorDatabase.put(Integer.toString(authorCounter), author);
            authorCounter++;
        }
        return author;
    }

    private boolean verifyIfAuthorExists(Author author) {
        return authorDatabase.values().stream()
                .anyMatch(bookAuthor-> bookAuthor.getLastName().equals(author.getLastName()) && bookAuthor.getFirstName().equals(author.getFirstName()));
    }
}


