package com.aysekoc.projecqrs.core.pipelines.validation;

import an.awesome.pipelinr.Command;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@Order(3)
@RequiredArgsConstructor
public class ValidationBehavior implements Command.Middleware {

    private final Validator validator;

    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        Set<ConstraintViolation<C>> errors = validator.validate(c);
        if (!errors.isEmpty()) {
            //TODO : Errorları exception olarak fırlat
            throw new ValidationException(errers.stream().map(err->err.getMessage().toList()));
        }
        return next.invoke();
    }
}
