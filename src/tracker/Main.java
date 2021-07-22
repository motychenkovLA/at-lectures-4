package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String block = "Blocker";
        final String critical = "Critical";
        final String major = "Major";
        final String minor = "Minor";
        final String trivial = "Trivial";
        final int LIMIT = 10;
        String exitProgramm = "";
        String transition = "";
        int Counter = 0;
        int[] number = new int[LIMIT];
        String[] summary = new String[LIMIT];
        String[] priority = new String[LIMIT];
        int[] leadTime = new int[LIMIT];

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            transition = scanner.nextLine();
            switch (transition) {
                case "add":
                    if (Counter == LIMIT) {
                        System.out.println("Нельзя добавить больше 10 дефектов.\n");
                    } else {
                        number[Counter] = Counter;
                        System.out.println("Введите резюме дефекта");
                        summary[Counter] = scanner.nextLine();
                        System.out.println("Выберите критичность дефекта:");
                        System.out.printf(" 1. %s \n 2. %s \n 3. %s \n 4. %s \n 5. %s \n ", block, critical, major, minor, trivial);
                        priority[Counter] = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        leadTime[Counter] = scanner.nextInt();
                        Counter++;
                    }
                    break;
                case "list":
                    System.out.println("Список дефектов:");
                    if (Counter == 0) {
                        System.out.println("Нет дефектов.\n");
                    } else {
                        int index = 0;
                        while (index < Counter) {
                            System.out.println("***********************");
                            System.out.printf("Номер дефекта: %d | Резюме дефекта: %s | Серьезность: %s | Количество дней на исправление: %d \n", number[index], summary[index], priority[index], leadTime[index]);
                            index++;
                        }
                        System.out.println("***********************\n");
                        System.out.println();
                        index = 0;
                    }
                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    exitProgramm = "exit";
                    break;
            }
        } while (exitProgramm != "exit");


    }
}