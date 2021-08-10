package tracker;
import java.util.Scanner;

public class Tracking5 {
    public static void main(String[] args) {
        Repository repository;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ожидаемый количество дефектов: ");
        int repoLength = scanner.nextInt();
        scanner.nextLine();
        repository = new Repository(repoLength);

        do {
            System.out.println("Введите комманду(add|list|quit): ");
            String com = scanner.nextLine();
            com = com.toLowerCase().trim();
            switch (com) {
                case "add":
                    if(repository.getIndex() < repoLength) {
                        System.out.println("\n\rВведите резюме дефекта:");
                        String defectSummary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
                        String criticalityDefect = scanner.nextLine();
                        System.out.println("Введите ожидаемый срок исполнения: ");
                        int workMoreWeek = scanner.nextInt();

                        Defect tmp = new Defect(defectSummary, criticalityDefect, workMoreWeek);

                        repository.add(tmp);

                        System.out.println(tmp);
                        scanner.nextLine();
                    } else {
                        System.out.println("Достигнуто максмальное количество дефектов!\n\r");
                    }
                    break;
                case "list":
                    Defect[] defects = repository.getAll();
                    for (int i = 0; i<repository.getIndex(); i++){
                        System.out.println(defects[i].toString());
                    }
                    break;
                case "quit":
                    flag=false;
                    break;
                default:
                    System.out.println("Не верная комманда!\n\r");
            }
        } while (flag);
    }
}