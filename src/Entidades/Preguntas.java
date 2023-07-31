package Entidades;

import Config.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Preguntas {   
    Conexion con = new Conexion();
    int id;
    String nombre;

    public Preguntas(Conexion conexion,String nombre) {
        this.nombre=nombre;
        con = conexion;
    }

    public String toString() {
        return nombre;
    }

    //Conseguir la lista
    public ArrayList<Preguntas> getPreguntas(int id) throws SQLException {
    Statement statement = null;
    ResultSet rs;
    ArrayList<Preguntas> listapreguntas = new ArrayList<>();
    statement = con.getConnection().createStatement();
    String sql = "SELECT * FROM preguntas WHERE id_encuesta=?";
    PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
    preparedStatement.setInt(1, id);
    rs = preparedStatement.executeQuery();
    while (rs.next()) {
        String nombre = rs.getString("pregunta");
        Preguntas pregunta = new Preguntas(con,nombre);
        listapreguntas.add(pregunta);
    }
    return listapreguntas;
    }  
    
    //Obtener las ids de las preguntas
    
    
}
