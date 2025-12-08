package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Класс представляющий собой базовый консольный калькулятор
 */
public class CalculatorFirstExercise {
    /**
     * Базовый конструктор без параметров (Первое задание)
     */
    public CalculatorFirstExercise() {
        Scanner HandInsert = new Scanner(System.in);
        System.out.println("Simple Calc");
        float fFirst = EnterFloatWithCheck("first", HandInsert);
        float fSecond = EnterFloatWithCheck("second", HandInsert);
        float fResult = ExecuteOperationWithCheck(HandInsert, fFirst, fSecond);
        System.out.printf("Result:%.4f", fResult);
        HandInsert.close();
    }

    /**
     * Конструктор с заранее объявленным Scanner (второе задание)
     *
     * @param scan Scanner - инпут для более простого встраивания в программу, требующую выбор режима работы через консоль
     */
    public CalculatorFirstExercise(Scanner scan) {
        System.out.println("Simple Calc");
        float fFirst = EnterFloatWithCheck("first", scan);
        float fSecond = EnterFloatWithCheck("second", scan);
        float fResult = ExecuteOperationWithCheck(scan, fFirst, fSecond);
        System.out.printf("Result:%.4f", fResult);
    }


    /**
     * Метод для ввода float чисел с проверкой на корректный ввод
     *
     * @param Pos  String - позиция числа в уровнении (First,Second)
     * @param scan Scanner - консольный инпут
     * @return float - корректно введеное число
     */
    private float EnterFloatWithCheck(String Pos, Scanner scan) {
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

    /**
     * Метод для корректного считывания операции и основное вычисление класса
     *
     * @param scan Scanner - консольный инпут
     * @param a    float - первое число
     * @param b    float - второе число
     * @return результат работы калькулятора
     */
    private float ExecuteOperationWithCheck(Scanner scan, float a, float b) {
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

}
