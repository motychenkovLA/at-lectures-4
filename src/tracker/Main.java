package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        int defectCounter = 0;
        final int DEFECT_LIMIT = 10;
        Defect[] defectsList = new Defect[DEFECT_LIMIT];
        while (keepRunning) {
            System.out.println("Главное меню:\n1.Добавить новый дефект (Введите \"add\"),\n2.Вывести список дефектов (Введите \"list\"),\n3.Выйти из программы (Введите \"quit\")\n");
            System.out.println("Введите команду:");
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    if (defectCounter == DEFECT_LIMIT) {
                        System.out.println("\nПревышено количество дефектов. Система может хранить только 10 дефектов\n");
                    } else {
                        defectsList[defectCounter] = new Defect(defectCounter);
                        ++defectCounter;
                        System.out.println();
                        break;
                    }
                    break;
                case "list":
                    if (defectCounter == 0) {
                        System.out.println("\nВ систему еще не добавлено ни одного дефекта\n");
                    } else {
                        System.out.println();
                        System.out.println("Список дефектов:");
                        for (int i = 0; i < defectCounter; i++) {
                            defectsList[i].list();
                        }
                    }
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
}
