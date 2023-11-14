package com.cunningbird.codereview.service;

import com.cunningbird.codereview.entity.Book;
import com.cunningbird.codereview.exception.BusinessErrorException;
import com.cunningbird.codereview.logger.BusinessLogicLogging;
import com.cunningbird.codereview.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    @Override
    @BusinessLogicLogging(scenarioName = "Найти все книги")
    public List<Book> getAllBooks() throws Exception {
        return repository.findAll();
    }

    @Override
    @BusinessLogicLogging(scenarioName = "Найти книгу по идентификатору")
    public Book findBookById(UUID id) throws Exception {
        throw new BusinessErrorException("Business Error Exception");
//        return null;
    }

    @Override
    @BusinessLogicLogging(scenarioName = "Создать новую книгу")
    public void createBook(Book book) {
        System.out.println("Flex3");
    }

    @Override
    @BusinessLogicLogging(scenarioName = "Обновить книгу")
    public Book updateBook(Book book) {
        System.out.println("Flex4");
        return null;
    }

    @Override
    @BusinessLogicLogging(scenarioName = "Удалить книгу")
    public void deleteBook(Book book) {
        System.out.println("Flex5");
    }
}
