package com.cunningbird.codereview.mapper;

import com.cunningbird.codereview.dto.BookDto;
import com.cunningbird.codereview.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookDto dto);

    BookDto toDto(Book entity);
}
