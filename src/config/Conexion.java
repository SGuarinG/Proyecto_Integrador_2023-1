package Config;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Conexion {

    Connection con = null;

    public Connection getConnection() {

        return con;
    }

    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver");
            e.printStackTrace();
            return;
        }

        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/acreditacionpi", "root", "");

        } catch (SQLException e) {
            System.out.println("Error al establecer la conexion con la base de datos");
            e.printStackTrace();
        }
    }

    public void desconectar() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion");
                e.printStackTrace();
            }
        }
    }
}