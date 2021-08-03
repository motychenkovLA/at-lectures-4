package tracker;
import java.util.Scanner;
public class Tracking3 {
    public static void main(String[] args) {
        Defect[] defects = new Defect[10];
        boolean flag = true;
        int index = 0;


        do {
            System.out.println("Введите комманду(add|list|quit): ");
            Scanner scanner = new Scanner(System.in);
            String com = scanner.nextLine();
            com = com.toLowerCase().trim();
            switch (com) {
                case "add":
                    if(index < 10) {
                        System.out.println("\n\rВведите резюме дефекта:");
                        String defectSummary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
                        String criticalityDefect = scanner.nextLine();
                        System.out.println("Введите ожидаемый срок исполнения: ");
                        int workMoreWeek = scanner.nextInt();

                        defects[index] = new Defect(index, defectSummary, criticalityDefect, workMoreWeek);

                        System.out.println("\n\rИдентификатор дефекта:" + defects[index].getId()
                                +"\n\rРезюме дефекта:" + defects[index].getDefectSummary()
                                + "\n\rкритичность дефекта: " + defects[index].getCriticalityDefect()
                                + "\n\rожидаемый срок исполнения: " + defects[index].getWorkMoreWeek()
                                + "\n\rЗаймет больше рабочей недели? " + defects[index].getWillTakeMoreWeek() + "\n\r");
                        scanner.nextLine();
                        index++;
                    } else {
                        System.out.println("Достигнуто максмальное количество дефектов!\n\r");
                    }
                    break;
                case "list":
                    for (int i = 0; i<index; i++){
                        System.out.println(defects[i].getId()
                                + "|" + defects[i].getDefectSummary()
                                + "|" + defects[i].getCriticalityDefect()
                                + "|" + defects[i].getWillTakeMoreWeek() + "\n\r");
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