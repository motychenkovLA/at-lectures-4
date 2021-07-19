package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        String[] resumeOfDef = new String[10];
        String[] criticalityOfDef = new String[10];
        int[] daysToFix = new int[10];
        while (keepRunning) {
            System.out.println("Главное меню:\n1.Добавить новый дефект (Введите \"add\"),\n2.Вывести список дефектов (Введите \"list\"),\n3.Выйти из программы (Введите \"quit\")\n");
            System.out.println("Введите команду:");
            String input = scanner.nextLine();
            keepRunning = !"quit".equals(input);
            {
                switch (input) {
                    case "add":
                        if (resumeOfDef[resumeOfDef.length - 1] != null) {
                            System.out.println("Превышено количество дефектов. Система может хранить только 10 дефектов\n");
                        } else {
                            for (int i = 0; i < resumeOfDef.length; i++) {
                                if (resumeOfDef[i] != null) continue;
                                System.out.println();
                                System.out.println("Введите резюме дефекта:");
                                resumeOfDef[i] = scanner.nextLine();
                                System.out.println("Введите критичность дефекта (очень высокий, высокий, средний, низкий, очень низкий):");
                                criticalityOfDef[i] = scanner.nextLine();
                                System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                                daysToFix[i] = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            }
                        }
                        break;
                    case "list":
                        if (resumeOfDef[0] == null) {
                            System.out.println("В систему еще не добавлено ни одного дефекта\n");
                        } else {
                            System.out.println();
                            System.out.println("Список дефектов:");
                            for (int i = 0; i < resumeOfDef.length; i++) {
                                if (resumeOfDef[i] == null) break;
                                System.out.println();
                                System.out.println("Номер: " + i);
                                System.out.println("Резюме: " + resumeOfDef[i]);
                                System.out.println("Серьезность: " + criticalityOfDef[i]);
                                System.out.println("Количество дней на исправление: " + daysToFix[i]);
                                System.out.println();
                            }
                        }
                        break;
                    case "quit":
                        System.out.println("Выход из программы");
                        break;
                    default:
                        System.out.println("Команда не распознана\n");
                        break;
                }
            }
        }
    }
}
