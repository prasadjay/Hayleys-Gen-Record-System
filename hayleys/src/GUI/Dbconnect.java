/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Abc
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.sql.*;
//import java.sql.Connection;
import javax.swing.JOptionPane;

public class Dbconnect {
    
        private static String strHost = "127.0.0.1";
        private static String iPort = "3306";
        private static String strDBName = "akhila";
        private static String strUserName = "root";
        private static String strPassword = "33235000";

    public  Connection con = null;

    public Connection connect() 
    {
        

        try {
            //loading mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            //connection string
            String url = "jdbc:mysql://" + strHost + ":" + iPort + "/" + strDBName;
            //establishing connection
            con = DriverManager.getConnection(url, strUserName, strPassword);
            return con;
            //successfully connected
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nPlease Try Again", "DB Connection Failure", 1);
            return null;
        }



    }

    public void closeConnection(Connection dbCon) {
        try {
            dbCon.close(); //close connection
        } catch (Exception e) {
        }
    }

    public int executeNonQuery(String sqlString)
    {
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(sqlString);
            return rows;//return the number of rows affected
        } catch (SQLException e) {
            //display error message
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nPlease Try Again", "Non Query Execution Failure", 1);
            return -1;
        }
    }

    public ResultSet executeSQLQuery(String sqlQuery)
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sqlQuery); //query successfully executed
            return result;
        } catch (SQLException e) {
            //display error message
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nPlease Try Again", "Query Execution Failure", 1);
            //JOptionPane.showMessageDialog(null, e, title, messageType)
            return null; //sql query execution failed
        }
    }
    
    
    
  
    // setter methods by PRASAD
    
    public static void updateConnectionSettings()
    {
        String path = System.getProperty("user.dir")+"/"+"dbSettings.txt";
        //String path = "D:/dbSettings.txt";
        
        try
        {
        strHost = Dbconnect.readHost(path);
        iPort = Dbconnect.readPort(path);
        strDBName = Dbconnect.readDatabase(path);
        strUserName = Dbconnect.readUsername(path);
        strPassword = Dbconnect.readPassword(path);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // PRASAD's SETTER methods ends here
    
    public static String readHost(String fileName) throws IOException 
    {
        
        
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        //return sb.toString();
        
        StringTokenizer temp = new StringTokenizer(sb.toString(), "#");
        return temp.nextToken();
        
    } 
    
    finally {
        br.close();
    }
    
}
    
      public static String readPort(String fileName) throws IOException 
    {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        StringTokenizer temp = new StringTokenizer(sb.toString(), "#");
        temp.nextToken();
        return temp.nextToken();
    } finally {
        br.close();
    }
    
}
    
      
        public static String readDatabase(String fileName) throws IOException 
    {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        StringTokenizer temp = new StringTokenizer(sb.toString(), "#");
        temp.nextToken();
        temp.nextToken();
        return temp.nextToken();
    } finally {
        br.close();
    }
    
}
        
          public static String readUsername(String fileName) throws IOException 
    {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        StringTokenizer temp = new StringTokenizer(sb.toString(), "#");
        temp.nextToken();
        temp.nextToken();
         temp.nextToken();
        return temp.nextToken();
    } finally {
        br.close();
    }
    
}
          
    public static String readPassword(String fileName) throws IOException 
    {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        StringTokenizer temp = new StringTokenizer(sb.toString(), "#");
        temp.nextToken();
        temp.nextToken();
         temp.nextToken();
         temp.nextToken();
        return temp.nextToken();
    } finally {
        br.close();
    }
    
}
}
