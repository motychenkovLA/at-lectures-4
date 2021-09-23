package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final static int REPOSITORY_SIZE = 5;
    private static final Repository repository = new Repository(REPOSITORY_SIZE);


    public static void main(String[] args) {
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
                    case STATS:
                        showStats();
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
            for (Defect defect : repository.getDefectsList())
                System.out.println(defect.toString());
        }
    }

    static void showStats() {
        if (!repository.isEmpty()) {
            IntSummaryStatistics intSummaryStatistics = repository.getDefectsList().stream().mapToInt(Defect::getDaysToFix).summaryStatistics();
            System.out.println("Количество дней на исправление дефекта:");
            System.out.println("* Максимальное - " + intSummaryStatistics.getMax());
            System.out.println("* Среднее - " + intSummaryStatistics.getAverage());
            System.out.println("* Минимальное - " + intSummaryStatistics.getMin());
            System.out.println();
            Map<Status, List<Defect>> result = repository.getDefectsList().stream().collect(Collectors.groupingBy(Defect::getStatus));
            for (Status status:Status.values()){
                if (result.containsKey(status)) {
                    System.out.println("Статус: " + status);
                    System.out.println("Количество дефектов: " + result.get(status).size());
                }else {
                    System.out.println("Статус: " + status);
                    System.out.println("Количество дефектов: " + 0);
                }
            }
        } else System.out.println("В систему еще не добавлено ни одного дефекта");
        System.out.println();
    }

    static Command getCommand(Scanner scanner) {
        System.out.println("Главное меню:" +
                "\n1.Добавить новый дефект (Введите \"ADD\")," +
                "\n2.Вывести список дефектов (Введите \"LIST\")," +
                "\n3.Изменить статус дефекта (Введите \"CHANGE\")," +
                "\n4.Вывести статистику по заведенным дефектам (Введите \"STATS\")," +
                "\n5.Выйти из программы (Введите \"QUIT\")\n");
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
                if (daysToFix < 1) {
                    System.out.println("Количество дней не может быть меньше 1");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Команда не распознана.");
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
                if (id < 0) {
                    System.out.println("ИД дефекта не может быть меньше 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Команда не распознана.");
            }
        }
        if (id < repository.getDefectsList().size()) {
            while (true) {
                try {
                    Status oldStatus = repository.getDefectsList().get(id).getStatus();
                    System.out.println("Текущий статус: " + oldStatus + "\nВведите новый статус: " + Arrays.toString(Status.values()));
                    Status newStatus = Status.valueOf(scanner.nextLine().toUpperCase());
                    if (Transition.isValidTransitions(new Transition(oldStatus, newStatus))) {
                        repository.getDefectsList().get(id).setStatus(newStatus);
                        break;
                    } else {
                        System.out.println("Изменение статуса на " + newStatus + " недопустимо");
                    }
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
