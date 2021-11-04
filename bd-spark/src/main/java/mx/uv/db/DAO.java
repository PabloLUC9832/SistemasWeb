package mx.uv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Conexion conexion = new Conexion();

    public String insertarUsuario(Usuario u) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuario (id, email, password) VALUES (?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, u.getId());
            prestm.setString(2, u.getEmail());
            prestm.setString(3, u.getPassword());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario agregado";
            else
                msj = "No se agregó el usuario";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msj;
    }

    public List<Usuario> listadoUsuario() {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuario";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Usuario u = new Usuario(rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public String eliminarUsuario(Usuario u){
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();

        try {
            String sql = "DELETE FROM usuario WHERE email = ?;";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, u.getEmail());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario eliminado";
            else
                msj = "No se eliminó el usuario";         
            prestm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msj;        


    }

    public String modificarUsuario(Usuario u){
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();

        try {
            //String sql = "UPDATE usuario SET id = ?, password = ? WHERE email = ?;";
            String sql = "UPDATE usuario SET password = ? WHERE email = ?;";
            prestm = conn.prepareStatement(sql);            
            //prestm.setString(1, u.getId());
            prestm.setString(1, u.getPassword());            
            prestm.setString(2, u.getEmail());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario modificado";
            else
                msj = "No se modifico el usuario";         
            prestm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msj;        


    }   

}
