package com.alexpbsj.Calculator.Controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexpbsj.Calculator.Operations;

@RestController
@RequestMapping("sum")
public class SumController {
    
    @Autowired
    private Operations operation;

    @RequestMapping
    public BigDecimal sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        return operation.sum(a, b);
    }

}
