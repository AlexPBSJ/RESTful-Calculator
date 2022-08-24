package com.alexpbsj.Calculator.Controllers;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alexpbsj.Calculator.Connections.RabbitMQService;
import Logic.Operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller implements Serializable {
    static final long serialVersionUID = 42L;
    public Operators op = new Operators();

    @Autowired
    private RabbitMQService rabbitMQService;

    @RequestMapping("sum")
    public String sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);
        op.setType('+');
        op.setResult(op.getA().add(op.getB()));

        System.out.println(op.getA() + "+" + op.getB());

        this.rabbitMQService.sendMessage("Operation", op);
        return "result: " + op.getResult();
    }

    @RequestMapping("multiply")
    public String multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);
        op.setType('*');
        op.setResult(op.getA().multiply(op.getB()));

        System.out.println(op.getA() + "*" + op.getB());

        this.rabbitMQService.sendMessage("Operation", op);
        return "result: " + op.getResult();
    }

    @RequestMapping("subtract")
    public String subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);
        op.setType('-');
        op.setResult(op.getA().subtract(op.getB()));

        System.out.println(op.getA() + "-" + op.getB());

        this.rabbitMQService.sendMessage("Operation", op);
        return "result: " + op.getResult();
    }

    @RequestMapping("divide")
    public String divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);
        op.setType('/');
        if(op.getB().equals(BigDecimal.valueOf(0))){
            System.out.println("Error - Can't divide by 0");
            this.rabbitMQService.sendMessage("Operation", op);
            return "Can't divide by 0";
        }
        op.setResult(op.getA().divide(op.getB()));

        System.out.println(op.getA() + "/" + op.getB());

        this.rabbitMQService.sendMessage("Operation", op);
        return "result: " + op.getResult();
    }
}
