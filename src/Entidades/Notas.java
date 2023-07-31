package Entidades;

import Config.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Notas {
    Conexion con = new Conexion();

    public Notas(Conexion conexion) {
        con = conexion;
    }

    public void guardarnota(int nota, String pre) throws SQLException {
        String sql = "SELECT id FROM preguntas WHERE pregunta = ?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, pre);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            try {
                int idpre = resultSet.getInt("id");
                java.util.Date utilDate = new java.util.Date();
                long milliseconds = utilDate.getTime();
                java.sql.Date sqlDate = new java.sql.Date(milliseconds);
                String insertSql = "INSERT INTO notas ( nota, fecha, id_preguntas) VALUES (?, ?, ?)";
                PreparedStatement insert = (PreparedStatement) con.getConnection().prepareStatement(insertSql);
                insert.setInt(1, nota);
                insert.setDate(2, sqlDate);
                insert.setInt(3, idpre);
                insert.executeUpdate();
            } catch (Exception e) {
            }
        }
    }
}
