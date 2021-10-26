package tracker;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final static int LIMIT_DEF = 10;
    private final static Repository repository = new Repository(LIMIT_DEF);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepRunning = true;
            while (keepRunning) {
                switch (getCommand(scanner)) {
                    case ADD:
                        addDefect(scanner);
                        break;
                    case LIST:
                        listDefect();
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
                    default:
                        System.out.println("Команда не распознана\n");
                        break;
                }
            }
        }
    }

    static void listDefect() {
        System.out.println();
        System.out.println("Список дефектов:");
        if (repository.isEmpty()) {
            System.out.println("В системе отсутствуют дефекты");
        } else {
            for (Defect defect : repository.getErrorList()) {
                System.out.println(defect.toString());
            }
        }
    }

    static void showStats() {
        if (!repository.isEmpty()) {
            IntSummaryStatistics intSummaryStatistics = repository.getErrorList().stream().mapToInt(Defect::getFixDays).summaryStatistics();
            System.out.println("Количество дней на исправление дефекта:");
            System.out.println("* Максимальное - " + intSummaryStatistics.getMax());
            System.out.println("* Среднее - " + intSummaryStatistics.getAverage());
            System.out.println("* Минимальное - " + intSummaryStatistics.getMin());
            System.out.println();
            Map<Status, List<Defect>> result = repository.getErrorList().stream().collect(Collectors.groupingBy(Defect::getStatus));
            for (Status status : Status.values()) {
                if (result.containsKey(status)) {
                    System.out.println("Статус: " + status);
                    System.out.println("Количество дефектов: " + result.get(status).size());
                } else {
                    System.out.println("Статус: " + status);
                    System.out.println("Количество дефектов: " + 0);
                }
            }
        } else System.out.println("В систему еще не добавлено ни одного дефекта");
        System.out.println();
    }

    static Menu getCommand(Scanner scanner) {
        System.out.println("Меню: \n - Для создания дефекта введите ADD. \n - Для отображения списка дефектов введите LIST. \n - Для изменения статуса дефекта введите CHANGE. \n - Вывести статистику по заведенным дефектам введите STATS \n - выйти из программы введите QUIT.");
        while (true) {
            try {
                System.out.println("Введите команду:");
                return Menu.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознанаю");
            }
        }
    }

    static Defect createDefect(Scanner scanner) {
        System.out.println();
        System.out.println("Введите резюме дефекта:");
        String errorSummary = scanner.nextLine();
        Criticality criticality;

        while (true) {
            try {
                System.out.println("Введите критичность дефекта: blocker, critical, major, minor, trivial");
                criticality = Criticality.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }

        int fixDays;
        while (true) {
            try {
                System.out.println("Ввести кол-во дней на исправление дефекта:");
                fixDays = Integer.parseInt(scanner.nextLine());
                if (fixDays < 1) {
                    System.out.println("Количество дней не может быть меньше 1");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Команда не распознана.");
            }
        }
        return new Defect(errorSummary, criticality, fixDays, createAttachment(scanner));
    }

    static Attachment createAttachment(Scanner scanner) {
        TypeAttachment typeAttachment;
        while (true) {
            try {
                System.out.println("Введите тип вложения: \n1.Для ввода комментария введите comment \n2.Указать ссылку на другой дефект введите link");
                typeAttachment = TypeAttachment.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Команда не распознана.");
            }
        }
        if (typeAttachment == TypeAttachment.COMMENT) {
            System.out.println("Введите комментарий:");
            return new CommentAttachment(scanner.nextLine());
        } else {
            while (true) {
                try {
                    System.out.println("Введите ссылку на другой дефект:");
                    return new DefectAttachment(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Команда не распознана.");
                }
            }
        }
    }


    static void addDefect(Scanner scanner) {
        if (!repository.isFull()) {
            repository.add(createDefect(scanner));
        } else {
            System.out.println("Невозможно добавить дефект. Количество дефектов, которые могут храниться: " + LIMIT_DEF);
            System.out.println();
        }
    }

    static void changeStatus(Scanner scanner) {
        int id;
        while (true) {
            try {
                System.out.println("Введите ID дефекта:");
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
        if (id < repository.getErrorList().size()) {
            while (true) {
                try {
                    Status oldStatus = repository.getErrorList().get(id).getStatus();
                    System.out.println("Текущий статус: " + oldStatus + "\nВведите новый статус: " + Arrays.toString(Status.values()));
                    Status newStatus = Status.valueOf(scanner.nextLine().toUpperCase());
                    if (Transition.isValidTransitions(new Transition(oldStatus, newStatus))) {
                        repository.getErrorList().get(id).setStatus(newStatus);
                        break;
                    } else {
                        System.out.println("Изменение статуса на " + newStatus + " недопустимо");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Команда не распознана.");
                }
            }
        } else {
            System.out.println("Дефект не найден.");
        }
        System.out.println();
    }
}






