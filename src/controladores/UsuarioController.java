package controladores;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;

import DAO.conexion;
import java.text.MessageFormat;
import javax.swing.table.DefaultTableModel;
import modelos.Usuario;

public class UsuarioController {
    Connection cn;
    private String tableName = "tbUsuario";
    CallableStatement cmd;
    
    public UsuarioController() {
        conexion con = new conexion();
        cn = con.conectar();
    }
    
    public boolean crearUsuario(Usuario usuario) {
        try {
            String sqlQuery = "INSERT INTO "+tableName+ " (nombre, apellido, cargo, direccion, "
                + "telefono, usuario, password) "
                + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getCargo());
            pst.setString(4, usuario.getDireccion());
            pst.setInt(5, usuario.getTelefono());
            pst.setString(6, usuario.getUsuario());
            pst.setString(7, usuario.getPassword());
            return (!pst.execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                cmd.close();
                cn.close();   
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void obtenerUsuarios(DefaultTableModel modelo) {
        try {
            String sqlQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                Object[] datos = new Object[7];
                datos[0] = rs.getString("nombre");
                datos[1] = rs.getString("apellido");
                datos[2] = rs.getString("cargo");
                datos[3] = rs.getString("direccion");
                datos[4] = rs.getInt("telefono");
                datos[5] = rs.getString("usuario");
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                cmd.close();
                cn.close();   
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
