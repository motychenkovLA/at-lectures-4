package tracker;
import tracker.enums.Critical;
import tracker.enums.Status;

import java.util.Scanner;

public class Tracking7 {
    final static int repoLength = 10;

    public static void main(String[] args) {
        Repository repository;
        //Для выхода из программы
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        repository = new Repository(repoLength);

        do {
            System.out.println("Введите комманду(add|list|quit|change): ");
            String com = scanner.nextLine();
            com = com.toLowerCase().trim();
            switch (com) {
                case "add":
                    if(repository.getIndex() < repoLength) {
                        System.out.println("\n\rВведите резюме дефекта:");
                        String defectSummary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
                        String criticalityDefect = scanner.nextLine().trim().toLowerCase();
                        Critical critical;
                        switch (criticalityDefect){
                            case "низкий":
                            case "н":
                                critical = Critical.LOW;
                                break;
                            case "средний":
                            case "с":
                                critical = Critical.MIDDLE;
                                break;
                            case "высокий":
                            case "в":
                                critical = Critical.HIGH;
                                break;
                            case "блокирующий":
                            case "б":
                                critical = Critical.BLOCK;
                                break;
                            default:
                                System.out.println("Ошибка ввода, присвоен статус по умолчанию Средний");
                                critical = Critical.MIDDLE;
                                break;
                        }
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
                            repository.add(new Defect(defectSummary, critical, workMoreWeek, attachment));
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
                case "change":
                    if (repository.getIndex() == 0){
                        System.out.println("Дефектов нет");
                    } else {
                        System.out.println("Введите номер дефекта [0-" + (repository.getIndex() - 1) + "]: ");
                        int defectId = scanner.nextInt();
                        if (defectId < repository.getIndex()) {
                            System.out.println("Введите статус дефекта (Открыто, Разработка, Тестирование, Готово): ");
                            scanner.nextLine();
                            String criticalityDefect = scanner.nextLine().trim().toLowerCase();
                            Status status;
                            switch (criticalityDefect) {
                                case "открыто":
                                case "о":
                                    status = Status.OPEN;
                                    break;
                                case "разработка":
                                case "р":
                                    status = Status.IN_DEVELOP;
                                    break;
                                case "тестирование":
                                case "т":
                                    status = Status.IN_RETEST;
                                    break;
                                case "готово":
                                case "г":
                                    status = Status.CLOSE;
                                    break;
                                default:
                                    System.out.println("Ошибка ввода, присвоен статус по умолчанию Открыто");
                                    status = Status.OPEN;
                                    break;
                            }

                            repository.getAll()[defectId].setStatusDefect(status);
                        } else {
                            System.out.println("Вы ввели не валидный номер дефекта");
                        }
                    }
                    break;
                default:
                    System.out.println("Не верная комманда!\n\r");
            }
        } while (flag);
        scanner.close();
    }
}