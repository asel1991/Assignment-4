import java.util.ArrayList;

public class MathUtil {

    // Статические методы для выполнения различных математических операций

    // Метод для проверки, является ли число простым
    public static boolean isPrime(int n) {
        if (n <= 1) return false; // Числа <= 1 не являются простыми
        for (int i = 2; i * i <= n; i++) { // Проверяем делимость до корня из n
            if (n % i == 0) return false; // Если n делится на i, то n не простое
        }
        return true; // Если не нашли делителей, n простое
    }

    // Метод для вычисления наибольшего общего делителя (НОД) двух чисел
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; // Временная переменная для хранения b
            b = a % b; // Обновляем b как остаток от деления
            a = temp; // Обновляем a
        }
        return Math.abs(a); // Возвращаем абсолютное значение a
    }

    // Метод для вычисления наименьшего общего кратного (НОК) двух чисел
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b); // Используем формулу НОК
    }

    // Метод для вычисления n-го числа Фибоначчи
    public static int fibonacci(int n) {
        if (n <= 0) return 0; // Для n <= 0 возвращаем 0
        if (n == 1) return 1; // Для n = 1 возвращаем 1
        int a = 0, b = 1; // Начальные значения Фибоначчи
        for (int i = 2; i <= n; i++) { // Итеративный расчет Фибоначчи
            int temp = a + b; // Суммируем два предыдущих числа
            a = b; // Обновляем a
            b = temp; // Обновляем b
        }
        return b; // Возвращаем n-ное число Фибоначчи
    }

    // Метод для вычисления факториала числа
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative input not allowed"); // Обработка отрицательного ввода
        long result = 1; // Начальное значение результат
        for (int i = 2; i <= n; i++) { // Итеративный расчет факториала
            result *= i; // Умножаем на текущее i
        }
        return result; // Возвращаем факториал
    }

    // Нестатические методы для выполнения других математических операций

    // Метод для проверки, является ли число совершенным
    public boolean isPerfectNumber(int n) {
        if (n <= 1) return false; // Числа <= 1 не могут быть совершенными
        int sum = 0; // Переменная для суммы делителей
        for (int i = 1; i <= n / 2; i++) { // Ищем делители до n/2
            if (n % i == 0) sum += i; // Если i делитель, добавляем к сумме
        }
        return sum == n; // Проверяем, равна ли сумма числу
    }

    // Метод для вычисления суммы цифр числа
    public int sumOfDigits(int n) {
        int sum = 0; // Переменная для суммы
        while (n != 0) { // Пока n не равно 0
            sum += n % 10; // Добавляем последнюю цифру к сумме
            n /= 10; // Удаляем последнюю цифру
        }
        return sum; // Возвращаем сумму цифр
    }

    // Метод для реверсирования числа
    public int reverseNumber(int n) {
        int reversed = 0; // Переменная для перевернутого числа
        while (n != 0) { // Пока n не равно 0
            reversed = reversed * 10 + n % 10; // Добавляем последнюю цифру к перевернутому
            n /= 10; // Удаляем последнюю цифру
        }
        return reversed; // Возвращаем перевернутое число
    }

    // Метод для проверки, является ли число числом Армстронга
    public boolean isArmstrongNumber(int n) {
        int original = n; // Сохраняем оригинальное значение
        int sum = 0; // Переменная для суммы
        int numDigits = String.valueOf(n).length(); // Определяем количество цифр
        while (n != 0) { // Пока n не равно 0
            int digit = n % 10; // Получаем последнюю цифру
            sum += Math.pow(digit, numDigits); // Добавляем куб цифры к сумме
            n /= 10; // Удаляем последнюю цифру
        }
        return sum == original; // Проверяем, равна ли сумма оригинальному числу
    }

    // Метод для нахождения следующего простого числа
    public int nextPrime(int n) {
        int next = n + 1; // Начинаем проверку с n + 1
        while (!isPrime(next)) { // Пока не найдем простое число
            next++; // Переходим к следующему числу
        }
        return next; // Возвращаем найденное простое число
    }

    // Тестирование методов
    public static void main(String[] args) {
        // Тестирование статических методов
        System.out.println("Static Method Tests:");
        System.out.println("isPrime(5): " + MathUtil.isPrime(5)); // Проверка простоты числа
        System.out.println("gcd(48, 18): " + MathUtil.gcd(48, 18)); // Вычисление НОД
        System.out.println("lcm(4, 5): " + MathUtil.lcm(4, 5)); // Вычисление НОК
        System.out.println("fibonacci(6): " + MathUtil.fibonacci(6)); // Вычисление 6-го числа Фибоначчи
        System.out.println("factorial(5): " + MathUtil.factorial(5)); // Вычисление факториала 5

        // Тестирование нестатических методов
        MathUtil util = new MathUtil();
        System.out.println("\nNon-Static Method Tests:");
        System.out.println("isPerfectNumber(28): " + util.isPerfectNumber(28)); // Проверка на совершенное число
        System.out.println("sumOfDigits(12345): " + util.sumOfDigits(12345)); // Сумма цифр числа
        System.out.println("reverseNumber(12345): " + util.reverseNumber(12345)); // Перевернутое число
        System.out.println("isArmstrongNumber(153): " + util.isArmstrongNumber(153)); // Проверка на число Армстронга
        System.out.println("nextPrime(10): " + util.nextPrime(10)); // Нахождение следующего простого числа
    }
}
