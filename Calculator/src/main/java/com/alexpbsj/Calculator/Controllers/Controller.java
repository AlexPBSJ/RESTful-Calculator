package com.alexpbsj.Calculator.Controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.alexpbsj.Calculator.Connections.RabbitMQService;
import com.alexpbsj.Calculator.Logic.Operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller implements Serializable {
    static final long serialVersionUID = 42L;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private Operators op;

    @RequestMapping("sum")
    public String sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);

        System.out.println(op.getA() + "+" + op.getB());

        Object msg = op.getA() + "+" + op.getB();

        this.rabbitMQService.sendMessage("Operation", op);
        return "result: " + op.getA().add(op.getB());
    }

    @RequestMapping("multiply")
    public String multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);

        System.out.println(op.getA() + "*" + op.getB());

        String msg = op.getA() + "*" + op.getB();

        this.rabbitMQService.sendMessage("Operation", msg);
        return "result: " + op.getA().multiply(op.getB());
    }

    @RequestMapping("subtract")
    public String subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);

        System.out.println(op.getA() + "-" + op.getB());

        String msg = op.getA() + "-" + op.getB();

        this.rabbitMQService.sendMessage("Operation", msg);
        return "result: " + op.getA().subtract(op.getB());
    }

    @RequestMapping("divide")
    public String divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        op.setA(a);
        op.setB(b);

        System.out.println(op.getA() + "/" + op.getB());

        String msg = op.getA() + "/" + op.getB();

        this.rabbitMQService.sendMessage("Operation", msg);
        return "result: " + op.getA().divide(op.getB(), RoundingMode.DOWN);
    }
}
