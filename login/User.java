/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import database.DatabaseAPI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author austen
 */
public class User {
    
    private String username;
    private String password;
    private String email;
    private int uid;
    private String dbname;
    
    public User(String username, String password, String email,String dbname)
    {
        if (validateSettings(username, password, email, dbname))
        {
            System.out.println("Validation successful");
            this.username = username;
            this.password = password;
            this.email = email;
            this.dbname = dbname;
            generateUID();
            System.out.println("Table successfully updated");
        }
        else 
        {
            System.out.println("Error, username already in use");
        }
        
    }
    
    private boolean saveSettings()
    {
        DatabaseAPI dapi = new DatabaseAPI();
        String[] userInfo = dapi.getInfo(dbname);
        dapi.setConnection(userInfo,dbname);
        ResultSet rs;
        String stmt = "insert into users values ('"+uid+"'"+username+"','"+password+"','"+email+"')";
        PreparedStatement ps = dapi.prepareStatement(stmt);
        try
        {
            ps.execute();
            return true;
        }
        catch (SQLException e)
        {
            return false;
        }
    }
    
    private void generateUID()
    {
        ResultSet rs;
        DatabaseAPI dapi = new DatabaseAPI();
        String[] userInfo;
        userInfo = dapi.getInfo(dbname);
        dapi.setConnection(userInfo,dbname);
        try
        {
            rs = dapi.executeStatement("Select * from users");
            rs.last();
            int currUID = rs.getInt("uid");
            uid = currUID+1;
        }
        catch (SQLException e)
        {
            System.exit(1);
        }
    }
    
    private boolean validateSettings(String username, String password, String email, String dbname)
    {
        ResultSet rs = null;
        DatabaseAPI dapi = new DatabaseAPI();
        String[] userInfo = dapi.getInfo(dbname);
        dapi.setConnection(userInfo, dbname);
        try
        {
            rs = dapi.executeStatement("Select * from users where username = '"+username+"';");
            rs.first();
            String result = rs.getString("username");
            return false;
        }
        catch (SQLException e)
        {
            return true;
        }
    }
}
