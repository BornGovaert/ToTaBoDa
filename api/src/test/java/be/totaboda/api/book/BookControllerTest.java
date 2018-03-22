//package be.totaboda.api.book;
//
//import be.totaboda.api.user.TestApplication;
//import be.totaboda.domain.book.BookRepository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.inject.Inject;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class BookControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Inject
//    private BookRepository repository;
//
//    @Test
//
//    public void getBooks(){
//
//        BookDto[] books = new TestRestTemplate().getForObject(String.format("http:localhost:%s/%s", port,"books"), BookDto[].class);
//
//        Assertions.assertThat(books).hasSize(4);
//
//    }
//
//
//
//}