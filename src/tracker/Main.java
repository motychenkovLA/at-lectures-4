package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private final  static int LIMIT_DEF= 10;
    private final static Repository repository = new Repository(LIMIT_DEF);

    public static void main(String[] args) {
        boolean keepRunning = true;
        while (keepRunning) {
            switch (getCommand()) {
                case "add":
                    addDefect();
                    break;
                case "list":
                    System.out.println();
                    System.out.println("Список дефектов:");
                    System.out.println(repository.getAll());
                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    keepRunning = false;
                    break;
                case "change":
                    changeStatus();
                    break;
                default:
                    System.out.println("Команда не распознана\n");
                    break;
            }
        }
    }

    static String getCommand() {
        System.out.println("Меню: \n - Для создания дефекта введите add. \n - Для отображения списка дефектов введите list. \n - Для изменения статуса дефекта введите change. \n - выйти из программы введите quit.");
        return scanner.nextLine();
    }

    static Defect createDefect() {
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        String errorSummary = scanner.nextLine();
        System.out.println("Введите критичность дефекта: blocker, critical, major, minor, trivial");
        Criticality criticality;

        switch (scanner.nextLine()) {
            case "blocker":
                criticality = Criticality.BLOCKER;
                break;
            case "critical":
                criticality = Criticality.CRITICAL;
                break;
            case "major":
                criticality = Criticality.MAJOR;
                break;
            case "minor":
                criticality = Criticality.MINOR;
                break;
            case "trivial":
                criticality = Criticality.TRIVIAL;
                break;
            default:
                criticality = Criticality.DEFAULT;
                System.out.println("Команда не распознана. Критичность не указана\n");
                break;
        }
        System.out.println("Ввести кол-во дней на исправление дефекта:");
        int fixDays = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите тип вложения: \n1.Для ввода комментария введите comment \n2.Указать ссылку на другой дефект введите link");
        Attachment attachment = new Attachment();
        switch (scanner.nextLine()) {
            case "comment":
                System.out.println("Введите комментарий:");
                attachment = new CommentAttachment(scanner.nextLine());
                System.out.println();
                break;
            case "link":
                System.out.println("Введите ссылку на другой дефект:");
                attachment = new DefectAttachment(scanner.nextInt());
                scanner.nextLine();
                System.out.println();
                break;
            default:
                System.out.println("Команда не распознана. Попробуйте снова.");
                break;
        }
        return new Defect (errorSummary, criticality, fixDays, attachment);
    }

    static void addDefect() {
        if (!repository.isFull()) {
            repository.add(createDefect());
        } else {
            System.out.println("Невозможно добавить дефект. Количество дефектов, которые могут храниться: " + LIMIT_DEF);
            System.out.println();
        }
    }

    static void changeStatus() {
        System.out.println("Введите ИД дефекта:");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id < repository.getEnumeratorDef()) {
            System.out.println("Текущий статус : " + repository.getErrorList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
            switch (scanner.nextLine()) {
                case "OPEN":
                    repository.getErrorList()[id].setStatus(Status.OPEN);
                    break;
                case "FIXED":
                    repository.getErrorList()[id].setStatus(Status.FIXED);
                    break;
                case "TESTING":
                    repository.getErrorList()[id].setStatus(Status.TESTING);
                    break;
                case "VERIFIED":
                    repository.getErrorList()[id].setStatus(Status.VERIFIED);
                    break;
                case "CLOSED":
                    repository.getErrorList()[id].setStatus(Status.CLOSED);
                    break;
                default:
                    System.out.println("Команда не распознана. Статус не изменен\n");
                    break;
            }
        } else {
            System.out.println("Дефект не найден");
        }
        System.out.println();
    }
}
