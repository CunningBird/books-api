package com.cunningbird.codereview.service;

import com.cunningbird.codereview.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

// TODO concrete exceptions
public interface BookService {

    List<Book> getAllBooks() throws Exception;

    Book findBookById(UUID id) throws Exception;

    void createBook(Book book) throws Exception;

    Book updateBook(Book book) throws Exception;

    void deleteBook(Book book) throws Exception;
}
