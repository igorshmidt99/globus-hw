package org.example;

public class FileSession implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("NetworkConnection");
    }
}
