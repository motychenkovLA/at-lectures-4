package tracker;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private final static int REPOSITORY_SIZE = 3;
    private static Repository repository = new Repository(REPOSITORY_SIZE);

    public static void main(String[] args) {
        boolean keepRunning = true;
        while (keepRunning) {
            switch (getCommand()) {
                case "add":
                    addDefect();
                    break;
                case "list":
                    System.out.println();
                    System.out.println("Список дефектов:");
                    System.out.println(repository.getAll());
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

    static String getCommand() {
        System.out.println("Главное меню:\n1.Добавить новый дефект (Введите \"add\"),\n2.Вывести список дефектов (Введите \"list\"),\n3.Выйти из программы (Введите \"quit\")\n");
        System.out.println("Введите команду:");
        return scanner.nextLine();
    }

    static Defect createDefect() {
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Введите критичность дефекта (очень высокий, высокий, средний, низкий, очень низкий):");
        String criticality = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        int daysToFix = scanner.nextInt();
        scanner.nextLine();
        return new Defect(resume, criticality, daysToFix);
    }

    static void addDefect() {
        if (!repository.isFull()) {
            repository.add(createDefect());
        } else {
            System.out.println("Превышено количество дефектов. Количество дефектов, которые могут храниться в репозитории: " + REPOSITORY_SIZE);
            System.out.println();
        }
    }

}
