package tracker;

import java.util.Scanner;

public class Defect {
    long id;
    String defectSummary;
    String defectСriticality;
    int defectDaysToFix;

    public Defect(long id) {
        Scanner sc = new Scanner(System.in);
        this.id = id;
        System.out.println("\nВведите резюме дефекта.");
        this.defectSummary = sc.nextLine();
        System.out.println("\nВведите критичность дефекта. Варианты: Блокирующий, Высокий, Средний, Низкий.");
        this.defectСriticality = sc.nextLine();
        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
        this.defectDaysToFix = sc.nextInt();
        sc.nextLine();
        System.out.println("Дефект сохранен.\n");
    }

    void list() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Номер: " + this.id +
                ".\nРезюме: " + this.defectSummary +
                ".\nКритичность: " + this.defectСriticality +
                ".\nКолличество дней на исправление: " + this.defectDaysToFix);
        System.out.println("-----------------------------------------------------\n");
    }

}
