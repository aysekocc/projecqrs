package com.aysekoc.projecqrs.core.pipelines;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("rawtypes")
public class PipelineConfiguration {

    @Bean
    Pipeline pipeline(
            ObjectProvider<Command.Handler> commandHandlers,
            ObjectProvider<Notification.Handler> notificationHandlers,
            ObjectProvider<Command.Middleware> middlewares) {

        return new Pipelinr()
                .with(() -> commandHandlers.stream()) //stream->liste
                .with(() -> notificationHandlers.stream()) //stream->liste
                .with((Command.Middlewares) middlewares::orderedStream); //orderedstream->sıralı liste
    }
}
