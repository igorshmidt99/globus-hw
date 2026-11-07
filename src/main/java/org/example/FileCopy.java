package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy {

    public void copyFile(String path) {
        try (FileInputStream stream = new FileInputStream(path)) {
            int data;
            long start = System.nanoTime();
            while ((data = stream.read()) != -1) {

            }
            long end = System.nanoTime();

            // привожу к мс
            System.out.println((end - start) / 1_000_000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void copyFileWithBuffer(String path) {
        try {
            long start = System.nanoTime();
            // используется чтение из фс с буффером внутри метода
            Files.readAllLines(Path.of(path));
            long end = System.nanoTime();

            // привожу к мс
            System.out.println((end - start) / 1_000_000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
