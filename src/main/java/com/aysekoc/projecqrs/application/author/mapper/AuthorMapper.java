package com.aysekoc.projecqrs.application.author.mapper;

import com.aysekoc.projecqrs.application.author.command.create.CreateAuthorCommand;
import com.aysekoc.projecqrs.application.author.command.create.CreatedAuthorResponse;
import com.aysekoc.projecqrs.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    Author createAuthorFromCreateCommand(CreateAuthorCommand createAuthorCommand);
    CreatedAuthorResponse createAuthorResponseFromAuthor(Author author);
}
