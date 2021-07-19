package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String komanda = "";
        int schetchicDefectov = 0;
        int schetchicVyvoda = 0;
        int[] defectsNomer = new int[10];
        String[] defectsRezyme = new String[10];
        String[] defectsKritichnost = new String[10];
        int[] defectsDaysToFix = new int[10];
        while (!komanda.equals("quit")) {
            System.out.println("Меню: \n 1.Добавить новый дефект (Введите add). \n 2.Вывести список дефектов (Введите list). \n 3.Выйти из программы (Введите quit).\n");
            Scanner sc = new Scanner(System.in);
            komanda = sc.nextLine();
            switch (komanda) {
                case "add":
                    if (schetchicDefectov == 10) {
                        System.out.println("Не возможно добавить больше 10 дефектов.\n");
                    } else {
                        defectsNomer[schetchicDefectov] = schetchicDefectov;  //Номер
                        System.out.println("\nВведите резюме дефекта.");
                        defectsRezyme[schetchicDefectov] = sc.nextLine();
                        System.out.println("\nВведите критичность дефекта. Варианты: Блокирующий, Высокий, Средний, Низкий.");
                        defectsKritichnost[schetchicDefectov] = sc.nextLine();
                        System.out.println("\nВведите ожидаемое колличество дней на исправление дефекта.");
                        defectsDaysToFix[schetchicDefectov] = sc.nextInt();
                        sc.nextLine();
                        schetchicDefectov++;
                        System.out.println("Дефект сохранен.\n");
                    }
                    break;
                case "list":
                    System.out.println("Заведенные дефекты:");
                    if (schetchicDefectov==0) {
                        System.out.println("Дефекты отсутствуют.\n");
                    } else {
                    while (schetchicVyvoda < schetchicDefectov) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Номер: " + defectsNomer[schetchicVyvoda] + ".\nРезюме: " + defectsRezyme[schetchicVyvoda] + ".\nКритичность: " + defectsKritichnost[schetchicVyvoda] + ".\nКолличество дней на исправление: " + defectsDaysToFix[schetchicVyvoda]);
                        schetchicVyvoda++;
                    }
                    System.out.println("-----------------------------------------------------\n");
                    System.out.println();
                    schetchicVyvoda = 0;}
                    break;

                case "quit":
                    System.out.println("Выход из программы.");
                    break;

                default:
                    System.out.println("\nКоманда не распознана. Попробуйте снова.\n");
                    break;
            }
        }
    }
}

