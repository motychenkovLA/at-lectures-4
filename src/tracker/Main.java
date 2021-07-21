package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String team = "";
        int defectCounter = 0;
        final int LIMIT = 10;
        int[] defectNumber = new int[LIMIT];
        String[] defectSummary = new String[LIMIT];
        String[] defectСriticality = new String[LIMIT];
        String exitPoint = "";
        int[] defectDaysToFix = new int[LIMIT];
        Scanner sc = new Scanner(System.in);
        while (exitPoint.equals("")) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            team = sc.nextLine();
            switch (team) {
                case "add":
                    if (defectCounter == LIMIT) {
                        System.out.println("Не возможно добавить больше 10 дефектов.\n");
                    } else {
                        defectNumber[defectCounter] = defectCounter;
                        System.out.println("\nВведите резюме дефекта.");
                        defectSummary[defectCounter] = sc.nextLine();
                        System.out.println("\nВведите критичность дефекта. Варианты: Блокирующий, Высокий, Средний, Низкий.");
                        defectСriticality[defectCounter] = sc.nextLine();
                        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
                        defectDaysToFix[defectCounter] = sc.nextInt();
                        sc.nextLine();
                        defectCounter++;
                        System.out.println("Дефект сохранен.\n");
                    }
                    break;
                case "list":
                    System.out.println("Заведенные дефекты:");
                    if (defectCounter == 0) {
                        System.out.println("Дефекты отсутствуют.\n");
                    } else {
                        int inputСounter = 0;
                        while (inputСounter < defectCounter) {
                            System.out.println("-----------------------------------------------------");
                            System.out.println("Номер: " + defectNumber[inputСounter] +
                                    ".\nРезюме: " + defectSummary[inputСounter] +
                                    ".\nКритичность: " + defectСriticality[inputСounter] +
                                    ".\nКолличество дней на исправление: " + defectDaysToFix[inputСounter]);
                            inputСounter++;
                        }
                        System.out.println("-----------------------------------------------------\n");
                        System.out.println();
                        inputСounter = 0;
                    }
                    break;

                case "quit":
                    System.out.println("Выход из программы.");
                    exitPoint = "exit";
                    break;

                default:
                    System.out.println("\nКоманда не распознана. Попробуйте снова.\n");
                    break;
            }
        }
    }
}

