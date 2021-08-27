package tracker;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int REPO_SIZE = 10;
    private static Repository repository = new Repository(REPO_SIZE);

    public static void main(String[] args) {
        boolean continueProgram;
        continueProgram = true;

        while (continueProgram) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Изменить статус дефекта (Введите change) \n 4.Выйти из программы (Введите quit).\n");
            String transition;
            transition = sc.nextLine();
            switch (transition) {
                case "add":
                    System.out.println("\nВведите резюме дефекта.");
                    String summary = sc.nextLine();
                    System.out.println("Введите критичность дефекта: highest, high, medium, low");
                    Priority priority;
                    switch (sc.nextLine()) {
                        case "highest":
                            priority = Priority.HIGHEST;
                            break;
                        case "high":
                            priority = Priority.HIGH;
                            break;
                        case "medium":
                            priority = Priority.MEDIUM;
                            break;
                        case "low":
                            priority = Priority.LOW;
                            break;
                        default:
                            priority = Priority.DEFAULT;
                            System.out.println("Команда не распознана. Критичность не указана\n");
                            break;
                    }
                    System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
                    int leadTime = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Дефект сохранен.\n");
                    System.out.println("Выберите тип вложения: \n1.Комментарий (Введите \"comment\"),\n2.Ссылка на другой дефект (Введите \"link\")");
                    Attachment attachment = new Attachment();
                    Scanner scanner = new Scanner(System.in);
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
                            System.out.println("Не понятно. Попробуй снова.\n");
                            break;
                    }
                    if (!repository.isFull()) {
                        repository.add(new Defect(summary, priority, leadTime, attachment));
                    } else {
                        System.out.println("Превышено количество дефектов. Количество дефектов, которые могут храниться в репозитории: " + REPO_SIZE);
                        System.out.println();
                    }
                    ;
                    break;
                case "list":
                    System.out.println(repository.getAll());
                    break;
                case "change":
                    System.out.println("Введите ИД дефекта:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (id < repository.getDefectCount()) {
                        System.out.println("Текущий статус : " + repository.getDefectsList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
                        switch (sc.nextLine()) {
                            case "OPEN":
                                repository.getDefectsList()[id].setStatus(Status.OPEN);
                                System.out.println("Статус дефекта успешно изменен");
                                break;
                            case "ASSIGNED":
                                repository.getDefectsList()[id].setStatus(Status.ASSIGNED);
                                System.out.println("Статус дефекта успешно изменен");
                                break;
                            case "FIXED":
                                repository.getDefectsList()[id].setStatus(Status.FIXED);
                                System.out.println("Статус дефекта успешно изменен");
                                break;
                            case "VERIFIED":
                                repository.getDefectsList()[id].setStatus(Status.VERIFIED);
                                System.out.println("Статус дефекта успешно изменен");
                                break;
                            case "CLOSED":
                                repository.getDefectsList()[id].setStatus(Status.CLOSED);
                                System.out.println("Статус дефекта успешно изменен");
                                break;
                            default:
                                System.out.println("Команда не распознана. Статус не изменен\n");
                                break;
                        }
                    } else {
                        System.out.println("Дефект не найден");
                    }
                    System.out.println();

                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    continueProgram = false;
                    break;

                default:
                    System.out.println("\n Не понятно. Попробуй снова.\n");
                    break;
            }
        }


    }

}