package org.example.OOPCalculator;

import java.util.List;
import java.util.Scanner;

public class Calculator implements operator {
    private final int precision;
    Scanner HandInsert = new Scanner(System.in);
    private double first;
    private double second;
    private double result;

    public Calculator(int precision) {
        this.precision = precision;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst() {
        this.first = EnterDoubleWithCheck("First");
    }

    public void setFirst(double a) {
        this.first = a;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond() {
        this.second = EnterDoubleWithCheck("Second");
    }

    public void setSecond(double b) {
        this.second = b;
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

    public double getResult() {
        return result;
    }

    public void PrintResult() {
        System.out.printf("Result: %%.%df".formatted(this.precision), this.result);
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setResult() {
        executeOperationWithCheck();
    }

    private void executeOperationWithCheck() {
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
        executeOperation(operation);
    }

    public void executeOperation(String operation) {
        setResult(switch (operation) {
            case "+" -> operator.add(this.getFirst(), this.getSecond());
            case "-" -> operator.sub(this.getFirst(), this.getSecond());
            case "*" -> operator.pow(this.getFirst(), this.getSecond());
            case "/" -> operator.div(this.getFirst(), this.getSecond());
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        });
    }
    public void PrintStartMessage(){
        System.out.println("Simple Calc OOP");
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