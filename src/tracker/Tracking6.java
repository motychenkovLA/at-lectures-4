package tracker;
import java.util.Locale;
import java.util.Scanner;

public class Tracking6 {
    final static int repoLength = 10;

    public static void main(String[] args) {
        Repository repository;
        //Для выхода из программы
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
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
                        System.out.println("Выберети тип вложения (К)коментарий/(Д)дефект: ");
                        scanner.nextLine();
                        String attachmentType = scanner.nextLine();
                        attachmentType = attachmentType.trim().toLowerCase();
                        Attachment attachment = new Attachment();
                        boolean enterError = false;
                        switch (attachmentType){
                            case "к":
                            case "коментарий":
                                System.out.println("Введите комментарий: ");
                                String comment = scanner.nextLine();
                                attachment = new CommentAttachment(comment);
                                break;
                            case "д":
                            case "дефект":
                                System.out.println("Введите номер дефекта: ");
                                int defectId = scanner.nextInt();
                                attachment = new DefectAttachment(defectId);
                                break;
                            default:
                                enterError = true;
                                break;
                        }

                        if (enterError){
                            System.out.println("Нужно ввести К или Д");
                        } else {
                            repository.add(new Defect(defectSummary, criticalityDefect, workMoreWeek, attachment));
                            System.out.println(repository.getAll()[repository.getIndex()-1]);
                            //scanner.nextLine();
                        }
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