package tracker;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exitProgram;
        exitProgram = true;
        Repository repository = createRepository();

        while (exitProgram) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            String transition;
            transition = sc.nextLine();
            switch (transition) {
                case "add":
                    if (Repository.getDefectCounter() == repository.getDefectsList().length) {
                        System.out.println("Нельзя добавить больше " + repository.getDefectsList().length + " дефектов.\n");
                    } else {
                        repository.add(create());
                    }
                    break;
                case "list":
                    System.out.println(repository.getAllDefect());
                    break;

                case "quit":
                    System.out.println("Выход из программы");
                    exitProgram = false;
                    break;

                default:
                    System.out.println("\n Не понятно. Попробуй снова.\n");
                    break;
            }
        }


    }

    static Defect create() {
        System.out.println("\nВведите резюме дефекта.");
        String summary = sc.nextLine();
        System.out.println("\nВведите критичность дефекта.");
        System.out.println(" 1. Blocker \n 2. Critical \n 3. Major \n 4. Minor \n 5. Trivial \n ");
        String criticality = sc.nextLine();
        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
        int leadTime = sc.nextInt();
        sc.nextLine();
        System.out.println("Дефект сохранен.\n");
        return new Defect(summary, criticality, leadTime);
    }

    static Repository createRepository() {
        System.out.println("\nЗадайте максимальное колличество дефектов, которые будут храниться");
        int LimitOfDefects = sc.nextInt();
        sc.nextLine();
        while (LimitOfDefects < 1) {
            System.out.println("\nНе понятно. Попробуй снова.");
            LimitOfDefects = sc.nextInt();
            sc.nextLine();
        }
        final int LIMIT = LimitOfDefects;
        Repository repository = new Repository(LIMIT);
        System.out.println("\nМаксимальное колличество дефектов в репозитории: " + LIMIT + ".\n");
        return repository;
    }
}

