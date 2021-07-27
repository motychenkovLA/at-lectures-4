package dz;

import java.util.Scanner;

public class BugTracking {
    public static void main(String[] args) {

        final int DAYS_IN_WEEK = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите описание дефекта:");
        String bugReport = scanner.nextLine();

        System.out.println("\nВведите критичность дефекта:\nBlocker\nCritical\nMajor\nTrivial");
        String critical = scanner.nextLine();

        System.out.println("\nВведите ожидаемое количество дней на исправление дефекта:");
        int termdays = scanner.nextInt();

        boolean isToManyWeek = termdays > DAYS_IN_WEEK;

        System.out.print(bugReport + " | ");
        System.out.print(critical + " | ");
        System.out.print(termdays + " | ");
        System.out.print("займет больше рабочей недели " + "("+(isToManyWeek)+")");
    }
}
