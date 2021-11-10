package tracker.ormlite;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/vsmg";
        String USER = "postgres";
        String PASSWORD = "postgres";
        ConnectionSource source = null;
        BaseDaoImpl<Insurance, Integer> insurance;
        Insurance newInsurance = new Insurance();
        newInsurance.setName("Защита от потери источника дохода");
        newInsurance.setNumber("QWERTY_6311878_10");
        newInsurance.setPublicId(12);
        newInsurance.setId(1);

        try {
            source = new JdbcConnectionSource(URL, USER, PASSWORD);
            try {
                TableUtils.createTable(source, Insurance.class);
                try {
                    insurance = DaoManager.createDao(source, Insurance.class);
                    insurance.create(newInsurance);
                    newInsurance.setPublicId(1);
                    insurance.update(newInsurance);
                    insurance.delete(newInsurance);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                TableUtils.dropTable(source, Insurance.class, false);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                source.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }


    }
}
