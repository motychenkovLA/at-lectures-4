package tracker;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private final static int REPOSITORY_SIZE = 10;
    private static Repository repository = new Repository(REPOSITORY_SIZE);


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepRunning = true;
            while (keepRunning) {
                switch (getCommand(scanner)) {
                    case ADD:
                        addDefect(scanner);
                        break;
                    case LIST:
                        System.out.println();
                        System.out.println("Список дефектов:");
                        System.out.println(repository.getAll());
                        break;
                    case QUIT:
                        System.out.println("Выход из программы");
                        keepRunning = false;
                        break;
                    case CHANGE:
                        changeStatus(scanner);
                        break;
                }
            }
        }
    }

    static Command getCommand(Scanner scanner) {
        System.out.println("Главное меню:\n1.Добавить новый дефект (Введите \"ADD\"),\n2.Вывести список дефектов (Введите \"LIST\"),\n3.Изменить статус дефекта (Введите \"CHANGE\"),\n4.Выйти из программы (Введите \"QUIT\")\n");
        Command command = Command.ADD;
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                System.out.println("Введите команду:");
                command = Command.valueOf(scanner.nextLine().toUpperCase());
                keepRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }
        return command;
    }

    static Defect createDefect(Scanner scanner) {
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        Сriticality criticality = Сriticality.DEFAULT;

        boolean keepRunning = true;
        while (keepRunning) {
            try {
                System.out.println("Введите критичность дефекта: HIGHEST, HIGH, MEDIUM, LOW");
                criticality = Сriticality.valueOf(scanner.nextLine().toUpperCase());
                keepRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }
        int daysToFix = 0;
        keepRunning = true;
        while (keepRunning) {
            try {
                System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                daysToFix = scanner.nextInt();
                keepRunning = false;
            } catch (InputMismatchException e) {
                System.out.println("Команда не распознана.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        AttachmentType attachmentType = AttachmentType.NOTE;
        keepRunning = true;
        while (keepRunning) {
            try {
                System.out.println("Выберите тип вложения: \n1.Комментарий (Введите \"NOTE\"),\n2.Ссылка на другой дефект (Введите \"LINK\")");
                attachmentType = AttachmentType.valueOf(scanner.nextLine().toUpperCase());
                keepRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }

        Attachment attachment = new Attachment();
        switch (attachmentType) {
            case NOTE:
                System.out.println("Введите комментарий:");
                attachment = new CommentAttachment(scanner.nextLine());
                System.out.println();
                break;
            case LINK:
                keepRunning = true;
                while (keepRunning) {
                    try {
                        System.out.println("Введите ссылку на другой дефект:");
                        attachment = new DefectAttachment(scanner.nextInt());
                        keepRunning = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Команда не распознана. Введите команду:");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();
                System.out.println();
                break;
        }

        return new Defect(resume, criticality, daysToFix, attachment);
    }

    static void addDefect(Scanner scanner) {
        if (!repository.isFull()) {
            repository.add(createDefect(scanner));
        } else {
            System.out.println("Превышено количество дефектов. Количество дефектов, которые могут храниться в репозитории: " + REPOSITORY_SIZE);
            System.out.println();
        }
    }

    static void changeStatus(Scanner scanner) {
        int id = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                System.out.println("Введите ИД дефекта:");
                id = scanner.nextInt();
                keepRunning = false;
            } catch (InputMismatchException e) {
                System.out.println("Команда не распознана.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        if (id < repository.getDefectCount()) {

            keepRunning = true;
            while (keepRunning) {
                try {
                    System.out.println("Текущий статус: " + repository.getDefectsList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
                    repository.getDefectsList()[id].setStatus(Status.valueOf(scanner.nextLine().toUpperCase()));
                    keepRunning = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Команда не распознана.");
                }
            }
        } else {
            System.out.println("Дефект не найден");
        }
        System.out.println();
    }

}
