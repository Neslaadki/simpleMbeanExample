package io;


import java.util.Scanner;

/**
 * Класс, который хравнит в себе объект класса Сканер и стандартный символ командной строки
 */

public class ConsoleReader {
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    private final Scanner scanner;

    /**
     * Требудется перенос defailtConsoleSymbol на клиента
     */

    public void getDefaultConsoleSymbol() {
        String defaultConsoleSymbol = ">> ";
        System.out.print(defaultConsoleSymbol);
    }


    public Scanner getScanner() {
        return scanner;
    }


}