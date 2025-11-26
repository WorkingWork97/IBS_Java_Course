package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    void main(String[] args) {
        try {
            switch (args[1]) {
                case "1" -> Calculator();
                case "2" -> SecondExercise();
                default -> throw new IllegalStateException("Unexpected value: " + args);
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    public void Calculator() {
        Scanner HandInsert = new Scanner(System.in);
        System.out.println("Simple Calc");
        float fFirst = EnterFloatWithCheck("first", HandInsert);
        float fSecond = EnterFloatWithCheck("second", HandInsert);
        float fResult = ExecuteOperationWithCheck(HandInsert, fFirst, fSecond);
        System.out.printf("Result:%.4f", fResult);
        HandInsert.close();
    }

    public float EnterFloatWithCheck(String Pos, Scanner scan) {
        boolean goodEnter = false;
        float a = 0;
        System.out.print("Enter " + Pos + " float number: ");
        while (!goodEnter) try {
            a = scan.nextFloat();
            goodEnter = true;
        } catch (Exception e) {
            scan.next();
            IO.print("Error while enter " + Pos + " float number\nEnter again: ");
        }
        return a;
    }

    public float ExecuteOperationWithCheck(Scanner scan, float a, float b) {
        boolean goodEnter = false;
        List<String> listOfOperations = List.of("+", "-", "/", "*");
        String operation = "";
        System.out.print("Select operation (+,-,/,*): ");
        while (!goodEnter) try {
            operation = scan.next();
            if (listOfOperations.contains(operation)) {
                goodEnter = true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            IO.print("Error operation (+,-,/,*)\nEnter again: ");
        }
        float result = switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        return result;
    }

    public void SecondExercise() {

    }

}
