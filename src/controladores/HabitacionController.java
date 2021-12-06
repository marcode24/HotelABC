package controladores;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.io.File;

import DAO.conexion;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import modelos.Habitacion;
import modelos.Horario;
import modelos.ReservacionCS;

public class HabitacionController {
    Connection cn;
    private String tableName = "tbHabitacion";
    CallableStatement cmd;
    
    public HabitacionController(){
        conexion con = new conexion();
        cn = con.conectar();
    }      
    
    public void obtenerHabitaciones(DefaultTableModel modelo, int campos){
        try {
            String sqlQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                Object[] datos = new Object[campos];
                datos[0] = rs.getInt("idHabitacion");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getInt("capacidad");
                datos[3] = rs.getDouble("precio");
                datos[4] = rs.getString("cama");
                datos[5] = rs.getInt("cantidadCamas");
                datos[6] = rs.getInt("tamanioHabitacion");
                datos[7] = rs.getString("descripcion");
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
     
    public ArrayList<Habitacion> obtenerHabitaciones() {
        Habitacion habitacion;
        ArrayList list = new ArrayList();
        try {
            String sqlQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            ResultSet rs = cmd.executeQuery();
            
            while(rs.next()){
                habitacion = new Habitacion();
                habitacion.setNombre((rs.getString("nombre")));
                habitacion.setCapacidad(rs.getInt("capacidad"));
                habitacion.setPrecio(rs.getDouble("precio"));
                habitacion.setCama(rs.getString("cama"));
                habitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                habitacion.setTamanioHabitacion(rs.getInt("tamanioHabitacion"));
                habitacion.setDescripcion(rs.getString("descripcion"));
                habitacion.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
                habitacion.setImagen(rs.getBytes("foto"));
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setDisponible(rs.getInt("disponible"));
                list.add(habitacion);
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
        return list;
    }
    
    public ArrayList<String> checarDisponiblidad(ReservacionCS reservacion) {
        Habitacion habitacion;
        ArrayList list = new ArrayList();
        try {
           
            String sqlQuery = " SELECT ho.*, ha.idHabitacion, ha.nombre FROM tbHorario ho "
                + "INNER JOIN tbHabitacion ha ON ho.idHabitacion_FK = ha.idHabitacion "
                + "WHERE (salida >= ? AND salida <= ?) OR (llegada >= ? AND llegada <= ?);"; 
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            cmd.setString(1, reservacion.getLlegada().toString());
            cmd.setString(2, reservacion.getSalida().toString());
            cmd.setString(3, reservacion.getLlegada().toString());
            cmd.setString(4, reservacion.getSalida().toString());
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                list.add(rs.getString("nombre"));
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
        return list;
    }
    
    public ArrayList<String> checarDisponiblidad(LocalDate salida) {
        Habitacion habitacion;
        ArrayList list = new ArrayList();
        try {
           
            String sqlQuery = " SELECT ho.*, ha.idHabitacion, ha.nombre FROM tbHorario ho "
                + "INNER JOIN tbHabitacion ha ON ho.idHabitacion_FK = ha.idHabitacion "
                + "WHERE (salida >= ? AND salida <= ?) OR (llegada >= ? AND llegada <= ?);"; 
            CallableStatement cmd = cn.prepareCall(sqlQuery);
            cmd.setString(1, LocalDate.now().toString());
            cmd.setString(2, salida.toString());
            cmd.setString(3, LocalDate.now().toString());
            cmd.setString(4, salida.toString());
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                list.add(rs.getString("nombre"));
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
        return list;
    }
    
    public boolean actualizarHabitacion(Habitacion habitacion) {        
        try {
            String sqlQuery = "UPDATE "+ tableName +" SET nombre = ?, "
                + "capacidad = ?, precio = ?, cama = ?, cantidadCamas = ?, "
                + "tamanioHabitacion = ?, descripcion = ? WHERE idHabitacion = ?";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, habitacion.getNombre());
            pst.setInt(2, habitacion.getCapacidad());
            pst.setDouble(3, habitacion.getPrecio());
            pst.setString(4, habitacion.getCama());
            pst.setInt(5, habitacion.getCantidadCamas());
            pst.setInt(6, habitacion.getTamanioHabitacion());
            pst.setString(7, habitacion.getDescripcion());
            pst.setInt(8, habitacion.getIdHabitacion());
            return (pst.executeUpdate() > 0) ? true : false;
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
    
    public boolean cambiarDisponibilidad(int idHabitacion) {
         try {
            String sqlQuery = "UPDATE "+ tableName +" SET disponible = ? WHERE idHabitacion = ? ;";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setInt(1, 0);
            pst.setInt(2, idHabitacion);
            return (pst.executeUpdate() > 0) ? true : false;
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
    
    public boolean crearHabitacion(Habitacion habitacion) {
        try {
            String sqlQuery = "INSERT INTO "+ tableName +" (nombre, capacidad, precio, cama, cantidadCamas, "
                    + "tamanioHabitacion, descripcion, numeroHabitacion, disponible, foto) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, habitacion.getNombre());
            pst.setInt(2, habitacion.getCapacidad());
            pst.setDouble(3, habitacion.getPrecio());
            pst.setString(4, habitacion.getCama());
            pst.setInt(5, habitacion.getCantidadCamas());
            pst.setInt(6, habitacion.getTamanioHabitacion());
            pst.setString(7, habitacion.getDescripcion());
            pst.setInt(8, 3);
            pst.setInt(9, 1);
            FileInputStream convertirImagen = new FileInputStream(habitacion.getFoto());
            pst.setBlob(10, convertirImagen, (int)habitacion.getFoto().length());
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
     
}
