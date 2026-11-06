package org.example;

public class DatabaseConnection implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("DatabaseConnection");
    }
}
