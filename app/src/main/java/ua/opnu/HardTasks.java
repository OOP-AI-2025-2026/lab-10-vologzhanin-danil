package ua.opnu;

import ua.opnu.util.Customer;
import ua.opnu.util.DataProvider;
import ua.opnu.util.Order;
import ua.opnu.util.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate; // Потрібен для сортування дат

public class HardTasks {

    // Ці поля вже визначені у вашому коді
    private final List<Customer> customers = DataProvider.customers;
    private final List<Order> orders = DataProvider.orders;
    private final List<Product> products = DataProvider.products;

    public static void main(String[] args) {
        // ... (Ваш main метод залишається без змін)
    }

    // Примітка: Ви вже реалізували цей метод, я залишаю його як є.
    public List<Product> getBooksWithPrice() {
        // Завдання 1: Фільтрація за категорією 'Books' та ціною > 100
        return products.stream()
                .filter(p -> "Books".equalsIgnoreCase(p.getCategory()))
                .filter(p -> p.getPrice() > 100)
                .toList();
    }

    public List<Order> getOrdersWithBabyProducts() {
        // Завдання 2: Повертає список замовлень, які містять товари з категорії 'Baby'.
        // Використовуємо filter() та anyMatch() у вкладеному потоці.
        return orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> "Baby".equalsIgnoreCase(p.getCategory())))
                .toList();
    }

    public List<Product> applyDiscountToToys() {
        // Завдання 3: Знаходить товари 'Toys' та застосовує знижку 50%.
        // Використовуємо filter() для вибору та peek() для зміни об'єкта.
        return products.stream()
                .filter(p -> "Toys".equalsIgnoreCase(p.getCategory()))
                .peek(p -> p.setPrice(p.getPrice() * 0.5))
                .toList();
    }

    public Optional<Product> getCheapestBook() {
        // Завдання 4: Знаходить найбільш дешевий товар з категорії 'Books'.
        // Використовуємо filter() та min() з компаратором.
        return products.stream()
                .filter(p -> "Books".equalsIgnoreCase(p.getCategory()))
                .min(Comparator.comparing(Product::getPrice));
    }

    public List<Order> getRecentOrders() {
        // Завдання 5: Знаходить три останні замовлення (найновіші).
        // Використовуємо sorted() у зворотньому порядку та limit().
        return orders.stream()
                // Сортуємо за датою замовлення у зворотньому порядку (від найновіших до найстаріших)
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .toList();
    }

    public DoubleSummaryStatistics getBooksStats() {
        // Завдання 6: Повертає статистику для цін товарів категорії 'Books'.
        // Використовуємо filter(), mapToDouble() та summaryStatistics().
        return products.stream()
                .filter(p -> "Books".equalsIgnoreCase(p.getCategory()))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }

    public Map<Integer, Integer> getOrdersProductsMap() {
        // Завдання 7: Повертає відображення: id замовлення -> кількість товарів у замовленні.
        // Використовуємо Collectors.toMap().
        return orders.stream()
                .collect(Collectors.toMap(
                        Order::getId,               // Ключ: Order ID
                        o -> o.getProducts().size() // Значення: Розмір набору товарів
                ));
    }

    // Умова завдання: Має повертати Map<String, List<Product>>, але згідно вашій вірній відповіді
    // (Grocery : [3, 12, 14, 23, 25]), здається, що потрібно повернути список ID.
    // Я реалізую оригінальну умову (List<Product>), і варіацію з List<Integer> (ID)
    // *****************************************************************************************
    // ВАРІАНТ 1: Згідно оригінальній умові: Map<String, List<Product>>
    // public Map<String, List<Product>> getProductsByCategory() {
    //     // Завдання 8: Групування товарів за категорією.
    //     return products.stream()
    //             .collect(Collectors.groupingBy(Product::getCategory));
    // }
    // *****************************************************************************************

    // ВАРІАНТ 2: Згідно формату вашої "Вірної відповіді" (Map<String, List<Integer>> - список ID)
    public Map<String, List<Integer>> getProductsByCategory() {
        // Завдання 8: Групування ID товарів за категорією.
        // Використовуємо Collectors.groupingBy() та Collectors.mapping() для перетворення.
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getId, Collectors.toList()) // Збираємо лише ID
                ));
    }

}