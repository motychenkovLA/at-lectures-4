package dz;

import java.util.Scanner;

public class BugTracking {
    public static void main(String[] args) {

        System.out.println("Введите описание дефекта:");
        Scanner str = new Scanner(System.in);
        String bug_report;
        bug_report = str.nextLine();

        System.out.println("\nВведите критичность дефекта:\nBlocker\nCritical\nMajor\nTrivial");
        Scanner crit = new Scanner(System.in);
        String critical;
        critical = crit.nextLine();

        /*
        do {
            System.out.println("Message");
            critical = critical.nextLine();
        } while (critical != /////);

        ///
        if (critical == "Blocker" || critical == "Critical" || critical == "Major" || critical == "Trivial") {
            System.out.println("Условие работает!!!");
        } else {
            System.out.println("Введите критичность дефекта:\nBlocker\nCritical\nMajor\nTrivial");
        }
        critical = str.nextLine();
*/
/*
        do {
            //System.out.println("Пожалуйста, введите значение из списка:\nBlocker\nCritical\nMajor\nTrivial");
            critical = str.nextLine();
        } while (critical == "Blocker");
        while (critical == "Critical");
        while (critical == "Major");
        while (critical == "Trivial");
 */


        /////////////////

        System.out.println("\nВведите ожидаемое количество дней на исправление дефекта:");
        Scanner scanner = new Scanner(System.in);
        int termdays = scanner.nextInt();


        System.out.print(bug_report + " | ");
        System.out.print(critical + " | ");
        System.out.print(termdays + " | ");
        System.out.print("займет больше рабочей недели " + "("+(termdays > 5)+")");
    }
}
