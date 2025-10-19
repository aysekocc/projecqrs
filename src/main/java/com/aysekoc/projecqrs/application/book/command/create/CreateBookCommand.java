package com.aysekoc.projecqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.aysekoc.projecqrs.application.book.command.mapper.BookMapper;
import com.aysekoc.projecqrs.core.pipelines.auth.AuthenticatedRequest;
import com.aysekoc.projecqrs.domain.entity.Book;
import com.aysekoc.projecqrs.persistence.book.BookRepository;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookCommand implements Command<CreatedBookResponse> {

    private String name;

    //inner class
    @Component
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse>{

        private final BookRepository bookRepository;

        public CreateBookCommandHandler(BookRepository bookRepository){
            this.bookRepository = bookRepository;
        }

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            //manual mapper
            // CreateBookCommand -> Book
            //Book book = new Book();
            //book.setName(command.getName());

            //Otomatik mapper(mapstruct)
            BookMapper mapper = BookMapper.INSTANCE;
            Book book = mapper.convertCreateCommandToBook(createBookCommand);
            bookRepository.save(book);


            return mapper.convertBookToCreateBokResponse(book);
        }
    }
}
