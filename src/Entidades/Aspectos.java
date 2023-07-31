package Entidades;

import Config.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Aspectos {

    Conexion con = new Conexion();
    int id;
    String nombre;

    public Aspectos(Conexion conexion, int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        con = conexion;
    }

    public String toString() {
        return nombre;
    }

    //Conseguir la lista
    public ArrayList<Aspectos> getAspectos(int id) throws SQLException {
        Statement statement = null;
        ResultSet rs;
        ArrayList<Aspectos> listaaspectos = new ArrayList<>();
        statement = con.getConnection().createStatement();
        String sql = "SELECT LEFT(descripcion, 11) AS descripcion FROM aspectos WHERE id_caracteristicas=?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("descripcion");
            Aspectos aspecto = new Aspectos(con, id, nombre);
            listaaspectos.add(aspecto);
        }
        return listaaspectos;
    }
    
    //Descripcion
    public String getDescripcion(int idaspec) throws SQLException {
        Statement statement = null;
        ResultSet rs;
        StringBuilder descripcionBuilder = new StringBuilder();
        statement = con.getConnection().createStatement();
        String sql = "SELECT SUBSTRING(descripcion, 12) AS descripcion FROM aspectos WHERE id=?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, idaspec);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String descripcion = rs.getString("descripcion");
            descripcionBuilder.append(descripcion);
        }
        return descripcionBuilder.toString();
    }
    
    //Conseguir la id de los aspectos
    public int getId() throws SQLException{
        int idaspecto=0;
        Statement statement = null;
        ResultSet rs;
        statement = con.getConnection().createStatement();
        String sql = "SELECT id FROM aspectos WHERE id_caracteristicas=?";
        
        
        return idaspecto;
    }
}
