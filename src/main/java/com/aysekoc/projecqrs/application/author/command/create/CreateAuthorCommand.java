package com.aysekoc.projecqrs.application.author.command.create;

import an.awesome.pipelinr.Command;
import com.aysekoc.projecqrs.application.author.mapper.AuthorMapper;
import com.aysekoc.projecqrs.application.author.service.AuthorService;
import com.aysekoc.projecqrs.domain.entity.Author;
import com.aysekoc.projecqrs.persistence.author.AuthorRepository;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorCommand implements Command<CreatedAuthorResponse> {
    private String firstName;
    private String lastName;

    @Component
    @RequiredArgsConstructor
    public static class CreateAuthorCommandHandler
            implements Command.Handler<CreateAuthorCommand, CreatedAuthorResponse> {

        private final AuthorRepository authorRepository;


        @Override
        public CreatedAuthorResponse handle(CreateAuthorCommand createAuthorCommand) {
            AuthorMapper authorMapper = AuthorMapper.INSTANCE;
            Author author = authorMapper.createAuthorFromCreateCommand(createAuthorCommand);
            authorRepository.save(author);

            return authorMapper.createAuthorResponseFromAuthor(author);
        }
    }
}
