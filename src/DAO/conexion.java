package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    // aqui ponen sus respectivo datos de su conexion
    private String database = "HotelABC";
    private String user = "SA";
    private String password = "m24082001$";
    public Connection conectar() {
        String conexionURL = "jdbc:sqlserver://localhost:1433;"
                + "database="+ this.database +";" 
                + "user="+this.user+";" 
                + "password="+this.password+";"
                + "loginTimeout=30;"; // Es el tiempo de respuesta de conexion de la base de datos
        try {
            Connection con = DriverManager.getConnection(conexionURL);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}