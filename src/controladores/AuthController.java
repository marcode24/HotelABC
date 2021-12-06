package controladores;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;

import DAO.conexion;

public class AuthController {
    Connection cn;
    private String tableName = "tbUsuario";
    CallableStatement cmd;
    
    public AuthController() {
        conexion con = new conexion();
        cn = con.conectar();
    }
    
    public String Login(String usuario, String password) {
        int encontrado = 0;
        String cargo = "";
        try {
            String sqlQuery = "SELECT * FROM "+tableName+" WHERE usuario = ? AND password = ?";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, usuario);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                encontrado = 1;
                cargo = rs.getString("cargo");
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
        return (encontrado == 1) ? cargo : "";

    }
    
}
