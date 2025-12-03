package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class Main {
    void main(String[] args) {
        Scanner HandInsert = new Scanner(System.in);
        try {
            switch (args[0]) {
                case "1" -> Calculator(HandInsert);
                case "2" -> SecondExercise(HandInsert);
                case "3" -> ThirdExercise();
                default -> throw new IllegalStateException("Unexpected value: " + args);
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } finally {
            HandInsert.close();
        }
    }

    public void Calculator(Scanner scan) {
        System.out.println("Simple Calc");
        float fFirst = EnterFloatWithCheck("first", scan);
        float fSecond = EnterFloatWithCheck("second", scan);
        float fResult = ExecuteOperationWithCheck(scan, fFirst, fSecond);
        System.out.printf("Result:%.4f", fResult);
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

    public void SecondExercise(Scanner scan) {
        System.out.println("Enter number of task: (1 - calculator, 2 - string array)");
        int mode = scan.nextInt();
        switch (mode) {
            case 1 -> Calculator(scan);
            case 2 -> ArrayExercise(scan);
            default -> throw new IllegalStateException("Unexpected value");
        }
    }

    public void ArrayExercise(Scanner scan) {
        int maxLength = 0;
        int maxLengthId = 0;
        System.out.println("Enter array size:");
        int arraySize = scan.nextInt();
        String[] stringArray;
        stringArray = new String[arraySize];
        System.out.println("Enter " + arraySize + " words separated by Enter:");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = scan.next();
            if (stringArray[i].length() > maxLength) {
                maxLength = stringArray[i].length();
                maxLengthId = i;
            }
        }
        System.out.println("Maxed length word: " + stringArray[maxLengthId]);
    }

    public void ThirdExercise() {
        Random random = new Random();
        int[] intArray;
        intArray = new int[20];
        for (int i = 0; i < 20; i++) {
            intArray[i] = random.nextInt(20) - 10;
        }
        System.out.println("Random int array:" + Arrays.toString(intArray));
        int[] idsMaxMin = FindNumber(intArray);
        int buf = intArray[idsMaxMin[0]];
        intArray[idsMaxMin[0]] = intArray[idsMaxMin[1]];
        intArray[idsMaxMin[1]] = buf;
        System.out.println("Switched ids "+Arrays.toString(idsMaxMin)+" int array:" + Arrays.toString(intArray));
    }

    public int[] FindNumber(int[] array){
        int[] ids = new int[]{0, 0};
        int[] maxmin = new int[]{-10, 10};
        for (int i = 0; i < array.length; i++) {
            if (Math.signum(array[i]) == -1) {
                /*Max Negative*/
                if (array[i] > maxmin[0]) {
                    maxmin[0] = array[i];
                    ids[0] = i;
                }
            } else if (Math.signum(array[i]) == 1) {
                /*Min Positive*/
                if (array[i] < maxmin[1]) {
                    maxmin[1] = array[i];
                    ids[1] = i;
                }
            }
        }
        return ids;
    }

}
