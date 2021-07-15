package dz;

import java.util.Scanner;

public class Dz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Введите критичность дефекта (очень высокий, высокий, средний, низкий, очень низкий):");
        String criticality = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        int countDays = scanner.nextInt();
        System.out.println("Резюме: " + resume);
        System.out.println("Серьезность: " + criticality);
        System.out.println("Количество дней на исправление: " + countDays);
        System.out.println("Займет больше рабочей недели: " + (countDays>5));
    }
}
