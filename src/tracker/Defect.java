package tracker;

import java.util.Scanner;

public class Defect {
    long id;
    String defectResume;
    String defectCriticality;
    int daysToFix;

    public Defect(long id) {
        this.id = id;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        this.defectResume = scanner.nextLine();
        System.out.println("Введите критичность дефекта (очень высокий, высокий, средний, низкий, очень низкий):");
        this.defectCriticality = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        this.daysToFix = scanner.nextInt();
        scanner.nextLine();
    }

    void list() {
        System.out.println();
        System.out.println("Номер: " + this.id);
        System.out.println("Резюме: " + this.defectResume);
        System.out.println("Серьезность: " + this.defectCriticality);
        System.out.println("Количество дней на исправление: " + this.daysToFix);
        System.out.println();
    }

    public long getId() {
        return id;
    }

    public String getDefectResume() {
        return defectResume;
    }

    public String getDefectCriticality() {
        return defectCriticality;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDefectResume(String defectResume) {
        this.defectResume = defectResume;
    }

    public void setDefectCriticality(String defectCriticality) {
        this.defectCriticality = defectCriticality;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }
}
