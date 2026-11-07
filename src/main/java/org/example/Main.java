package org.example;

public class Main {
    public static void main(String[] args) {
        FileCopy fileCopy = new FileCopy();

        fileCopy.copyFile("src/main/resources/file_70mb.txt");
        fileCopy.copyFileWithBuffer("src/main/resources/file_70mb.txt");

        /*
            Результат работы функции copyFile составляет 23509 мс
            Результат работы copyFileWithBuffer составляет 117 мс
            * Это объясняется разницей в количестве обращений к файловой системе и количеством операций ввода-вывода.
            copyFile читает не блоками, а побайтово, каждый раз обращаясь к файловой системе, и каждый раз используя ввод-вывод
            BufferedInputStream считывает заранее большой блок из файловой системы, загружая ее в оперативную память,
            таким образом сокращая обращения к файловой системе, и читает уже в последующем из оперативной памяти (буффера)
            Когда считал блок из оперативной памяти, вновь обращается к файловой системе
        * */

    }
}