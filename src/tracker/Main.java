package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private final static int REPOSITORY_SIZE = 10;
    private static final Repository repository = new Repository(REPOSITORY_SIZE);



    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepRunning = true;
            while (keepRunning) {
                switch (getCommand(scanner)) {
                    case ADD:
                        addDefect(scanner);
                        break;
                    case LIST:
                        showDefectList();
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

    static void showDefectList() {
        System.out.println();
        System.out.println("Список дефектов:");
        if (repository.isEmpty()) {
            System.out.println("В систему еще не добавлено ни одного дефекта");
        } else {
            for (Defect defect : repository.getDefectsList()) {
                System.out.println(defect.toString());
            }
        }
    }

    static Command getCommand(Scanner scanner) {
        System.out.println("Главное меню:" +
                "\n1.Добавить новый дефект (Введите \"ADD\")," +
                "\n2.Вывести список дефектов (Введите \"LIST\")," +
                "\n3.Изменить статус дефекта (Введите \"CHANGE\")," +
                "\n4.Выйти из программы (Введите \"QUIT\")\n");
        while (true) {
            try {
                System.out.println("Введите команду:");
                return Command.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }
    }

    static Defect createDefect(Scanner scanner) {
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        Сriticality criticality;

        while (true) {
            try {
                System.out.println("Введите критичность дефекта: HIGHEST, HIGH, MEDIUM, LOW");
                criticality = Сriticality.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }
        int daysToFix;
        while (true) {
            try {
                System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                daysToFix = Integer.parseInt(scanner.nextLine());
                if(daysToFix<1) throw new NegativeNumberException("Количество дней не может быть меньше 1");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Команда не распознана.");
            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());
            }
        }
        return new Defect(resume, criticality, daysToFix, createAttachment(scanner));
    }

    static Attachment createAttachment(Scanner scanner) {
        AttachmentType attachmentType;
        while (true) {
            try {
                System.out.println("Выберите тип вложения: " +
                        "\n1.Комментарий (Введите \"NOTE\")," +
                        "\n2.Ссылка на другой дефект (Введите \"LINK\")");
                attachmentType = AttachmentType.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }
        if (attachmentType == AttachmentType.NOTE) {
            System.out.println("Введите комментарий:");
            return new CommentAttachment(scanner.nextLine());
        } else {
            while (true) {
                try {
                    System.out.println("Введите ссылку на другой дефект:");
                    return new DefectAttachment(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Команда не распознана. Введите команду:");
                }
            }
        }
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
        int id;
        while (true) {
            try {
                System.out.println("Введите ИД дефекта:");
                id = Integer.parseInt(scanner.nextLine());
                if(id<0) throw new NegativeNumberException("ИД дефекта не может быть меньше 0");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Команда не распознана.");
            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());
            }
        }
        if (id < repository.getDefectCount()) {
            while (true) {
                try {
                    System.out.println("Текущий статус: " + repository.getDefectsList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
                    repository.getDefectsList()[id].setStatus(Status.valueOf(scanner.nextLine().toUpperCase()));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Команда не распознана.");
                }

            }
        } else {
            System.out.println("Дефект не найден");
        }
        System.out.println();
    }

    static class NegativeNumberException extends Exception{
        public NegativeNumberException(String message){
            super(message);
        }
    }
}
