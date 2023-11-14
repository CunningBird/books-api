package com.cunningbird.codereview.controller;

import com.cunningbird.codereview.dto.BookDto;
import com.cunningbird.codereview.entity.Book;
import com.cunningbird.codereview.exception.BusinessErrorException;
import com.cunningbird.codereview.mapper.BookMapper;
import com.cunningbird.codereview.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// TODO validation
@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {

    private BookService service;

    private BookMapper mapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> findAllBooks() throws Exception {
        return new ResponseEntity<>(service.getAllBooks().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> findBookById(@PathVariable("id") UUID id) throws Exception {
        Book response = service.findBookById(id);
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createBook(BookDto book) throws Exception {
        Book entity = mapper.toEntity(book);
        service.createBook(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<BookDto> updateBook(BookDto book) throws Exception {
        Book entity = mapper.toEntity(book);
        Book response = service.updateBook(entity);
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(BookDto book) throws Exception {
        Book entity = mapper.toEntity(book);
        service.deleteBook(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(BusinessErrorException.class)
    public ResponseEntity<String> businessErrorExceptionHandler(BusinessErrorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> serverErrorExceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
