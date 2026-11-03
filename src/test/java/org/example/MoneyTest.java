package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("Коллекция будет содержать один элемент из-за корректной реализации HashCode")
    void shouldContainsOneElement() {
        Money first = new Money("RUB", BigDecimal.valueOf(10L));
        Money second = new Money("RUB", BigDecimal.valueOf(10L));
        Set<Money> container = new HashSet<>();

        container.add(first);
        container.add(second);

        assertEquals(first, second);
        assertEquals(1, container.size());

    }

}