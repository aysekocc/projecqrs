package com.aysekoc.projecqrs.application.book.command.update;

import an.awesome.pipelinr.Command;
import com.aysekoc.projecqrs.domain.entity.Book;
import com.aysekoc.projecqrs.persistence.book.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookCommand implements Command<UpdatedBookResponse> {

    private UUID id;
    private String name;

    @Component
    @AllArgsConstructor
    public static class UpdateBookCommandHandler implements Command.Handler<UpdateBookCommand, UpdatedBookResponse> {
        private final BookRepository bookRepository;

        @Override
        public UpdatedBookResponse handle(UpdateBookCommand command) {
            Book book = bookRepository.findById(command.getId())
                    .orElseThrow(() -> new RuntimeException("Book not found!"));

            book.setName(command.getName());
            Book kaydet = bookRepository.save(book);
            return new UpdatedBookResponse(kaydet.getId(), kaydet.getName());
        }
    }
}
