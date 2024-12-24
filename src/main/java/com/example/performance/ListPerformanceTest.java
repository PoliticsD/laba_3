package com.example.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для сравнения производительности ArrayList и LinkedList.
 */
public class ListPerformanceTest {

    private static final int ITERATIONS = 1000;

    /**
     * Измеряет время, затраченное на выполнение определенной операции над списком.
     *
     * @param list      список, над которым выполняется операция
     * @param operation операция, которую нужно выполнить
     * @return время выполнения в миллисекундах
     */
    static long measureTime(List<Integer> list, Runnable operation) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Тестирует производительность операций add, delete и get для ArrayList и LinkedList.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Операция добавления
        long arrayListAddTime = measureTime(arrayList, () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                arrayList.add(i);
            }
        });

        long linkedListAddTime = measureTime(linkedList, () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                linkedList.add(i);
            }
        });

        // Операция получения
        long arrayListGetTime = measureTime(arrayList, () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                arrayList.get(i);
            }
        });

        long linkedListGetTime = measureTime(linkedList, () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                linkedList.get(i);
            }
        });

        // Операция удаления
        long arrayListDeleteTime = measureTime(arrayList, () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                arrayList.remove(0);
            }
        });

        long linkedListDeleteTime = measureTime(linkedList, () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                linkedList.remove(0);
            }
        });

        // Вывод результатов
        System.out.println("Операция\t\tТип списка\t\tВремя (мс)\t\tИтерации");
        System.out.println("Добавление\t\tArrayList\t\t" + arrayListAddTime + "\t\t\t" + ITERATIONS);
        System.out.println("Добавление\t\tLinkedList\t\t" + linkedListAddTime + "\t\t\t" + ITERATIONS);
        System.out.println("Получение\t\tArrayList\t\t" + arrayListGetTime + "\t\t\t" + ITERATIONS);
        System.out.println("Получение\t\tLinkedList\t\t" + linkedListGetTime + "\t\t\t" + ITERATIONS);
        System.out.println("Удаление\t\tArrayList\t\t" + arrayListDeleteTime + "\t\t\t" + ITERATIONS);
        System.out.println("Удаление\t\tLinkedList\t\t" + linkedListDeleteTime + "\t\t\t" + ITERATIONS);
    }


}