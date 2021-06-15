import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class HelloJDBC {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/uni4?&serverTimezone=Europe/Zurich"
            		,"root", "***");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(
                    "SELECT * FROM PROFESSOREN");
            while (resultset.next()) {
                System.out.println("******* "+resultset.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
