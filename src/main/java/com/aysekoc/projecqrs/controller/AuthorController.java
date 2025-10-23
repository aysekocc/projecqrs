package com.aysekoc.projecqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.aysekoc.projecqrs.application.author.command.create.CreateAuthorCommand;
import com.aysekoc.projecqrs.application.author.command.create.CreatedAuthorResponse;
import com.aysekoc.projecqrs.core.web.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController extends BaseController {
    public AuthorController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    public CreatedAuthorResponse createAuthor(@RequestBody CreateAuthorCommand command) {
        return command.execute(pipeline);
    }
}
