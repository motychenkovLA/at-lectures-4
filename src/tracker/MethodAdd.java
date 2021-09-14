package tracker;

import tracker.enums.Critical;
import tracker.enums.Status;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MethodAdd extends Defect {
    final static int repoLength = 10;

    public static void add(Repository repository, Scanner scanner) {
        if (repository.getIndex() < repoLength) {
            System.out.println("\n\rВведите резюме дефекта:");
            String defectSummary = scanner.nextLine();
            System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
            String criticalityDefect = scanner.nextLine().trim().toLowerCase();
            Critical critical;
            switch (criticalityDefect) {
                case "низкий":
                    critical = Critical.LOW;
                    break;
                case "средний":
                    critical = Critical.MIDDLE;
                    break;
                case "высокий":
                    critical = Critical.HIGH;
                    break;
                case "блокирующий":
                    critical = Critical.BLOCK;
                    break;
                default:
                    System.out.println("Ошибка ввода, присвоен статус по умолчанию Средний");
                    critical = Critical.MIDDLE;
                    break;
            }
            System.out.println("Введите ожидаемый срок исполнения: ");
            try {
                int workMoreWeek = scanner.nextInt();
                System.out.println("Выберети тип вложения (К)коментарий/(Д)дефект: ");
                scanner.nextLine();
                String attachmentType = scanner.nextLine();
                attachmentType = attachmentType.trim().toLowerCase();
                Attachment attachment = new Attachment();
                boolean enterError = false;
                switch (attachmentType) {
                    case "коментарий":
                        System.out.println("Введите комментарий: ");
                        String comment = scanner.nextLine();
                        attachment = new CommentAttachment(comment);
                        break;
                    case "дефект":
                        System.out.println("Введите номер дефекта: ");
                        int defectId = scanner.nextInt();
                        attachment = new DefectAttachment(defectId);
                        break;
                    default:
                        enterError = true;
                        break;
                }
                if (enterError) {
                    System.out.println("Нужно ввести К или Д");
                } else {
                    repository.add(new Defect(defectSummary, critical, workMoreWeek, attachment));
                    System.out.println(repository.getAll()[repository.getIndex() - 1]);
                }
            }catch (InputMismatchException e){
                System.out.println("Вы ввели неверное значение : " + e);
                System.out.println("Попробуйте еще раз : ");
                add(repository, scanner);
            }

        } else {
            System.out.println("Достигнуто максмальное количество дефектов!\n\r");
        }

    }

    public static void list(Repository repository) {
        Defect[] defects = repository.getAll();
        for (int i = 0; i < repository.getIndex(); i++) {
            System.out.println(defects[i].toString());
        }
    }

    public static void change(Repository repository, Scanner scanner) {
        if (repository.getIndex() == 0) {
            System.out.println("Дефектов нет");
        } else {
            System.out.println("Введите номер дефекта [0-" + (repository.getIndex() - 1) + "]: ");
            try {
                int defectId = scanner.nextInt();
                if (defectId < repository.getIndex()) {
                    System.out.println("Введите статус дефекта (Открыто, Разработка, Тестирование, Готово): ");
                    scanner.nextLine();
                    String criticalityDefect = scanner.nextLine().trim().toLowerCase();
                    Status status;
                    switch (criticalityDefect) {
                        case "открыто":
                            status = Status.OPEN;
                            break;
                        case "разработка":
                            status = Status.IN_DEVELOP;
                            break;
                        case "тестирование":
                            status = Status.IN_RETEST;
                            break;
                        case "готово":
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
            }catch (InputMismatchException e){
                System.out.println("Вы ввели неверное значение: " + e);
                System.out.println("Попробуйте еще раз : ");
                change(repository, scanner);
            }

        }
    }
}