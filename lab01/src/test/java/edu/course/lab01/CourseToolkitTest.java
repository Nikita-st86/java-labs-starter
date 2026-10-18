package edu.course.lab01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CourseToolkitTest {

    // ==========================================
    // ТЕСТЫ ДЛЯ isEven (Стартовые + домашка)
    // ==========================================
    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);
        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);
        assertFalse(result);
    }

    // --- Подготовительная часть (Домашнее задание на -8) ---
    @Test
    void returnsTrueForNegativeEvenNumber() {
        assertTrue(CourseToolkit.isEven(-8));
    }

    // ==========================================
    // ТЕСТЫ ДЛЯ isPrime (Обязательное задание)
    // ==========================================
    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        // Контракт 1
        assertFalse(CourseToolkit.isPrime(-5));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void isPrimeHandlesTwoCorrectly() {
        // Контракт 2
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void isPrimeHandlesCompositeNumbers() {
        // Контракт 2
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(100));
    }

    @Test
    void isPrimeHandlesSquaresOfPrimesCorrectly() {
        // Контракт 2: проверка квадратов простых чисел (49 = 7 * 7)
        assertFalse(CourseToolkit.isPrime(49));
        assertFalse(CourseToolkit.isPrime(9));
    }

    @Test
    void isPrimeReturnsTrueForLargePrime() {
        assertTrue(CourseToolkit.isPrime(97));
    }

    // ==========================================
    // ТЕСТЫ ДЛЯ isPalindrome (Обязательное задание)
    // ==========================================
    @Test
    void isPalindromeReturnsTrueForValidPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("madam"));
        assertTrue(CourseToolkit.isPalindrome("racecar"));
        assertTrue(CourseToolkit.isPalindrome("a"));
    }

    @Test
    void isPalindromeReturnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("hello"));
        assertFalse(CourseToolkit.isPalindrome("ab"));
    }

    @Test
    void isPalindromeIsCaseAndSpaceSensitive() {
        // Контракт 3: регистр и пробелы значимы
        assertFalse(CourseToolkit.isPalindrome("Madam"));
        assertFalse(CourseToolkit.isPalindrome("mad am"));
    }

    @Test
    void isPalindromeThrowsExceptionForNull() {
        // Контракт 4
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    // ==========================================
    // ТЕСТЫ ДЛЯ average (Обязательное задание)
    // ==========================================
    @Test
    void averageReturnsCorrectResultForNormalArray() {
        // Обычный сценарий
        assertEquals(2.0, CourseToolkit.average(new int[]{1, 2, 3}));
    }

    @Test
    void averageReturnsCorrectResultForNegativeNumbers() {
        // Отрицательный сценарий
        assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -2, -3}));
    }

    @Test
    void averageDoesNotModifyInputArray() {
        // Контракт 5: не изменяет входной массив
        int[] original = {1, 2, 3};
        int[] copy = original.clone();

        CourseToolkit.average(original);

        assertArrayEquals(copy, original, "Метод не должен изменять входной массив");
    }

    @Test
    void averageThrowsExceptionForNullOrEmptyArray() {
        // Контракт 6: ошибочный сценарий
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[]{}));
    }
}
