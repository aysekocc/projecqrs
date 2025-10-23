package com.aysekoc.projecqrs.core.web;

import an.awesome.pipelinr.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    protected final Pipeline pipeline;

    public BaseController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }
}
