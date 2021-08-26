package tracker;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int REPO_SIZE = 10;
    private static Repository repository = new Repository(REPO_SIZE);

    public static void main(String[] args) {
        boolean continueProgram;
        continueProgram = true;

        while (continueProgram) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            String transition;
            transition = sc.nextLine();
            switch (transition) {
                case "add":
                    System.out.println("\nВведите резюме дефекта.");
                    String summary = sc.nextLine();
                    System.out.println("\nВведите критичность дефекта.");
                    System.out.println(" 1. Blocker \n 2. Critical \n 3. Major \n 4. Minor \n 5. Trivial \n ");
                    String priority = sc.nextLine();
                    System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
                    int leadTime = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Дефект сохранен.\n");
                    if (!repository.isFull()) {
                        repository.add(new Defect(summary, priority, leadTime));
                    } else {
                        System.out.println("Превышено количество дефектов. Количество дефектов, которые могут храниться в репозитории: " + REPO_SIZE);
                        System.out.println();
                    };
                    break;
                case "list":
                    System.out.println(repository.getAll());
                    break;

                case "quit":
                    System.out.println("Выход из программы");
                    continueProgram = false;
                    break;

                default:
                    System.out.println("\n Не понятно. Попробуй снова.\n");
                    break;
            }
        }


        }

}