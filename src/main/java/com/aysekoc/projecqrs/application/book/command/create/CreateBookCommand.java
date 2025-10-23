package com.aysekoc.projecqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.aysekoc.projecqrs.application.author.service.AuthorService;
import com.aysekoc.projecqrs.application.book.command.mapper.BookMapper;
import com.aysekoc.projecqrs.domain.entity.Author;
import com.aysekoc.projecqrs.domain.entity.Book;
import com.aysekoc.projecqrs.persistence.book.BookRepository;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookCommand implements Command<CreatedBookResponse> {
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    private UUID authorId;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse> {

        private final BookRepository bookRepository;
        private final AuthorService authorService;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {

            Author author = authorService.findById(createBookCommand.authorId);


            BookMapper mapper = BookMapper.INSTANCE;
            Book book = mapper.convertCreateCommandToBook(createBookCommand);
            bookRepository.save(book);

            return mapper.convertBookToCreateBokResponse(book);
        }
    }
}
