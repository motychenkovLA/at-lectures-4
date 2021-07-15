package dz1;

import java.util.Scanner;

public class Dz1 {
    public static void main(String[] args) {
        System.out.println("Введите резюме дефекта.");
        Scanner rez = new Scanner(System.in);
        String rezv = rez.nextLine();
        System.out.println("Введите критичность дефекта. Варианты: Блокирующий, Высокий, Средний, Низкий.");
        Scanner krit = new Scanner(System.in);
        String kritv = krit.nextLine();
        System.out.println("Введите ожидаемое колличество дней на исправление дефекта.");
        Scanner md = new Scanner(System.in);
        int mdv = md.nextInt();
        boolean zatr = mdv>5;
        System.out.println("Резюме: " + rezv + ".\nКритичность: " + kritv + ".\nКолличество дней на исправление: " + mdv + ".\nЗаймет больше рабочей недели: " + zatr + ".");


    }
}
