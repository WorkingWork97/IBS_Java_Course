package org.example;

import java.util.Scanner;

public class SecondExercise {
    /**
     * Конструктор для второго упражнения
     * @param scan консольный инпут
     */
    public SecondExercise(Scanner scan) {
        System.out.println("Enter number of task: (1 - calculator, 2 - string array)");
        int mode = scan.nextInt();
        switch (mode) {
            case 1 -> new CalculatorFirstExercise(scan);
            case 2 -> ArrayExercise(scan);
            default -> throw new IllegalStateException("Unexpected value");
        }
    }

    /**
     * Метод для выполнения части связанной с массивом слов
     * @param scan консольный инпут
     */
    private void ArrayExercise(Scanner scan) {
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
}
