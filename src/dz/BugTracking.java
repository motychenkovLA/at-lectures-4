package dz;

import java.util.Scanner;

public class BugTracking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] db = new String[10][4];

        boolean menu = true;
        int number = 0;

        while (menu) {
            System.out.println("\nВведите команду: \nadd - добавить новый дефект" +
                    "\nlist - вывести весь список дефектов" +
                    "\nquit - Главное меню");
            String input = scanner.nextLine();
            menu = "add".equals(input);


            switch (input) {
                case "add": {
                    System.out.println("\nВведите описание дефекта:");
                    String bugReport = scanner.nextLine();

                    System.out.println("\nВведите критичность дефекта:\nBlocker\nCritical\nMajor\nTrivial");
                    String critical = scanner.nextLine();

                    System.out.println("\nВведите ожидаемое количество дней на исправление дефекта:");
                    String termDays = scanner.nextLine();


                    db[number][1] = bugReport;
                    db[number][2] = critical;
                    db[number][3] = termDays + " - дней на исправление";
                    number++;
                    break;
                }
                case "list":
                    //Вывести данные массива в консоль
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 4; j++) {
                            //String stringArraysDB = Arrays.toString(db);
                            System.out.print(db[i][j] + " | ");
                        }
                        System.out.println("");
                    }

                case "quit":
                    menu = true;
            }
        }
    }
}
