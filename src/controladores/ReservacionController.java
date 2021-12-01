package controladores;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;

import DAO.conexion;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelos.Habitacion;
import modelos.ReservacionCS;

public class ReservacionController {
    Connection cn;
    private String tableName = "tbReservacion";
    CallableStatement cmd;
    
    public ReservacionController() {
        conexion con = new conexion();
        cn = con.conectar();
    }
    
    public void obtenerReservaciones(DefaultTableModel modelo){
        try {
            String sqlQuery = "SELECT tr.*, th.nombre AS nHabitacion FROM "+tableName+ 
                " tr INNER JOIN tbHabitacion th ON tr.idHabitacion_FK = th.idHabitacion;";
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                modelo.addRow(addRowModel(rs));
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
    
    public void buscarReservaciones(DefaultTableModel modelo, String busqueda) {
        try {
            String sqlQuery = "SELECT tr.*, th.nombre AS nHabitacion FROM tbReservacion "
                + "tr INNER JOIN tbHabitacion th ON tr.idHabitacion_FK = th.idHabitacion "
                + "WHERE CONCAT(tr.nombre, ' ', tr.apellido) LIKE '%"+busqueda+"%';";
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                modelo.addRow(addRowModel(rs));
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
    
    public Object[] addRowModel(ResultSet rs) {
        Object[] datos = new Object[9];
        try {
            datos[0] = rs.getInt("idReservacion");
            datos[1] = rs.getString("nombre") + " " + rs.getString("apellido");
            datos[2] = rs.getInt("idHabitacion_FK");
            datos[3] = rs.getString("nHabitacion");
            datos[4] = rs.getString("llegada");
            datos[5] = rs.getString("salida");
            datos[6] = rs.getInt("noches");
            datos[7] = rs.getDouble("total");
            datos[8] = rs.getString("estado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return datos;
    }
    
    public boolean crearReservacion(ReservacionCS reservacion){
        try {
            String sqlQuery = "INSERT INTO " + tableName + " (nombre, apellido, "
                + "adultos, ninios, llegada, salida, noches, total, estado, idHabitacion_FK) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, reservacion.getNombre());
            pst.setString(2, reservacion.getApellido());
            pst.setInt(3, reservacion.getAdultos());
            pst.setInt(4, reservacion.getNinios());
            pst.setString(5, reservacion.getLlegada().toString());
            pst.setString(6, reservacion.getSalida().toString());
            pst.setInt(7, reservacion.getNoches());
            pst.setDouble(8, reservacion.getTotal());
            pst.setString(9, reservacion.getEstado());
            pst.setInt(10, reservacion.getIdHabitacion());
            int resp = pst.executeUpdate();
            return resp == 1;
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
    
    public boolean cambiarEstadoReservacion(String estado, int idReservacion) {
           try {
            String sqlQuery = "UPDATE "+tableName+ " SET estado = ? WHERE idReservacion = ? ;";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, estado);
            pst.setInt(2, idReservacion);
            return pst.executeUpdate() == 1;
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
    
}
