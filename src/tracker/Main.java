package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int LIMIT = 10;
        String exitProgram = "";
        String transition = "";
        int counter = 0;
        Defect[] defectList = new Defect[LIMIT];
        Scanner scanner = new Scanner(System.in);


        while (exitProgram != "exit") {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            transition = scanner.nextLine();
            switch (transition) {
                case "add":
                    if (counter == LIMIT) {
                        System.out.println("Нельзя добавить больше 10 дефектов.\n");
                    } else {
                        System.out.println("Введите резюме дефекта");
                        String summary = scanner.nextLine();
                        System.out.println("Выберите критичность дефекта:");
                        System.out.println(" 1. Blocker \n 2. Critical \n 3. Major \n 4. Minor \n 5. Trivial \n ");
                        String priority = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        int leadTime = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Дефект сохранен.\n");
                        defectList[counter] = new Defect(counter, summary, priority, leadTime);
                        counter++;
                    }
                    break;
                case "list":
                    System.out.println("Список дефектов:");
                    if (counter == 0) {
                        System.out.println("Нет дефектов.\n");
                    } else {
                        int index = 0;
                        while (index < counter) {
                            System.out.println(defectList[index].list());
                            index++;
                        }

                    }
                    break;

                case "quit":
                    System.out.println("Выход из программы");
                    exitProgram = "exit";
                    break;

                default:
                    System.out.println("\n Не понятно. Попробуй снова.\n");
                    break;
            }
        }


    }
}

