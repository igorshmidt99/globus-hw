package org.example;


public class Main {

    public static void main(String[] args) {

        System.out.println("Демонстрация порядка закрытия");

        try (DatabaseConnection db = new DatabaseConnection();
             FileSession file = new FileSession();
             NetworkConnection network = new NetworkConnection(false)) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Демонстрация suppressed exceptions");

        try (DatabaseConnection db = new DatabaseConnection();
             FileSession file = new FileSession();
             NetworkConnection network = new NetworkConnection(true)) {

            throw new Exception("Основная ошибка внутри try");

        } catch (Exception e) {

            System.out.println("Основное исключение: " + e.getMessage());

            System.out.println("Suppressed exceptions:");

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println(suppressed.getMessage());
            }
        }
    }
}
