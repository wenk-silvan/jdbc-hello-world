
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author silva
 */
public class VorlesungenOfProfessor {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/uni4?&serverTimezone=Europe/Zurich"
            		,"root", "***");
            ResultSet professoren = connection
                    .createStatement()
                    .executeQuery("SELECT * FROM PROFESSOREN");
            while (professoren.next()) {
                ResultSet vorlesungen = connection
                        .createStatement()
                        .executeQuery("SELECT * FROM VORLESUNGEN");
                List list = new ArrayList<String>();
                while (vorlesungen.next()) {
                    String vorl = vorlesungen.getString(4);
                    String prof = professoren.getString(1); 
                    if (null == vorl ? prof == null : vorl.equals(prof)) {
                        list.add(vorlesungen.getString(2));
                    }
                }
                System.out.println(professoren.getString(2));
                list.forEach(l -> System.out.println(" - " + l));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
