package com.alexpbsj.calculatorconsumer.Consumer;

import com.alexpbsj.calculatorconsumer.Logic.Operators;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class OperationsConsumer {

    @RabbitListener(queues = "Operation")
    private void consumer(Operators op){
        System.out.println(op);
        System.out.println("----------------------");
    }
}
