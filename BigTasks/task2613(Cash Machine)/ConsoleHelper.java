package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String userInput = bis.readLine();

            if (userInput.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
            return userInput;
        } catch (IOException ignore) {

        }
        return null;

    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String userInput = readString();
        if (userInput == null || userInput.length() != 3) {
            writeMessage(res.getString("invalid.data"));
            userInput = askCurrencyCode();
        }
        return userInput.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currency) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currency));
        try {
            String input = readString();
            if (input == null || input.split(" ").length != 2)
                throw new IOException();
            int denomination = Integer.parseInt(input.split(" ")[0]);
            int count = Integer.parseInt(input.split(" ")[1]);
            if (denomination < 0 || count < 0)
                throw new IOException();
            return new String[]{String.valueOf(denomination), String.valueOf(count)};
        } catch (IOException e) {
            writeMessage(res.getString("invalid.data"));
            return getValidTwoDigits(currency);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation;
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.INFO"));
        writeMessage(res.getString("operation.DEPOSIT"));
        writeMessage(res.getString("operation.WITHDRAW"));
        writeMessage(res.getString("operation.EXIT"));
        operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
        return operation;
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
