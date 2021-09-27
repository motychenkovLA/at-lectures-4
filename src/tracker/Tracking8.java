package tracker;
import java.util.Scanner;


public class Tracking8 {
    public static void main(String[] args) {
        boolean flag = true;
        Repository repository = new Repository(10);
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите команду(add|list|quit|change): ");
                String com;
                com = scanner.nextLine().toLowerCase().trim();
                switch (com) {
                    case "add":
                        repository.add();
                        break;
                    case "list":
                        repository.list();
                        break;
                    case "quit":
                        flag = false;
                        break;
                    case "change":
                        repository.change();
                        break;
                    default:
                        System.out.println("Не верная команда!");
                        break;

                }

            } while (flag);
        }
    }
