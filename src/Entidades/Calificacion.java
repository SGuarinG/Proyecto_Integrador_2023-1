package Entidades;

import Config.Conexion;
import java.sql.*;
import java.util.List;

public class Calificacion {
    Conexion con = new Conexion();

    public Calificacion(Conexion conexion) {
        con = conexion;
    }
    
    //Calcular el promedio
    public double calcularpromedio(List<Integer> idPreguntas) throws SQLException { 
        double promedio = 0;
        String promedioQuery = "SELECT ROUND(AVG(nota),2) AS promedio FROM notas WHERE id_preguntas IN (";
        StringBuilder queryBuilder = new StringBuilder(promedioQuery);
    
        for (int i = 0; i < idPreguntas.size(); i++) {
            queryBuilder.append("?");
        
            if (i < idPreguntas.size() - 1) {
                queryBuilder.append(",");
            }
        }
    
        queryBuilder.append(")");
    
        PreparedStatement promedioStatement = con.getConnection().prepareStatement(queryBuilder.toString());
    
        for (int i = 0; i < idPreguntas.size(); i++) {
            promedioStatement.setInt(i + 1, idPreguntas.get(i));
        }
    
        ResultSet promedioResultSet = promedioStatement.executeQuery();
    
        if (promedioResultSet.next()) {
            promedio = promedioResultSet.getDouble("promedio");
        }
    
    return promedio;  
    }
}