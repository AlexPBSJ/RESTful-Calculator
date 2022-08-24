package Logic;

import java.io.Serializable;
import java.math.BigDecimal;

public class Operators implements Serializable {
    static final long serialVersionUID = 42L;
    private BigDecimal a;
    private BigDecimal b;
    private char type;
    private BigDecimal result;

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

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
