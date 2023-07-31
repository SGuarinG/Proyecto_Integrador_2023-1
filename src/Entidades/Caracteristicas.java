package Entidades;

import Config.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Caracteristicas {
    Conexion con = new Conexion();
    int id;
    String nombre;

    public Caracteristicas(Conexion conexion, String nombre) {
        this.nombre = nombre;
        con = conexion;
    }

    public String toString() {
        return nombre;
    }

    //Lista de caracteristicas
    public ArrayList<Caracteristicas> getCaracteristicas(int id) throws SQLException {
        ArrayList<Caracteristicas> listacarac = new ArrayList<>();
        String sql = "SELECT nombre FROM caracteristicas WHERE id_factor = ?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            Caracteristicas carac = new Caracteristicas(con, nombre);
            listacarac.add(carac);
        }
        return listacarac;
    }
    
    //Conseguir id por el nombre
    public int getIDCaracteristicaNombre(String nombre) throws SQLException{
        int idcaracteristica=0;
        String sql = "SELECT id FROM caracteristicas WHERE nombre = ?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            idcaracteristica = resultSet.getInt("id");
        }   
        return idcaracteristica;
    }
}
