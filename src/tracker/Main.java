package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        int defectCounter = 0;
        final int DEFECT_LIMIT = 10;
        String[] defectResume = new String[DEFECT_LIMIT];
        String[] defectCriticality = new String[DEFECT_LIMIT];
        int[] daysToFix = new int[DEFECT_LIMIT];
        while (keepRunning) {
            System.out.println("Главное меню:\n1.Добавить новый дефект (Введите \"add\"),\n2.Вывести список дефектов (Введите \"list\"),\n3.Выйти из программы (Введите \"quit\")\n");
            System.out.println("Введите команду:");
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    if (defectCounter == DEFECT_LIMIT) {
                        System.out.println("\nПревышено количество дефектов. Система может хранить только 10 дефектов\n");
                    } else {
                        System.out.println();
                        System.out.println("Введите резюме дефекта:");
                        defectResume[defectCounter] = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (очень высокий, высокий, средний, низкий, очень низкий):");
                        defectCriticality[defectCounter] = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                        daysToFix[defectCounter] = scanner.nextInt();
                        scanner.nextLine();
                        ++defectCounter;
                        System.out.println();
                        break;
                    }
                    break;
                case "list":
                    if (defectCounter == 0) {
                        System.out.println("\nВ систему еще не добавлено ни одного дефекта\n");
                    } else {
                        System.out.println();
                        System.out.println("Список дефектов:");
                        for (int i = 0; i < defectCounter; i++) {
                            System.out.println();
                            System.out.println("Номер: " + i);
                            System.out.println("Резюме: " + defectResume[i]);
                            System.out.println("Серьезность: " + defectCriticality[i]);
                            System.out.println("Количество дней на исправление: " + daysToFix[i]);
                            System.out.println();
                        }
                    }
                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Команда не распознана\n");
                    break;
            }
        }
    }
}
