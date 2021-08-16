package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private final static int REPOSITORY_SIZE = 10;
    private static Repository repository = new Repository(REPOSITORY_SIZE);

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
        System.out.println("Главное меню:\n1.Добавить новый дефект (Введите \"add\"),\n2.Вывести список дефектов (Введите \"list\"),\n3.Изменить статус дефекта (Введите \"change\"),\n4.Выйти из программы (Введите \"quit\")\n");
        System.out.println("Введите команду:");
        return scanner.nextLine();
    }

    static Defect createDefect() {
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Введите критичность дефекта: highest, high, medium, low");
        Сriticality criticality;
        switch (scanner.nextLine()) {
            case "highest":
                criticality = Сriticality.HIGHEST;
                break;
            case "high":
                criticality = Сriticality.HIGH;
                break;
            case "medium":
                criticality = Сriticality.MEDIUM;
                break;
            case "low":
                criticality = Сriticality.LOW;
                break;
            default:
                criticality = Сriticality.DEFAULT;
                System.out.println("Команда не распознана. Критичность не указана\n");
                break;
        }
        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        int daysToFix = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Выберите тип вложения: \n1.Комментарий (Введите \"note\"),\n2.Ссылка на другой дефект (Введите \"link\")");
        Attachment attachment = new Attachment();
        switch (scanner.nextLine()) {
            case "note":
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
                System.out.println("Команда не распознана.Комментарий или ссылка на другой дефект не добавлены\n");
                break;
        }
        return new Defect(resume, criticality, daysToFix, attachment);
    }

    static void addDefect() {
        if (!repository.isFull()) {
            repository.add(createDefect());
        } else {
            System.out.println("Превышено количество дефектов. Количество дефектов, которые могут храниться в репозитории: " + REPOSITORY_SIZE);
            System.out.println();
        }
    }

    static void changeStatus() {
        System.out.println("Введите ИД дефекта:");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id < repository.getDefectCount()) {
            System.out.println("Текущий статус : " + repository.getDefectsList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
            switch (scanner.nextLine()) {
                case "OPEN":
                    repository.getDefectsList()[id].setStatus(Status.OPEN);
                    break;
                case "ASSIGNED":
                    repository.getDefectsList()[id].setStatus(Status.ASSIGNED);
                    break;
                case "FIXED":
                    repository.getDefectsList()[id].setStatus(Status.FIXED);
                    break;
                case "VERIFIED":
                    repository.getDefectsList()[id].setStatus(Status.VERIFIED);
                    break;
                case "CLOSED":
                    repository.getDefectsList()[id].setStatus(Status.CLOSED);
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
