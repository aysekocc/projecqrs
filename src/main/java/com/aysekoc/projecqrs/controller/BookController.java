package com.aysekoc.projecqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.aysekoc.projecqrs.application.book.command.create.CreateBookCommand;
import com.aysekoc.projecqrs.application.book.command.create.CreatedBookResponse;
import com.aysekoc.projecqrs.application.book.command.update.UpdateBookCommand;
import com.aysekoc.projecqrs.application.book.command.update.UpdatedBookResponse;
import com.aysekoc.projecqrs.core.web.BaseController;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController extends BaseController {

    public BookController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedBookResponse create(@RequestBody CreateBookCommand createBookCommand) {
        return createBookCommand.execute(pipeline);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public UpdatedBookResponse update(@RequestBody UpdateBookCommand updateBookCommand) {
        return updateBookCommand.execute(pipeline);
    }
}
