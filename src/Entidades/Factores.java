package Entidades;

import Config.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Factores {

    Conexion con = new Conexion();
    int id;
    String nombre;

    public Factores(Conexion conexion, String nombre) {
        this.nombre = nombre;
        con = conexion;
    }

    public String toString() {
        return nombre;
    }

    public ArrayList<Factores> getFactores() throws SQLException {
        Statement statement = null;
        ResultSet rs;
        ArrayList<Factores> listafactores = new ArrayList<>();
        statement = con.getConnection().createStatement();
        rs = statement.executeQuery("SELECT * FROM factores");
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            Factores factor = new Factores(con, nombre);
            listafactores.add(factor);
        }
        return listafactores;
    }
}
