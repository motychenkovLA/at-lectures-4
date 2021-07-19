package tracker;

import java.util.Scanner;

public class Tracking2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            String [] defectSummary = new String[10];
            String [] criticalityDefect = new String[10];
            int [] workMoreWeek = new int[10];
            Boolean[] willTakeMoreWeek = new Boolean[10];
            int index = 0;
            do {
                System.out.println("Введите комманду(add|list|quit): ");
                String com = scanner.nextLine();
                com = com.toLowerCase().trim();
                switch (com) {
                    case "add":
                        if(index < 10) {
                            System.out.println("\n\rВведите резюме дефекта:");
                            defectSummary[index] = scanner.nextLine();
                            System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
                            criticalityDefect[index] = scanner.nextLine();
                            System.out.println("Введите ожидаемый срок исполнения: ");
                            workMoreWeek[index] = scanner.nextInt();
                            willTakeMoreWeek[index] = workMoreWeek[index] > 5;
                            System.out.println("\n\rРезюме дефекта:"
                                    + defectSummary[index]
                                    + "\n\rкритичность дефекта: " + criticalityDefect[index]
                                    + "\n\rожидаемый срок исполнения: " + workMoreWeek[index]
                                    + "\n\rЗаймет больше рабочей недели? " + willTakeMoreWeek[index] + "\n\r");
                            scanner.nextLine();
                            index++;
                        } else {
                            System.out.println("Достигнуто максмальное количество дефектов!\n\r");
                        }
                        break;
                    case "list":
                        for (int i = 0; i<index; i++){
                            System.out.println(i + "|" + defectSummary[i] + "|" + criticalityDefect[i] + "|"
                                    + workMoreWeek[i] + "\n\r");
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
