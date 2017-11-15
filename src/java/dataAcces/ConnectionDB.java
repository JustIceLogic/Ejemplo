/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcces;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author ROGLOGIC
 */
public class ConnectionDB {
    private Connection connection = null;
    private static final Logger logger = Logger.getLogger(ConnectionDB.class.getName());

public ConnectionDB(){
    try{
        String host = "localhost";
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://"+host+":5432/TEC",
                user = "postgres",
                password="jorge123";
        connection = DriverManager.getConnection(url,user,password);
    } catch (SQLException sqle){
        logger.log(Level.SEVERE,sqle.toString(),sqle);
        throw new RuntimeException(sqle);
    } catch(Exception e){
        logger.log(Level.SEVERE, e.toString(), e);
    }
}
public Connection getConnectionDB(){
    return connection;
}
public void setConnectionDB(Connection connection){
    this.connection = connection;
}
}
