package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите резюме дефекта"); //1
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);

        System.out.println("Выберите критичность дефекта:"); //2
        String block = "Blocker";
        String critical = "Critical";
        String major = "Major";
        String minor = "Minor";
        String trivial = "Trivial";
        System.out.printf(" 1. %s \n 2. %s \n 3. %s \n 4. %s \n 5. %s \n ", block, critical, major, minor, trivial);
        String str1 = scanner.nextLine();
        System.out.println("Критичность дефекта: " + str1 + "\n");

        System.out.println("Введите ожидаемое количество дней на исправление дефекта"); //3
        int str2 = scanner.nextInt();
        System.out.println("Разраб будет пилить это: " + str2 + " дней \n");
        boolean str3 = str2 >= 7;
        System.out.printf("Резюме дефекта: %s | Серьезность: %s | Количество дней на исправление: %d | Займет больше рабочей недели: %s \n", str, str1, str2, str3);
    }
}
