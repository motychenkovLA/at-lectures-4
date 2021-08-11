package tracker;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exitPoint;
        exitPoint = true;
        Repository repository = createRepository();

        while (exitPoint) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            String command;
            command = sc.nextLine();
            switch (command) {

                case "add":
                    if (Repository.getDefectCounter() == repository.getDefectsList().length) {
                        System.out.println("Не возможно добавить больше " + repository.getDefectsList().length +" дефектов.\n");
                    } else {
                        repository.add(create());
                    }
                    break;

                case "list":
                    System.out.println(repository.getAll());
                    break;

                case "quit":
                    System.out.println("Выход из программы.");
                    exitPoint = false;
                    break;

                default:
                    System.out.println("\nКоманда не распознана. Попробуйте снова.\n");
                    break;
            }
        }
    }


    static Defect create() {
        System.out.println("\nВведите резюме дефекта.");
        String summary = sc.nextLine();
        System.out.println("\nВведите критичность дефекта. Варианты: Блокирующий, Высокий, Средний, Низкий.");
        String criticality = sc.nextLine();
        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
        int daysToFix = sc.nextInt();
        sc.nextLine();
        System.out.println("Дефект сохранен.\n");
        return new Defect(summary, criticality, daysToFix);
    }

    static Repository createRepository(){
        System.out.println("\nЗадайте колличество дефектов которые будет хранить репозиторий.");
        int LIM = sc.nextInt();
        sc.nextLine();
        while (LIM < 1) {
            System.out.println("\n\uD83D\uDE08Так не работает, введите натуральное число!\uD83D\uDE08");
            LIM = sc.nextInt();
            sc.nextLine();
        }
        final int LIMIT = LIM;
        Repository repository = new Repository(LIMIT);
        System.out.println("\nТеперь максимальное колличество дефектов в репозитории " + LIMIT + ".\n");
        return repository;
    }


}