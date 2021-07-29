package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int LIMIT_DEF= 10;
        boolean keepRunning = true;
        String menuSelection = "";
        int enumeratorDef = 0;
        String[] errorSummary = new String[LIMIT_DEF];
        String[] errorCriticality = new String[LIMIT_DEF];
        int[] fixDays = new int[LIMIT_DEF];

        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            System.out.println("Меню: \n - Для создания дефекта введите add. \n - Для отображения списка дефектов введите list. \n - выйти из программы введите quit.");
            menuSelection = scanner.nextLine();
            switch (menuSelection) {
                case "add":
                    if (enumeratorDef==LIMIT_DEF) {
                        System.out.println("Невозможно добавить больше 10 дефектов");
                    } else {

                        System.out.println("Резюме дефекта");
                        errorSummary[enumeratorDef] = scanner.nextLine();

                        System.out.println("Ввести критичность дефекта из предложенных вариантов: Trivial, Minor, Major, Critical, Blocker");
                        errorCriticality[enumeratorDef] = scanner.nextLine();

                        System.out.println("Ввести кол-во дней на исправление дефекта");
                        fixDays[enumeratorDef] = scanner.nextInt();
                        scanner.nextLine();

                        enumeratorDef++;
                        break;
                    }
                    break;
                case "list":
                    System.out.println("Список дефектов:");
                    if (enumeratorDef==0) {
                        System.out.println("Дефекты отсутствуют");
                    } else {
                        System.out.println();
                        for (int i=0; i < enumeratorDef; i++) {
                            System.out.println("Номер дефекта: " + i);
                            System.out.println("Резюме дефекта: " + errorSummary[i]);
                            System.out.println("Критичность дефекта: " + errorCriticality[i]);
                            System.out.println("Количество дней на исправление: " + fixDays[i]);

                        }
                    }
                    break;
                case "quit":
                    System.out.println("Выход из меню");
                    keepRunning=false;
                    break;

            }
        }
    }
}
