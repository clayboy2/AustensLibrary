/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author austen
 */
public class DatabaseAPI {
    MysqlDataSource ds;
    
    public DatabaseAPI()
    {
        ds = new MysqlDataSource();
    }
    
    public void setConnection(String[] userInfo, String dbname)
    {
        setConnection(userInfo[0],userInfo[1],dbname);
    }
    
    public void setConnection(String[]userInfo, String dbname, String servername)
    {
        setConnection(userInfo[0], userInfo[1], dbname, servername);
    }
    
    public void setConnection(String username, String password, String dbname)
    {
        ds.setUser(username);
        ds.setPassword(password);
        ds.setDatabaseName(dbname);
        ds.setServerName("127.0.0.1");
    }
    
    public void setConnection(String username, String password, String dbname, String servername)
    {
        setConnection(username,password,dbname);
        ds.setServerName(servername);
    }
    
    public ResultSet executeStatement(String statement)
    {
        ResultSet rs = null;
        try
        {
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(statement);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("error Executing statement");
            System.exit(1);
        }
        return rs;
    }
    
    public String[] getInfo(String dbname)
    {
        return DatabaseConns.getInfo(dbname);
    }
    
    public String[] getWriteInfo(String dbname)
    {
        return DatabaseConns.getWriteInfo(dbname);
    }
    
    public PreparedStatement prepareStatement(String stmt)
    {
        PreparedStatement ps = null;
        try
        {
            Connection conn = ds.getConnection();
            ps = conn.prepareStatement(stmt);
        }
        catch (SQLException e)
        {
            System.exit(0);
        }
        return ps;
    }
}
