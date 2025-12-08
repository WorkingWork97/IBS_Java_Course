package org.example.ThirdExercise;

import java.util.Arrays;
import java.util.Random;

public class ThirdExcerciseClass {
    /**
     * Конструктор для третьего задания
     */
    public ThirdExcerciseClass() {
        RandomaArray();
        AssemblySweetPresent();
    }

    /**
     * Метод для части с рандомным массивом
     */
    private void RandomaArray(){
        System.out.println("Random int array part:");
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
        System.out.println("Switched ids " + Arrays.toString(idsMaxMin) + " int array:" + Arrays.toString(intArray));
    }

    /**
     * Метод для поиска в int[] массиве наибольшего отрицательного и наименьшего положительного числа
     * @param array массив в котором проходит поиск
     * @return возвращает int[]: int[0] хранится ID наибольшего отрицательного; int[1] хранится ID наименьшего положительного.
     */
    private int[] FindNumber(int[] array) {
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

    /**
     * Метод для сборки базового сладкого подарка
     */
    private void AssemblySweetPresent(){
        System.out.println("\nSweet present part:");
        JellyBean first = new JellyBean("M&Ms",150,232,"Only green and blue");
        Candy second = new Candy("Step",123,100,"Best choice for money");
        GingerBread third = new GingerBread("Tool pranyk",340,200,"Best from all country");
        double agrPrice = first.getSweetPrice()+second.getSweetPrice()+third.getSweetPrice();
        double agrWeight = first.getSweetWeight()+second.getSweetWeight()+ third.getSweetWeight();
        System.out.println("Sweet present weight: "+agrWeight+"; Price: "+agrPrice);
        System.out.println("Sweet present info:");
        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }
}
