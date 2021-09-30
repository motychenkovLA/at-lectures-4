package tracker;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final int REPO_SIZE = 10;
    private static final Repository repository = new Repository(REPO_SIZE);

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            boolean continueProgram;
            continueProgram = true;
            while (continueProgram) {
                switch (getCommand(scanner)){
                case ADD:
                    addDefect(scanner);
                    break;
                case LIST:
                    showList();
                    break;
                case CHANGE:
                    changeStatus(scanner);
                    break;
                case QUIT:
                    System.out.println("Выход из программы");
                    continueProgram = false;
                    break;
            }
        }
    }}

        static Command getCommand(Scanner scanner) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Изменить статус дефекта (Введите change) \n 4.Выйти из программы (Введите quit).\n");
            while (true) {
                try {
                    System.out.println("Введите команду:");
                    return Command.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Команда не распознана.");
                }
            }
        }
    static void showList() {
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
            static Defect createDefect(Scanner scanner) {
                System.out.println("\nВведите резюме дефекта.");
                String summary = scanner.nextLine();
                Priority priority;

                while (true) {
                    try {
                        System.out.println("Введите критичность дефекта: highest, high, medium, low");
                        priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Команда не распознана.");
                    }
                }

                int leadTime;
                while (true) {
                    try {
                        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
                        leadTime = Integer.parseInt(scanner.nextLine());
                        if (leadTime < 1) throw new NegativeNumberException("Количество дней не может быть меньше 1");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Команда не распознана.");
                    } catch (NegativeNumberException e) {
                        System.out.println(e.getMessage());
                    }
                }
                return new Defect(summary, priority, leadTime, createAttachment(scanner));
    }

            static Attachment createAttachment(Scanner scanner) {
                    AttachmentType attachmentType;
                    while (true) {
                        try {
                            System.out.println("Дефект сохранен.\n");
                            System.out.println("Выберите тип вложения: \n1.Комментарий (Введите \"comment\"),\n2.Ссылка на другой дефект (Введите \"link\")");
                            attachmentType = AttachmentType.valueOf(scanner.nextLine().toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Команда не распознана.");
                        }
                    }
                    if (attachmentType == AttachmentType.COMMENT) {
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
                System.out.println("Превышено количество дефектов. Количество дефектов, которые могут храниться в репозитории: " + REPO_SIZE);
                System.out.println();
            }

        }
        static void changeStatus(Scanner scanner) {
            int id;

            while (true){
                try {
                    System.out.println("Введите ИД дефекта:");
                    id=Integer.parseInt(scanner.nextLine());
                    if(id<0) throw new NegativeNumberException("ИД дефекта не может быть меньше 0");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Команда не распознана.");
                } catch (NegativeNumberException e){
                    System.out.println(e.getMessage());
                }
            }

            if (id < repository.getDefectCount()) {
                while (true){
                    try{
                        System.out.println("Текущий статус : " + repository.getDefectsList()[id].getStatus() + "\nВведите новый статус: " + Arrays.toString(Status.values()));
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
