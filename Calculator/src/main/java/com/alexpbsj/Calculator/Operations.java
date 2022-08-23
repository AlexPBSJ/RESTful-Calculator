package com.alexpbsj.Calculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class Operations {
    public BigDecimal sum(BigDecimal a, BigDecimal b){
        BigDecimal sum = a.add(b);
        return sum;
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b){
        BigDecimal sum = a.subtract(b);
        return sum;
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b){
        BigDecimal sum = a.multiply(b);
        return sum;
    }

    public BigDecimal divide(BigDecimal a, BigDecimal b){
        BigDecimal sum = a.divide(b);
        return sum;
    }
}
