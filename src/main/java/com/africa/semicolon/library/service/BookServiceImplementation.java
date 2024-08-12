package com.africa.semicolon.library.service;

import com.africa.semicolon.library.data.model.Book;
import com.africa.semicolon.library.data.repository.BookRepository;
import com.africa.semicolon.library.dto.requests.AddBookRequest;
import com.africa.semicolon.library.dto.requests.SearchBookRequest;
import com.africa.semicolon.library.dto.responses.AddBookResponse;
import com.africa.semicolon.library.dto.responses.DeleteBookResponse;
import com.africa.semicolon.library.dto.responses.SearchBookResponse;
import com.africa.semicolon.library.exception.BookNotFoundException;
import com.africa.semicolon.library.exception.BookTitleAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.africa.semicolon.library.utils.Mapper.mapAddBookResponse;
import static com.africa.semicolon.library.utils.Mapper.mapSearchBookResponse;

@Service
public class BookServiceImplementation implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        validateExistingBookTitle(addBookRequest.getBookTitle());
        Book book = new Book();
        book.setTitle(addBookRequest.getBookTitle());
        book.setISBN(addBookRequest.getISBN());
        book.setAuthor(addBookRequest.getBookAuthor());
        mapAddBookResponse(book);
        bookRepository.save(book);
        return mapAddBookResponse(book);
    }
    private void validateExistingBookTitle(String title){
        boolean existsByTitle = bookRepository.existsByTitle(title);
        if(existsByTitle) throw new BookTitleAlreadyExistsException(title + " already exists");
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public SearchBookResponse searchBook(SearchBookRequest searchBookRequest) {
        searchBookByTitle(searchBookRequest.getTitle());
        Book book = new Book();
        book.setTitle(searchBookRequest.getTitle());
        book.setAuthor(searchBookRequest.getAuthor());
        book.setId(searchBookRequest.getId());
        return mapSearchBookResponse(book);
    }

    @Override
    public DeleteBookResponse deleteBook( String bookId) {
        existsById(bookId);
        DeleteBookResponse deleteBookResponse = new DeleteBookResponse();
        deleteBookResponse.setMessage("Book Deleted Successful");
        return deleteBookResponse;
    }
    private void existsById(String bookId) {
        Book book = bookRepository.findBookById(bookId);
        bookRepository.delete(book);

    }

    private Book searchBookByTitle(String title) {
        return bookRepository.findByTitle(title)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

}
