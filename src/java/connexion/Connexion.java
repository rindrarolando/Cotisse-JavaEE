/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

/**
 *
 * @author Bryan
 */
import java.sql.*;

public class Connexion {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    static String username = "postgres";
    static String password = "1618";
    
    public Connexion(String request) {
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hopital",username,password);
            stm = getConnection().createStatement();
            rs = getStatement().executeQuery(request);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return con;
    }
    public Statement getStatement() {
        return stm;
    }
    public ResultSet getResultSet() {
        return rs;
    }
}
