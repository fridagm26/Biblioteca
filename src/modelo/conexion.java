package modelo;
import java.sql.*;

public class conexion {
    
        public Connection abrirConexion() throws SQLException{
        Connection con;
        //Para conectarnos a nuestra base de datos
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(
                    "jdbc:mysql://10.10.10.47:3306/Banco","root", "12345678");
        }catch(SQLException e){
            System.out.println("NO se pudo abrir conexión");
            con = null;
        }            
        return con;
    }
    
    public void cerrarConexion(Connection c) throws SQLException{        
        try{
            if(!c.isClosed()){
                c.close();
            }
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexión");
        }        
    }   
}
