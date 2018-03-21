package totaboda.author;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;

public class AuthorRepository {

    private static HashMap<String, Author> authorDatabase =
            Maps.newHashMap(
                    new ImmutableMap.Builder<String,Author>()
                            .put("1", new Author("1","JK", "Rowling"))
                            .put("2", new Author("2","Dan", "Brown"))
                            .put("3", new Author("3","Willem", "Elsschot"))
                            .put("4", new Author("4","Mighty", "Zorro"))
                    .build()
            );

    public HashMap<String, Author> getAuthorDatabase() {
        return authorDatabase;
    }


}


