package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")   ;

            String url = "jdbc:mysql://localhost:3306/riwi";
            String user = "root";
            String password = "root1234";

            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Ingreso exitoso a base de datos");

        } catch (ClassNotFoundException error){
            JOptionPane.showMessageDialog(null,"ERROR >> Driver no instalado"+error.getMessage());
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR >> No conecté a base de datos"+e.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection () {
        try {
            if (objConnection != null) {
                objConnection.close();
            }
        } catch (SQLException error){
            System.out.println("Error"+ error.getMessage());
        }
    }
}
