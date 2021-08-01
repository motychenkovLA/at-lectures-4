package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String team = "";
        int defectCounter = 0;
        final int LIMIT = 10;
        Defect[] defectList = new Defect[LIMIT];
        String exitPoint = "";
        Scanner sc = new Scanner(System.in);

        while (exitPoint.equals("")) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            team = sc.nextLine();
            switch (team) {

                case "add":
                    if (defectCounter == LIMIT) {
                        System.out.println("Не возможно добавить больше 10 дефектов.\n");
                    } else {
                        defectList[defectCounter] = new Defect(defectCounter);
                        defectCounter++;
                    }
                    break;

                case "list":
                    System.out.println("Заведенные дефекты:");
                    if (defectCounter == 0) {
                        System.out.println("Дефекты отсутствуют.\n");
                    } else {
                        int inputСounter = 0;
                        while (inputСounter < defectCounter) {
                            defectList[inputСounter].list();
                            inputСounter++;
                        }
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

