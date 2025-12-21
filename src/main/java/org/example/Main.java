package org.example;

import org.example.OOPCalculator.Calculator;
import org.example.ThirdExercise.ThirdExcerciseClass;

import java.util.Scanner;

public class Main {
    void main(String[] args) {
        Scanner HandInsert = new Scanner(System.in);
        try {
            switch (args[0]) {
                case "1" -> new CalculatorFirstExercise();
                case "2" -> new SecondExercise(HandInsert);
                case "3" -> new ThirdExcerciseClass();
                case "4" -> new Calculator(4);
                case "5" -> new FifthExercise("FS/ListOfWords.txt");
                default -> throw new IllegalStateException("Unexpected value: " + args);
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } finally {
            HandInsert.close();
        }
    }

}
