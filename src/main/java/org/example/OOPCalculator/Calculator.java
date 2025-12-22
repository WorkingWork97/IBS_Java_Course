package org.example.OOPCalculator;

import java.util.List;
import java.util.Scanner;

public class Calculator implements operator {
    Scanner HandInsert = new Scanner(System.in);
    private double first;
    private double second;

    public Calculator(int precision) {
        System.out.println("Simple Calc OOP");
        this.setFirst();
        this.setSecond();
        System.out.printf("Result: %%.%df".formatted(precision), this.executeOperationWithCheck());
    }

    public double getFirst() {
        return first;
    }

    public void setFirst() {
        this.first = EnterDoubleWithCheck("First");
    }

    public double getSecond() {
        return second;
    }

    public void setSecond() {
        this.second = EnterDoubleWithCheck("Second");
    }

    private float EnterDoubleWithCheck(String Pos) {
        boolean goodEnter = false;
        float a = 0;
        System.out.print("Enter " + Pos + " double number: ");
        while (!goodEnter) try {
            a = HandInsert.nextFloat();
            goodEnter = true;
        } catch (Exception e) {
            HandInsert.next();
            IO.print("Error while enter " + Pos + " double number\nEnter again: ");
        }
        return a;
    }

    private double executeOperationWithCheck() {
        boolean goodEnter = false;
        List<String> listOfOperations = List.of("+", "-", "/", "*");
        String operation = "";
        System.out.print("Select operation (+,-,/,*): ");
        while (!goodEnter) try {
            operation = HandInsert.next();
            if (listOfOperations.contains(operation)) {
                goodEnter = true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            IO.print("Error operation (+,-,/,*)\nEnter again: ");
        }
        return switch (operation) {
            case "+" -> operator.add(this.getFirst(), this.getSecond());
            case "-" -> operator.sub(this.getFirst(), this.getSecond());
            case "*" -> operator.pow(this.getFirst(), this.getSecond());
            case "/" -> operator.div(this.getFirst(), this.getSecond());
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}

interface operator {
    static double add(double a, double b) {
        return a + b;
    }

    static double sub(double a, double b) {
        return a - b;
    }

    static double pow(double a, double b) {
        return a * b;
    }

    static double div(double a, double b) {
        double result = 0;

        try {
            if (b == 0) {
                throw new ArithmeticException();
            } else {
                result = a / b;
            }
        } catch (Exception e) {
            IO.print("Error dividing by zero\n");
        }
        return result;
    }
}