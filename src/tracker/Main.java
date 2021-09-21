package tracker;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private final  static int LIMIT_DEF= 10;
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

    static Menu getCommand (Scanner scanner) {
        System.out.println("Меню: \n - Для создания дефекта введите ADD. \n - Для отображения списка дефектов введите LIST. \n - Для изменения статуса дефекта введите CHANGE. \n - выйти из программы введите QUIT.");
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
                if (fixDays < 1) throw new NegativeNumberException("Количество дней не может быть меньше 1");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Команда не распознана.");
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
            return new Defect(errorSummary, criticality, fixDays, createAttachment(scanner));
        }

        static Attachment createAttachment (Scanner scanner){
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


        static void addDefect (Scanner scanner){
            if (!repository.isFull()) {
                repository.add(createDefect(scanner));
            } else {
                System.out.println("Невозможно добавить дефект. Количество дефектов, которые могут храниться: " + LIMIT_DEF);
                System.out.println();
            }
        }

        static void changeStatus(Scanner scanner){
            int id;
            while (true) {
                try {
                    System.out.println("Введите ID дефекта:");
                    id = Integer.parseInt(scanner.nextLine());
                    if (id < 0) throw new NegativeNumberException("ID дефекта не может быть меньше 0");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Команда не распознана.");
                } catch (NegativeNumberException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (id < repository.getEnumeratorDef()) {
                while (true) {
                    try {
                        System.out.println("Текущий статус: " + repository.getErrorList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
                        repository.getErrorList()[id].setStatus(Status.valueOf(scanner.nextLine().toUpperCase()));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Команда не распознана.");
                    }
                }
            } else {
                System.out.println("Дефект не найден.");
            }
            System.out.println();
        }

        static class NegativeNumberException extends Exception {
            public NegativeNumberException(String message) {
                super(message);
            }
        }
    }






