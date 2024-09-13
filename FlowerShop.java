import java.util.List;
import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Bouquet bouquet = new Bouquet();

            // Добавляем несколько цветов
            bouquet.addFlower(new Rose(5.0, 2, 50));
            bouquet.addFlower(new Tulip(3.0, 1, 40));
            bouquet.addFlower(new Rose(7.0, 3, 55));
            bouquet.addFlower(new Tulip(4.0, 4, 45));

            // Добавляем аксессуар
            System.out.println("Введите стоимость аксессуаров для букета:");
            double accessoryPrice = scanner.nextDouble();
            bouquet.setAccessoryPrice(accessoryPrice);

            // Отображаем букет
            System.out.println("\nБукет перед сортировкой по свежести:");
            bouquet.displayBouquet();

            // Сортировка по свежести
            bouquet.sortFlowersByFreshness();
            System.out.println("\nБукет после сортировки по свежести:");
            bouquet.displayBouquet();

            // Фильтрация по длине стебля
            System.out.println("\nВведите минимальную и максимальную длину стебля для фильтрации:");
            double minStem = scanner.nextDouble();
            double maxStem = scanner.nextDouble();
            List<Flower> filteredFlowers = bouquet.filterByStemLength(minStem, maxStem);

            System.out.println("\nЦветы с длиной стебля от " + minStem + " до " + maxStem + " см:");
            for (Flower flower : filteredFlowers) {
                System.out.println(flower);
            }

            // Общая стоимость букета
            System.out.println("\nОбщая стоимость букета: " + bouquet.getTotalPrice() + " у.е.");
        }
    }
}
