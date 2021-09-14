package tracker;
import java.util.Scanner;

public class Tracking8 extends MethodAdd {
    public static void main(String[] args) {
        boolean flag = true;
        Repository repository = new Repository(repoLength);
        try (ClassScan classScan = new ClassScan()) {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите команду(add|list|quit|change): ");
                String com;
                com = scanner.nextLine().toLowerCase().trim();
                switch (com) {
                    case "add":
                        add(repository, scanner);
                        break;
                    case "list":
                        list(repository);
                        break;
                    case "quit":
                        flag = false;
                        break;
                    case "change":
                        change(repository, scanner);
                        break;
                    default:
                        System.out.println("Не верная команда!");
                        break;

                }

            } while (flag);
        }catch (Exception e){
            System.out.println("Вы ввели не верную команду!" + e);
        }
    }
}
