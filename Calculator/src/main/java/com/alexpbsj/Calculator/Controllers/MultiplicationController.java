package com.alexpbsj.Calculator.Controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexpbsj.Calculator.Operations;

@RestController
@RequestMapping("multiplication")
public class MultiplicationController {
    
    @Autowired
    private Operations operation;

    @RequestMapping
    public BigDecimal multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        return operation.multiply(a, b);
    }

}
