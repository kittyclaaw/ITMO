package utility;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для воода и вывода результата.
 */

public class StandardConsole implements Console {
    private static final String P = "$ ";
    private static Scanner fileScanner = null;
    private static final Scanner defScanner = new Scanner(System.in);

    /**
     * Выводит obj.toString() в консоль.
     * @param obj Объект для печати.
     */

    public void print(Object obj) {
        System.out.print(obj);
    }

    /**
     * Выводит obj.toString() + \n в консоль.
     * @param obj Объект для печати.
     */

    public void println(Object obj) {
        System.out.println(obj);
    }

    /**
     * Вывод ошибки: obj.toString() в консоль
     * @param obj Ошибка при печати.
     */

    public void printError(Object obj) {
        System.err.println("Error: " + obj);
        try {
            Thread.sleep(20);
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * Метод для запуска скрипта
     * @throws NoSuchElementException
     * @throws IllegalStateException
     */

    public String readln() throws NoSuchElementException, IllegalStateException {
        return (fileScanner != null ? fileScanner : defScanner).nextLine();
    }

    /**
     * Метод для запуска скрипта
     * @throws IllegalStateException
     */

    public boolean isCanReadln() throws IllegalStateException {
        return (fileScanner != null ? fileScanner : defScanner).hasNextLine();
    }

    /**
     * Выводит 2 колонки.
     * @param elementLeft Левывй элемент колонки.
     * @param elementRight Правый элемент колонки.
     */

    public void printTable(Object elementLeft, Object elementRight) {
        System.out.printf(" %-35s%-1s%n", elementLeft, elementRight);
    }

    /**
     * Нужна для вывода спецзнака '$'
     * Выводит promt текущей консоли
     */

    public void prompt() {
        print(P);
    }

    /**
     * Нужна для вывода спецзнака '$'
     * @return P
     */

    public String getPrompt() {
        return P;
    }

    /**
     * установка поля fileScanner
     * @param scanner
     */

    public void selectFileScanner(Scanner scanner) {
        fileScanner = scanner;
    }

    /**
     * установка поля fileScanner
     */

    public void selectConsoleScanner() {
        fileScanner = null;
    }
}
