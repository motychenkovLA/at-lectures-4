package tracker;

import java.util.Scanner;

public class Tracking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String defectSummary = scanner.nextLine();
        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
        String criticalityDefect = scanner.nextLine();
        System.out.println("Введите ожидаемый срок исполнения: ");
        int workMoreWeek = scanner.nextInt();
        boolean willTakeMoreWeek = workMoreWeek > 5;


        System.out.println("\n\rРезюме дефекта:"
                + defectSummary
                + "\n\r критичность дефекта:" + criticalityDefect
                + "\n\r ожидаемый срок исполнения:" + workMoreWeek
                + "\n\r Займет больше рабочей недели?" + willTakeMoreWeek);
    }
}
