import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import org.postgresql.util.PSQLException;

public class ExceptionExample {
	
	/*
	 * 
	 * 
	 * CREATE MYSQL STORED PROC FIRST
	 * 
DELIMITER $$
CREATE PROCEDURE testException ()
BEGIN
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An Error occurred', 
	MYSQL_ERRNO = 1001;
END $$
DELIMITER ;
	 * 
	 * 
	 */

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/uni4?&serverTimezone=Europe/Zurich"
            		,"root", "KeepMyDataSafe987");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(
                    "CALL testException()");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
