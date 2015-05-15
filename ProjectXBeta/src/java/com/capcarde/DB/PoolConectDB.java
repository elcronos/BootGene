package com.capcarde.DB;

import java.io.PrintStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class PoolConectDB
{

    public PoolConectDB()
    {
        connection = null;
        initConect();
    }

    private void initConect()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");
            path = path.replaceAll("build/web/", "");
            path+="src/java/DB/ProjectDB.sqlite";
            //String path = "/Users/camilo/NetBeansProjects/ProjectXBeta/db/ProjectDB.sqlite";
            connection = DriverManager.getConnection((new StringBuilder()).append("jdbc:sqlite:").append(path).toString());
        }
        catch(ClassNotFoundException ex)
        {
           
        }
        catch(SQLException ex)
        {
            
        }
    }

    public Connection getConnection()
    {
        try
        {
            if(connection.isClosed())
                initConect();
        }
        catch(SQLException ex)
        {
            
        }
        return connection;
    }
    
    public void closeConnection(){
        try {
            if(!connection.isClosed()) connection.close();
        } catch (SQLException ex) {
        }
      
    }

    private Connection connection;
}

