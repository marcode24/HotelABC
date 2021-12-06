package controladores;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import DAO.conexion;
import modelos.Horario;

public class HorarioController {
    Connection cn;
    private String tableName = "tbHabitacion";
    CallableStatement cmd;
    
    public HorarioController() {
        conexion con = new conexion();
        cn = con.conectar();
    }
    
    public boolean crearHorarioHabitacion(Horario horario) {
        try {
            String sqlQuery = "INSERT INTO tbHorario (llegada, salida, noches, estado, total, idHabitacion_FK) "
                + "VALUES (?,?,?,?,?,?);";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, horario.getLlegada().toString());
            pst.setString(2, horario.getSalida().toString());
            pst.setInt(3, horario.getNoches());
            pst.setString(4, horario.getEstado());
            pst.setDouble(5, horario.getTotal());
            pst.setInt(6, horario.getIdHabitacion());
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
