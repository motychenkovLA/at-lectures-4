package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean keepRunning = true;
        Repository repository = createRepository();
        while (keepRunning) {
            switch (getCommand()) {
                case "add":
                    if (Defect.getDefectCounter() == repository.getDefectsList().length) {
                        System.out.println("\nПревышено количество дефектов. Количество дефектов, которые могут храниться в репозитории:" + repository.getDefectsList().length);
                    } else {
                        repository.add(createDefect());
                    }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nГлавное меню:\n1.Добавить новый дефект (Введите \"add\"),\n2.Вывести список дефектов (Введите \"list\"),\n3.Выйти из программы (Введите \"quit\")\n");
        System.out.println("Введите команду:");
        return scanner.nextLine();
    }

    static Defect createDefect() {
        Scanner scanner = new Scanner(System.in);
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

    static Repository createRepository() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание репозитория. Введите количество дефектов, которые могут храниться в репозитории:");
        int defectLimit = scanner.nextInt();
        scanner.nextLine();
        Repository repository = new Repository(defectLimit);
        System.out.println("Репозиторий создан");
        return repository;
    }
}
