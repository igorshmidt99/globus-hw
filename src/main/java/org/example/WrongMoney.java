package org.example;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Random;

public class WrongMoney {

    private final String currency;
    private final BigDecimal amount;

    public WrongMoney(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WrongMoney that = (WrongMoney) o;
        return Objects.equals(currency, that.currency) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        Random random = new Random();
        return random.nextInt();
    }
}
