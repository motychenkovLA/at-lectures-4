package tracker;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LIMIT_DEF= 10;
    private static Repository repository = new Repository(LIMIT_DEF);

    public static void main(String[] args) {

        boolean keepRunning = true;
        String menuSelection = "";

        while (keepRunning) {
            System.out.println("Меню: \n - Для создания дефекта введите add. \n - Для отображения списка дефектов введите list. \n - выйти из программы введите quit.");
            menuSelection = scanner.nextLine();
            switch (menuSelection) {
                case "add":
                    System.out.println("Резюме дефекта");
                    String errorSummary = scanner.nextLine();

                    System.out.println("Ввести критичность дефекта из предложенных вариантов: Trivial, Minor, Major, Critical, Blocker");
                    String errorCriticality = scanner.nextLine();

                    System.out.println("Ввести кол-во дней на исправление дефекта");
                    int fixDays = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Дефект сохранен");

                    if (repository.isFull()) {
                        System.out.println("Невозможно добавить дефект. Количество дефектов, которые могут храниться: " + LIMIT_DEF);
                    } else {
                        repository.add(new Defect(errorSummary,errorCriticality,fixDays));
                    };
                    break;
                case "list":
                    System.out.println(repository.getAll());
                    break;
                case "quit":
                    System.out.println("Выход из меню");
                    keepRunning=false;
                    break;

                default:
                    System.out.println("Команда не распознана. Попробуйте снова.");
                    break;

            }
        }
    }
}
