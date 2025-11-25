package ua.opnu;
// Необхідні імпорти
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EasyTasks {

    public static void main(String[] args) {
        // Залиште порожнім або використовуйте для ручного тестування
    }

    /**
     * Завдання 1: Повертає новий список, де кожне значення помножено на 2.
     * Використовує операцію map().
     */
    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    /**
     * Завдання 2: Повертає новий список, де кожне значення помножено само на себе (квадрат).
     * Використовує операцію map().
     */
    public List<Integer> square(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    /**
     * Завдання 3: Додає символ 'y' до початку та кінця кожного рядка.
     * Використовує операцію map().
     */
    public List<String> moreY(List<String> strings) {
        return strings.stream()
                .map(s -> "y" + s + "y")
                .collect(Collectors.toList());
    }

    /**
     * Завдання 4: Повертає новий список, до якого не входять числа менше 0 (від'ємні).
     * Використовує операцію filter().
     */
    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n >= 0)
                .collect(Collectors.toList());
    }

    /**
     * Завдання 5: Повертає новий список, до якого не входять числа, які закінчуються на 9.
     * Використовує операцію filter().
     */
    public List<Integer> no9(List<Integer> nums) {
        return nums.stream()
                .filter(n -> Math.abs(n % 10) != 9) // Перевіряємо, що остання цифра не 9, враховуючи від'ємні
                .collect(Collectors.toList());
    }

    /**
     * Завдання 6: Повертає новий список, до якого не входять рядки, які містять літеру 'z'.
     * Використовує операцію filter().
     */
    public List<String> noZ(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.contains("z"))
                .collect(Collectors.toList());
    }

    /**
     * Завдання 7: Повертає новий список, який не містить однакових рядків та рядки відсортовані
     * у порядку зменшення довжини рядку.
     * Використовує distinct() та sorted().
     */
    public List<String> refinedStrings(List<String> strings) {
        return strings.stream()
                .distinct() // Робить рядки унікальними
                // Сортування: порівнюємо довжину і використовуємо .reversed() для зменшення
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Завдання 8: Розбиває рядки "Ім'я Прізвище" на окремі слова та повертає їх у єдиному списку.
     * Використовує операцію flatMap().
     */
    public List<String> flatten(List<String> strings) {
        return strings.stream()
                // Розбиває рядок на масив (потік) слів за пробілом і об'єднує всі потоки в один
                .flatMap(name -> Arrays.stream(name.split(" ")))
                .collect(Collectors.toList());
    }
}