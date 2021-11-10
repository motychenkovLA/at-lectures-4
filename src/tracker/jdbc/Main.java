package tracker.jdbc;

public class Main {
    public static void main(String[] args) {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS insurances" +
                "(   publicId integer," +
                "    name character varying(255)," +
                "    number character varying(255))";
        String sqlDropTable = "DROP TABLE public.insurances";
        String sqlInsertIntoTable = "INSERT INTO insurances (publicId, name, number) VALUES (1, 'Защита от потери источника дохода', 'QWERTY_6311878_10')";
        String sqlUpdateTable = "UPDATE insurances SET publicId = 25 WHERE number = 'QWERTY_6311878_10'";
        String sqlDeleteFromTable = "DELETE FROM insurances WHERE number = 'QWERTY_6311878_10'";

        JDBCExample.executeQuery(sqlCreateTable);
        System.out.println("В бд добавлена таблица.");
        JDBCExample.executeQuery(sqlInsertIntoTable);
        System.out.println("В таблицу добавлена запись.");
        int numberOfUpdatedRecords = JDBCExample.updateTable(sqlUpdateTable);
        System.out.println("Таблица обновлена. Количество обновленных записей: " + numberOfUpdatedRecords);
        JDBCExample.executeQuery(sqlDeleteFromTable);
        System.out.println("Из таблицы удалена запись");
        JDBCExample.executeQuery(sqlDropTable);
        System.out.println("Таблица удалена.");

    }
}
