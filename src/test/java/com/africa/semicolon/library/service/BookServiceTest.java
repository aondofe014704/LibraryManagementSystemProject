package com.africa.semicolon.library.service;

import com.africa.semicolon.library.data.repository.BookRepository;
import com.africa.semicolon.library.dto.requests.AddBookRequest;
import com.africa.semicolon.library.dto.requests.SearchBookRequest;
import com.africa.semicolon.library.dto.responses.AddBookResponse;
import com.africa.semicolon.library.dto.responses.DeleteBookResponse;
import com.africa.semicolon.library.dto.responses.SearchBookResponse;
import com.africa.semicolon.library.exception.BookTitleAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.client.model.Filters.size;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceTest {
    @Autowired

    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
    }
    @Test
    public void testToAddBookABook(){
        AddBookResponse addBookResponse = addNewBook();
        assertThat(addBookResponse).isNotNull();
        assertThat(bookService.getAllBooks()).size().isEqualTo(1L);
        assertThat(addBookResponse.getBookId()).isNotNull();
    }

    private AddBookResponse addNewBook() {
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("The Fall Apart");
        addBookRequest.setBookAuthor("Chinua Achebe");
        addBookRequest.setISBN("ISBN-13: 978-0-7432-7356-5");
        addBookRequest.setPublicationYear("2002");
        return bookService.addBook(addBookRequest);
    }
    @Test
    public void testToAddBookWithSameTitle_ThrowsException() {
        addNewBook();
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("The Fall Apart");
        addBookRequest.setBookAuthor("Chinua Achebe");
        addBookRequest.setISBN("ISBN-13: 978-0-7432-7356-5");
        addBookRequest.setPublicationYear("2002");
        assertThrows(BookTitleAlreadyExistsException.class, () -> bookService.addBook(addBookRequest));
    }
    @Test
    public void testToUpdateBook(){
        addNewBook();
        SearchBookRequest searchBookRequest = new SearchBookRequest();
        searchBookRequest.setId("66b73e37c247956265ea62c6");
        searchBookRequest.setTitle("The Fall Apart");
        SearchBookResponse searchBookResponse = bookService.searchBook(searchBookRequest);
        assertThat(searchBookResponse).isNotNull();
        assertThat(searchBookResponse.getBookId()).isNotNull();
    }
    @Test
    public void testDeleteBook_RepositoryIsDecreased(){
        AddBookResponse addBookResponse = addNewBook();
        String bookId = addBookResponse.getBookId();
        DeleteBookResponse deleteBookResponse = bookService.deleteBook(bookId);
        assertThat(deleteBookResponse).isNotNull();
        assertThat(deleteBookResponse.getMessage().contains("Book deleted"));
        assertThat(bookService.getAllBooks()).size().isEqualTo(0L);
    }
}