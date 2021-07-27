package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Резюме дефекта");
        Scanner scanner = new Scanner(System.in);
        String NameDef = scanner.nextLine();
        System.out.println("Ввести критичность дефекта из предложенных вариантов: Trivial, Minor, Major, Critical, Blocker");
        Scanner scanner1 = new Scanner(System.in);
        String CriticalDef = scanner.nextLine();
        final int DaysWeek = 7;
        System.out.println("Ввести кол-во дней на исправление дефекта");
        Scanner scanner2 = new Scanner(System.in);
        int DaysEdit = scanner.nextInt();
        boolean BigWeek = DaysEdit >= DaysWeek;

        System.out.println("Резюме дефекта: " + NameDef + "|Критичность: " + CriticalDef + "|Кол-во дней: " + DaysEdit + "|Займёт больше рабочей недели: " + BigWeek);


    }
}
