package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int DAYS_IN_WEEK = 7;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Резюме дефекта");
        String errorSummary = scanner.nextLine();

        System.out.println("Ввести критичность дефекта из предложенных вариантов: Trivial, Minor, Major, Critical, Blocker");
        String errorCriticality = scanner.nextLine();

        System.out.println("Ввести кол-во дней на исправление дефекта");
        int fixDays = scanner.nextInt();

        boolean isMoreThanAWeek = fixDays >= DAYS_IN_WEEK;

        System.out.println("Резюме дефекта: " + errorSummary + "|Критичность: " + errorCriticality + "|Кол-во дней: " + fixDays + "|Займёт больше рабочей недели: " + isMoreThanAWeek);


    }
}
