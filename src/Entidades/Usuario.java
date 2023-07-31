package Entidades;

import Config.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Usuario {
    Conexion con = new Conexion();
    Statement statement = null;

    //Constructor
    public Usuario(Conexion conexion) {
        con = conexion;
        try {
            statement = con.getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println("Error al crear el statement");
            e.printStackTrace();
        }
    }

    //Metodo login
    public boolean login(String usuario, String contraseña) throws SQLException {
        boolean verificacion = false;
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nos campos no pueden estar vacios");
        } else {
            String sql = "SELECT contraseña FROM usuarios WHERE nombre='" + usuario + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String tempcon = resultSet.getString("contraseña");
                if (tempcon.equals(contraseña)) {
                    verificacion = true;
                    break;
                }
            }
            if (verificacion) {
                JOptionPane.showMessageDialog(null, "Inicio de seccion exitoso");
            }
        }
        return verificacion;
    }

    //Metodo registro
    public void registro(String nombre, String contraseña, int idrol) throws SQLException {
        if (nombre.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos");
        } else {
            String sql = "SELECT nombre FROM usuarios WHERE nombre = ?";
            PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                JOptionPane.showMessageDialog(null, "Ya existe el nombre de usuario");
            } else {
                String insertSql = "INSERT INTO usuarios (nombre, contraseña) VALUES (?, ?)";
                PreparedStatement insert = (PreparedStatement) con.getConnection().prepareStatement(insertSql);
                insert.setString(1, nombre);
                insert.setString(2, contraseña);
                insert.executeUpdate();
                String idstr = "SELECT id FROM usuarios WHERE nombre = ?";
                PreparedStatement idStatement = (PreparedStatement) con.getConnection().prepareStatement(idstr);
                idStatement.setString(1, nombre);
                ResultSet resultid = idStatement.executeQuery();
                if (resultid.next()) {
                    int id = resultid.getInt("id");     //set String  id = int
                    String insertSqlrol = "INSERT INTO usuarios_roles (id_usuarios, id_roles) VALUES (?, ?)";
                    PreparedStatement insertrol = (PreparedStatement) con.getConnection().prepareStatement(insertSqlrol);
                    insertrol.setInt(1, id);
                    insertrol.setInt(2, idrol);
                    insertrol.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            }
        }
    }

    //Conseguir la id del usuario
    public int getId(String nombre) throws SQLException {
        int id = 0;
        String sql = "SELECT id FROM usuarios WHERE nombre = ?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;
    }

    //Conseguir el rol del usuario por el nombre
    public String getRol(String nombre) throws SQLException {
        String temprol = "";
        int id = 0;
        int idrol = 0;

        String sql = "SELECT id FROM usuarios WHERE nombre = ?";
        PreparedStatement preparedStatement = (PreparedStatement) con.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            id = resultSet.getInt("id");
            String sqlrol = "SELECT * FROM usuarios_roles WHERE id_usuarios = ?";
            PreparedStatement preparedStatementrol = (PreparedStatement) con.getConnection().prepareStatement(sqlrol);
            preparedStatementrol.setInt(1, id);
            ResultSet resultSetrol = preparedStatementrol.executeQuery();

            if (resultSetrol.next()) {
                idrol = resultSetrol.getInt("id_roles");

                String sqlrolnombre = "SELECT nombre FROM roles WHERE id = ?";
                PreparedStatement preparedStatementrolnombre = (PreparedStatement) con.getConnection().prepareStatement(sqlrolnombre);
                preparedStatementrolnombre.setInt(1, idrol);
                ResultSet resultSetrolnombre = preparedStatementrolnombre.executeQuery();

                if (resultSetrolnombre.next()) {
                    temprol = resultSetrolnombre.getString("nombre");
                }
            }
        }
        return temprol;
    }
    
    //Conseguir el rol por el id
    public String getRolById(int id) {
        String rol = null;
    
        try {
            String sqlrol = "SELECT nombre FROM roles WHERE id = (SELECT id_roles FROM usuarios_roles WHERE id_usuarios = ?)";
            PreparedStatement preparedStatementrol = (PreparedStatement) con.getConnection().prepareStatement(sqlrol);
            preparedStatementrol.setInt(1, id);
            ResultSet resultSetrol = preparedStatementrol.executeQuery();

            if (resultSetrol.next()) {
                rol = resultSetrol.getString("nombre");
            }

            resultSetrol.close();
            preparedStatementrol.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }
    
    //Conseguir el nombre por el id
    public String getNombreById(int idusuario){
        String nombreusuario=null;
        try {
            String sqlrol = "SELECT nombre FROM usuarios WHERE id = ?";
            PreparedStatement preparedStatementrol = (PreparedStatement) con.getConnection().prepareStatement(sqlrol);
            preparedStatementrol.setInt(1, idusuario);
            ResultSet resultSetrol = preparedStatementrol.executeQuery();

            if (resultSetrol.next()) {
                nombreusuario = resultSetrol.getString("nombre");
            }

            resultSetrol.close();
            preparedStatementrol.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return nombreusuario;
    }
}
