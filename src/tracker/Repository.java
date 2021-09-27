package tracker;

import tracker.enums.Critical;
import tracker.enums.Status;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Repository {

    private Defect[] defects;
    private int index;
    private int repoLength;

    public Repository(int repoLength) {
        this.repoLength = repoLength;
        defects = new Defect[repoLength];
    }


    public void add() {
        if (index < repoLength) {
            System.out.println("\n\rВведите резюме дефекта:");
            Scanner scanner = new Scanner(System.in);
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
            try {
                System.out.println("Введите ожидаемый срок исполнения: ");
                int workMoreWeek = scanner.nextInt();
                System.out.println("Выберети тип вложения (К)коментарий/(Д)дефект: ");
                scanner.nextLine();
                String attachmentType = scanner.nextLine();
                attachmentType = attachmentType.trim().toLowerCase();
                Attachment attachment = new Attachment();
                boolean enterError = false;
                switch (attachmentType) {
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
                if (enterError) {
                    System.out.println("Нужно ввести К или Д");
                } else {
                    defects[index] = new Defect(defectSummary, critical, workMoreWeek, attachment);
                    index++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверное значение: " + e);
                System.out.println("Попробуйте еще раз");
            }


        } else {
            System.out.println("Достигнуто максмальное количество дефектов!\n\r");
        }
    }


    public void list() {
        for (int i = 0; i < index; i++) {
            System.out.println(defects[i].toString());
        }
    }

    public void change() {
        if (index == 0) {
            System.out.println("Дефектов нет");
        } else {
            System.out.println("Введите номер дефекта [0-" + (index - 1) + "]: ");
            try {
                Scanner scanner = new Scanner(System.in);
                int defectId = scanner.nextInt();
                if (defectId < index) {
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
                    defects[defectId].setStatusDefect(status);
                } else {
                    System.out.println("Вы ввели не валидный номер дефекта");
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверное значение: " + e);
                System.out.println("Попробуйте еще раз");
            }

        }
    }

}
