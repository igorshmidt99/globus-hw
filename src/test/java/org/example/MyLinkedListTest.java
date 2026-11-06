package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void sizeShouldEqualsNotZero() {
        MyLinkedList<String> strings = new MyLinkedList<>();

        strings.add("String 1");
        strings.add("String 2");

        assertEquals(2, strings.size());
    }

    @Test
    void getShouldReturnRightValues() {
        MyLinkedList<String> strings = new MyLinkedList<>();
        String expected = "String 1";
        String expected1 = "String 2";

        strings.add(expected);
        strings.add(expected1);

        String actual = strings.get(0);
        String actual1 = strings.get(1);

        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
    }

    @Test
    void getShouldThrowIndexOutOfBounds() {
        MyLinkedList<String> strings = new MyLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> strings.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> strings.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> strings.get(2));
    }

    @Test
    void removeShouldThrowIndexOutOfBounds() {
        MyLinkedList<String> strings = new MyLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> strings.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> strings.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> strings.remove(2));
    }

    @Test
    void removeShouldDeleteElement() {
        MyLinkedList<String> strings = new MyLinkedList<>();
        String expected = "String 1";
        String expected1 = "String 2";

        strings.add(expected);
        strings.add(expected1);

        assertTrue(strings.remove(expected));
        assertEquals(1, strings.size());
    }

    @Test
    void removeByIndexShouldDeleteElement() {
        MyLinkedList<String> strings = new MyLinkedList<>();
        String expected = "String 1";
        String expected1 = "String 2";

        strings.add(expected);
        strings.add(expected1);

        assertEquals(expected, strings.remove(0));
        assertEquals(1, strings.size());
    }


}