package modelo;

import java.sql.*;

public class ModeloBanco {
    private conexion conexion = new conexion();
    
    public boolean contactosActualizar(String cuenta1, String cuenta2 , Double total){
        PreparedStatement stmt1=null;
        PreparedStatement stmt2=null;   
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();
            con.setAutoCommit(false);
            stmt1 = con.prepareStatement("UPDATE Cuentas SET Saldo=Saldo -" + total + "WHERE NumCuenta = " + cuenta1 + ";");            
            stmt2 = con.prepareStatement("UPDATE Cuentas SET Saldo=Saldo +" + total + "WHERE NumCuenta = " + cuenta2 + ";");
            
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            
            con.commit();
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException ex) {
            return false;
        }
    }
}
