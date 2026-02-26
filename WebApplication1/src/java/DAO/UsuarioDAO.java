package DAO;

import DBase.ConexionDB;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public UsuarioDAO() {
    }    
    
    public void insert(Usuario usuario){
        try {
            conn = ConexionDB.MySQL8();
            conn.setAutoCommit(false);
            
            String SQL = "INSERT INTO usuarios VALUES(default, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            
            int rows = ps.executeUpdate();
            
            if (rows != 1){
                conn.rollback();
                throw new SQLException("error al insertar los datos");
            } else {
                conn.commit();
                System.out.println("datos insertados a la database");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch (Exception e) {}
            try {ps.close();} catch (Exception e) {}
        }
    }
    
    public void update(Usuario usuario){
        try {
            conn = ConexionDB.MySQL8();
            conn.setAutoCommit(false);
            
            String SQL = "UPDATE usuarios SET nombre = ?, correo = ?, contrasena = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            
            int rows = ps.executeUpdate();
            
            if (rows != 1){
                conn.rollback();
                throw new SQLException("error al actualizar los datos");
            } else {
                conn.commit();
                System.out.println("los datos fueron actualizados   ");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch (Exception e) {}
            try {ps.close();} catch (Exception e) {}
        }
    }
    
    public void delete(int id){
        
    }
}
