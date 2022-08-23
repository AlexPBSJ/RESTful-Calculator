package com.alexpbsj.Calculator.Logic;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

@Service
public class Operators implements Serializable {
    static final long serialVersionUID = 42L;
    BigDecimal a;
    BigDecimal b;

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }
}
