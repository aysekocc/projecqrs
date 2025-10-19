package com.aysekoc.projecqrs.core.auth;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationBehavior implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        //command calısmadan önce

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()) {
            throw new RuntimeException("Authentication required");
        }*/

        System.out.println("BEFORE: AuthenticationBehavior invoked");

        //bu invoke mediator hangi commande gidiyorsa onu çalıştır
        // çalıştırdıktan sonra buraya tekrar geri dön.
        var response = next.invoke();

        System.out.println("AFTER: AuthenticationBehavior invoked");
        return response;
    }
}
