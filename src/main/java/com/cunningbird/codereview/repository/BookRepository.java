package com.cunningbird.codereview.repository;

import com.cunningbird.codereview.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {}
