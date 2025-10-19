package com.aysekoc.projecqrs.application.book.command.mapper;

import com.aysekoc.projecqrs.application.book.command.create.CreateBookCommand;
import com.aysekoc.projecqrs.application.book.command.create.CreatedBookResponse;
import com.aysekoc.projecqrs.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    // Target fonksiyon_ismi(Source s)
    Book convertCreateCommandToBook(CreateBookCommand createBookCommand);

    CreatedBookResponse convertBookToCreateBokResponse(Book book);

}
