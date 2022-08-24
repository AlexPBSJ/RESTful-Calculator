package com.alexpbsj.calculatorconsumer.Consumer;

import Logic.Operators;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@EnableRabbit
@Component
public class OperationsConsumer {

    @RabbitListener(queues = "Operation")
    private void consumer(Operators op){
        switch (op.getType()) {
            case '+' -> {
                System.out.println(op.getA() + "+" + op.getB() + "=" + op.getResult());
                System.out.println("----------------------");
            }
            case '-' -> {
                System.out.println(op.getA() + "-" + op.getB() + "=" + op.getResult());
                System.out.println("----------------------");
            }
            case '*' -> {
                System.out.println(op.getA() + "*" + op.getB() + "=" + op.getResult());
                System.out.println("----------------------");
            }
            case '/' -> {
                if(op.getB().equals(BigDecimal.valueOf(0)))
                    System.out.println(op.getA() + "/" + op.getB() + "\nError - Can't divide by 0");
                else
                    System.out.println(op.getA() + "/" + op.getB() + "=" + op.getResult());

                System.out.println("----------------------");
            }
        }
    }
}
