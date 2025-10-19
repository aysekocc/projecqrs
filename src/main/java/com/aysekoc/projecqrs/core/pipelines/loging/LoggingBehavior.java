package com.aysekoc.projecqrs.core.pipelines.loging;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;

//Behavior komutların middleware i yani ortada uğradığı yer gibi.
@Component
public class LoggingBehavior implements Command.Middleware{
    //TODO: Implementd ELK Stack
    //Loglama teknoloji yığını: elastiksearch, logstash, kibana
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        long startTime = System.currentTimeMillis();
        R result = next.invoke();
        long endTime = System.currentTimeMillis();
        System.out.println(c.getClass().getName() + " komutu " +  (endTime - startTime) + " ms sürede tamamlandı");
        return result;
    }
}
