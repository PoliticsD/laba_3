package com.example.performance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit тесты для класса ListPerformanceTest.
 */
class ListPerformanceTestTest {

    /**
     * Тест для проверки метода measureTime с ArrayList.
     */
    @Test
    void testMeasureTimeArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        long time = ListPerformanceTest.measureTime(arrayList, () -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });
        assertTrue(time >= 0, "Время выполнения должно быть неотрицательным");
    }

    /**
     * Тест для проверки метода measureTime с LinkedList.
     */
    @Test
    void testMeasureTimeLinkedList() {
        List<Integer> linkedList = new LinkedList<>();
        long time = ListPerformanceTest.measureTime(linkedList, () -> {
            for (int i = 0; i < 1000; i++) {
                linkedList.add(i);
            }
        });
        assertTrue(time >= 0, "Время выполнения должно быть неотрицательным");
    }

    /**
     * Тест для проверки метода measureTime с пустым Runnable.
     */
    @Test
    void testMeasureTimeEmptyRunnable() {
        List<Integer> arrayList = new ArrayList<>();
        long time = ListPerformanceTest.measureTime(arrayList, () -> {
            // Ничего не делаем
        });
        assertTrue(time >= 0, "Время выполнения должно быть неотрицательным");
    }
}