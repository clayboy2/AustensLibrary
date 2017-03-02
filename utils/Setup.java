/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author austenclay
 */
public class Setup {
    public Setup()
    {
        //Do first time application setup
        Properties props = new Properties();
        props.setProperty("workingpath", Paths.get(".").toAbsolutePath().normalize().toString());
        System.out.println(props.getProperty("workingpath"));
    }
    
    public static void main(String[] args)
    {
        Setup s = new Setup();
    }
}
