package tracker;

import tracker.enums.Critical;
import tracker.enums.Status;

import java.util.*;


public class Tracking9 {

    private static Set<Transition> availableTransition = new HashSet<Transition>();
    private static Map<Long, Defect> defects = new HashMap<>();
    private static Long index = 0L;

    public static void main(String[] args) {
        availableTransition.add(new Transition(Status.OPEN, Status.IN_DEVELOP));
        availableTransition.add(new Transition(Status.IN_DEVELOP, Status.IN_RETEST));
        availableTransition.add(new Transition(Status.IN_RETEST, Status.IN_DEVELOP));
        availableTransition.add(new Transition(Status.IN_RETEST, Status.CLOSE));

        boolean flag = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите команду(add|list|quit|change|stats): ");
            String com;
            com = scanner.nextLine().toLowerCase().trim();
            switch (com) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
                    break;
                case "quit":
                    flag = false;
                    break;
                case "change":
                    change();
                    break;
                case "stats":
                    stats();
                    break;
                default:
                    System.out.println("Не верная команда!");
                    break;

            }

        } while (flag);
    }

    private static void add() {
        System.out.println("\n\rВведите резюме дефекта:");
        Scanner scanner = new Scanner(System.in);
        String defectSummary = scanner.nextLine();
        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий): ");
        String criticalityDefect = scanner.nextLine().trim().toLowerCase();
        Critical critical;
        switch (criticalityDefect) {
            case "низкий":
                critical = Critical.LOW;
                break;
            case "средний":
                critical = Critical.MIDDLE;
                break;
            case "высокий":
                critical = Critical.HIGH;
                break;
            case "блокирующий":
                critical = Critical.BLOCK;
                break;
            default:
                System.out.println("Ошибка ввода, присвоен статус по умолчанию Средний");
                critical = Critical.MIDDLE;
                break;
        }
        try {
            System.out.println("Введите ожидаемый срок исполнения: ");
            int workMoreWeek = scanner.nextInt();
            System.out.println("Выберети тип вложения (К)коментарий/(Д)дефект: ");
            scanner.nextLine();
            String attachmentType = scanner.nextLine();
            attachmentType = attachmentType.trim().toLowerCase();
            Attachment attachment = new Attachment();
            boolean enterError = false;
            switch (attachmentType) {
                case "к":
                case "коментарий":
                    System.out.println("Введите комментарий: ");
                    String comment = scanner.nextLine();
                    attachment = new CommentAttachment(comment);
                    break;
                case "д":
                case "дефект":
                    System.out.println("Введите номер дефекта: ");
                    int defectId = scanner.nextInt();
                    attachment = new DefectAttachment(defectId);
                    break;
                default:
                    enterError = true;
                    break;
            }
            if (enterError) {
                System.out.println("Нужно ввести К или Д");
            } else {
                defects.put(index, new Defect(defectSummary, critical, workMoreWeek, attachment));
                index++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное значение: " + e);
            System.out.println("Попробуйте еще раз");
        }
    }

    private static void list() {
        for (Long i = 0L; i < index; i++) {
            System.out.println(defects.get(i).toString());
        }
    }

    private static void change() {
        if (index == 0) {
            System.out.println("Дефектов нет");
        } else {
            System.out.println("Введите номер дефекта [0-" + (index - 1) + "]: ");
            try {
                Scanner scanner = new Scanner(System.in);
                Long defectId = scanner.nextLong();
                if (defectId < index) {
                    System.out.println("Введите статус дефекта (Открыто, Разработка, Тестирование, Готово): ");
                    scanner.nextLine();
                    String criticalityDefect = scanner.nextLine().trim().toLowerCase();
                    Status status;
                    switch (criticalityDefect) {
                        case "открыто":
                            status = Status.OPEN;
                            break;
                        case "разработка":
                            status = Status.IN_DEVELOP;
                            break;
                        case "тестирование":
                            status = Status.IN_RETEST;
                            break;
                        case "готово":
                            status = Status.CLOSE;
                            break;
                        default:
                            System.out.println("Ошибка ввода, присвоен статус по умолчанию Открыто");
                            status = Status.OPEN;
                            break;
                    }

                    boolean transitionDone=false;
                    for(Transition transition : availableTransition){
                        if((transition.getTo() == status) && !transitionDone)
                            transitionDone = transition.doTransition(defects.get(defectId));
                    }
                    if(transitionDone)
                        System.out.println("Смена статуса успешна");
                    else
                        System.out.println("Ошибка смены статуса");
                    //System.out.println(transitionDone?"Смена статуса успешна":"Ошибка смены статуса");
                } else {
                    System.out.println("Вы ввели не валидный номер дефекта");
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверное значение: " + e);
                System.out.println("Попробуйте еще раз");
            }

        }
    }

    private static void stats(){
        int max;
        int min;
        int medium;
        long inOpen;
        long inDevelop;
        long inRetest;
        long inClose;

        max = defects
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .max(Defect::compare)
                .get().getWorkMoreWeek();
        min = defects
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .min(Defect::compare)
                .get().getWorkMoreWeek();
        medium = (max + min)/2;

        inOpen = defects
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .filter(defect -> defect.getStatusDefect() == Status.OPEN)
                .count();

        inDevelop = defects
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .filter(defect -> defect.getStatusDefect() == Status.IN_DEVELOP)
                .count();

        inRetest = defects
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .filter(defect -> defect.getStatusDefect() == Status.IN_RETEST)
                .count();

        inClose = defects
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .filter(defect -> defect.getStatusDefect() == Status.CLOSE)
                .count();

        System.out.println("Минимальное количество дней: " + min);
        System.out.println("Максимальное количество дней: " + max);
        System.out.println("Среднее количество дней: " + medium);

        System.out.println("Статус дефекта Открыто: " + inOpen);
        System.out.println("Статус дефекта Разработка: " + inDevelop);
        System.out.println("Статус дефекта Ретест: " + inRetest);
        System.out.println("Статус дефекта Закрыто: " + inClose);
    }
}

