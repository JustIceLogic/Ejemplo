/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcces;

import businessObjects.User;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;


/**
 *
 * @author ROGLOGIC
 */
public class UserDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
    public UserDAO(){
    }
    public UserDAO(Connection connection){
        this.connection = connection;
    }
    public Connection getCOnnection(){
        return connection;
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    public void addUser (User user){
        try{
            statement = connection.prepareStatement("INSERT INFO usuario VALUES(?,?,?,?)");
            synchronized(statement){
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3,user.getEmail());
                statement.executeUpdate();
            }
            statement.close();
        } catch(SQLException sqle){
            logger.log(Level.SEVERE, sqle.toString(),sqle);
            throw new RuntimeException(sqle);
        }
    }
}
