package org.example;

public class NetworkConnection implements AutoCloseable {
    private final boolean throwException;

    public NetworkConnection(boolean throwException) {
        this.throwException = throwException;
    }

    @Override
    public void close() throws Exception {
        System.out.println("FileSession");
        if (throwException) {
            throw new Exception("Ошибка");
        }
    }
}
