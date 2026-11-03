package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WrongMoneyTest {

    @Test
    @DisplayName("Контейнер будет содержать два объекта из-за некорректно реализации HashCode")
    void shouldContainsTwoElements() {
        WrongMoney first = new WrongMoney("RUB", BigDecimal.valueOf(10L));
        WrongMoney second = new WrongMoney("RUB", BigDecimal.valueOf(10L));
        Set<WrongMoney> container = new HashSet<>();

        container.add(first);
        container.add(second);

        assertEquals(first, second);
        assertEquals(2, container.size());
    }

}