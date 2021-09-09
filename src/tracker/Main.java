package tracker;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static String command;
    private final static int LIM = 10;
    private static final Repository repository = new Repository(LIM);

    public static void main(String[] args) {
        boolean exitPoint;
        exitPoint = true;

        while (exitPoint) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). " +
                    "\n 2.Вывести список дефектов (Введите list). " +
                    "\n 3.Изменить статус дефекта (Введите change). " +
                    "\n 4.Выйти из программы (Введите quit).\n");
            command = sc.nextLine();
            switch (command) {

                case "add":
                    if (Repository.getDefectCounter() == repository.getDefectsList().length) {
                        System.out.println("Не возможно добавить больше " + repository.getDefectsList().length + " дефектов.\n");
                    } else {
                        repository.add(create());
                    }
                    break;

                case "change":
                    chengStatus();
                    break;

                case "list":
                    System.out.println(repository.getAll());
                    break;

                case "quit":
                    System.out.println("Выход из программы.");
                    exitPoint = false;
                    break;

                default:
                    System.out.println("\nКоманда не распознана. Попробуйте снова.\n");
                    break;
            }
        }
    }

    static Defect create() {
        System.out.println("\nВведите резюме дефекта.");
        String summary = sc.nextLine();
        System.out.println("\nВведите серьезность дефекта. " +
                "\nВарианты: blocker, critical, major, manor, trivial.");
        command = sc.nextLine();
        Criticality criticality;
        switch (command) {
            case "blocker":
                criticality = Criticality.BLOCKER;
                break;
            case "critical":
                criticality = Criticality.CRITICAL;
                break;
            case "major":
                criticality = Criticality.MAJOR;
                break;
            case "manor":
                criticality = Criticality.MINOR;
                break;
            case "trivial":
                criticality = Criticality.TRIVIAL;
                break;
            default:
                criticality = Criticality.DEFAULT;
                break;
        }
        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
        int daysToFix = sc.nextInt();
        sc.nextLine();
        System.out.println("\nДобавить вложение? \n1. Добавить ссылку на другой дефект (введите link). " +
                "\n2. Добавить комментарий (введите comment)." +
                "\n3. Не добавлять вложение (введите NO!).");
        Attachment attachment;
        command = sc.nextLine();
        switch (command) {
            case "link":
                System.out.println("\nУкажите id дефекта на который необходима ссылка:\n");
                int link = sc.nextInt();
                sc.nextLine();
                while (link > Repository.defectCounter) {
                    System.out.println("\nДефект под таким номером не существует.\n");
                    link = sc.nextInt();
                    sc.nextLine();
                }
                attachment = new DefectAttachment(link);
                System.out.println();
                break;
            case "comment":
                System.out.println("\nВведите комментарий:\n");
                String comment = sc.nextLine();
                attachment = new CommentAttachment("\nКомментарий: " + comment);
                System.out.println();
                break;
            case "no":
            case "NO":
            case "NO!":
                attachment = new CommentAttachment("\nCсылка или комментарий отсутствуют");
                break;
            default:
                attachment = new CommentAttachment("\nCсылка или комментарий отсутствуют");
                System.out.println("\nКоманда не распознана. Попробуйте снова.\n");
                break;
        }
        System.out.println("Дефект сохранен.\n");
        return new Defect(summary, criticality, daysToFix, attachment);
    }

        static void chengStatus(){
            System.out.println("Введите номер дефекта статус которого необходимо изменить:");
            int id = sc.nextInt();
            sc.nextLine();
            if (id <= Repository.getDefectCounter()) {
                System.out.println("Дефект находится в статусе: " + repository.getDefectsList()[id].getStatus() +
                        "\nВведите новый статус дефекта." +
                        "\nВарианты: open, assigned, fixed, rejected, retesting, verified, reopened, closed");
                command = sc.nextLine();
                System.out.println("Статус изменен с " + repository.getDefectsList()[id].getStatus());
                switch (command) {
                    case "open":
                        repository.getDefectsList()[id].setStatus(Status.OPEN);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "assigned":
                        repository.getDefectsList()[id].setStatus(Status.ASSIGNED);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "fixed":
                        repository.getDefectsList()[id].setStatus(Status.FIXED);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "rejected":
                        repository.getDefectsList()[id].setStatus(Status.REJECTED);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "retesting":
                        repository.getDefectsList()[id].setStatus(Status.RETESTING);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "verified":
                        repository.getDefectsList()[id].setStatus(Status.VERIFIED);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "reopened":
                        repository.getDefectsList()[id].setStatus(Status.REOPENED);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    case "closed":
                        repository.getDefectsList()[id].setStatus(Status.CLOSED);
                        System.out.println("на " + repository.getDefectsList()[id].getStatus() + ".\n");
                        break;
                    default:
                        System.out.println("\nКоманда не распознана. Статус дефекта не будет изменен.\n");
                        break;
                }
            } else {
                System.out.println("\nДефекта под таким номером не существует\n");
            }
        }
    }


