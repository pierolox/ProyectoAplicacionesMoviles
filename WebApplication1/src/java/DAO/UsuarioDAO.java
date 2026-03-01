package DAO;

import DBase.ConexionDB;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
        try {
            conn = ConexionDB.MySQL8();
            conn.setAutoCommit(false);
            
            String SQL = "DELETE FROM usuarios WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            int rows = ps.executeUpdate();
            
            if (rows != 1) {
                conn.rollback();
                throw new SQLException("error al eliminar");
            } else {
                conn.commit();
                System.out.println("se borraron los datos");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch (Exception e) {}
            try {ps.close();} catch (Exception e) {}
        }
    }
    
    public Usuario findById(int id){
        Usuario usuario = null;
        
        try {
            conn = ConexionDB.MySQL8();
            conn.setAutoCommit(false);
            
            String SQL = "SELECT * FROM usuarios WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            rs=ps.executeQuery();
            
            if (!rs.next()) {
                conn.rollback();
                throw new SQLException("error al buscar datos por ID");
            } else {
                conn.commit();
                
                usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch (Exception e) {}
            try {ps.close();} catch (Exception e) {}
            try {rs.close();} catch (Exception e) {}
        }
        
        return usuario;
    }
    
    public Collection<Usuario> findAll(){
        Collection<Usuario> list = new ArrayList<>();
        
        try {
            conn=ConexionDB.MySQL8();
            
            String SQL = "SELECT * FROM usuarios ORDER BY id";
            ps=conn.prepareStatement(SQL);
            
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                
                list.add(usuario);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch (Exception e) {}
            try {ps.close();} catch (Exception e) {}
            try {rs.close();} catch (Exception e) {}
        }
    
        return list;
    }
}