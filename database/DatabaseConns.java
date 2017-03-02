/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author austen
 */
public class DatabaseConns {
    
    public static String[] getInfo(String dbname)
    {
        String[] userInfo = new String[2];
        ResultSet rs;
        DatabaseAPI dapi = new DatabaseAPI();
        dapi.setConnection("read-login", "ReadLoginTable", "masterlogins");
        rs = dapi.executeStatement("select * from logins where dbname='"+dbname+"' and type='read'");
        try
        {
            rs.first();
            userInfo[0]=rs.getString("username");
            userInfo[1]=rs.getString("password");
        }
        catch (SQLException e)
        {
            System.exit(1);
        }
        return userInfo;
    }
    
    public static String[] getWriteInfo(String dbname)
    {
        String[] userInfo = new String[2];
        ResultSet rs;
        DatabaseAPI dapi = new DatabaseAPI();
        dapi.setConnection("read-login", "ReadLoginTable", "masterlogins");
        rs = dapi.executeStatement("select * from logins where dbname='"+dbname+"' and type='write'");
        try
        {
            rs.first();
            userInfo[0]=rs.getString("username");
            userInfo[1]=rs.getString("password");
        }
        catch (SQLException e)
        {
            System.exit(0);
        }
        return userInfo;
    }
}
