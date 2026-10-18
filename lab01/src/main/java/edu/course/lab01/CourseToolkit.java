package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Возвращает true, если число простое. Для чисел меньше 2 возвращает false.
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        // Перебираем делители до квадратного корня из числа.
        // Условие i * i <= number корректно обрабатывает квадраты простых чисел (например, 49).
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает true, если строка является палиндромом. Сравнение происходит с
     * учетом регистра и пробелов. Для null выбрасывает
     * IllegalArgumentException.
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Возвращает среднее арифметическое элементов массива. Не изменяет входной
     * массив. Для null или пустого массива выбрасывает
     * IllegalArgumentException.
     */
    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        double sum = 0;
        for (int value : values) {
            sum += value; // Только читаем массив, не изменяем его
        }

        return sum / values.length;
    }
}
