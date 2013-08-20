/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

/**
 *
 * @author PRASAD
 */
public class SaveData {
    
    private static String savedEng = " ";
    
    SaveData()
    {}
    
    public static String getData()
    {
        return savedEng;
    }
    
    public static void setData(String temp)
    {
        savedEng = temp;
    }
    
    public static String getDateFromString(String datee)
    {
        StringTokenizer temp = new StringTokenizer(datee, "/");
        temp.nextToken();
        temp.nextToken();
        return temp.nextToken();
    }
    
    public static String getMonthFromString(String datee)
    {
        StringTokenizer temp = new StringTokenizer(datee, "/");
        temp.nextToken();
        return temp.nextToken();
    }
    
    public static String getYearFromString(String datee)
    {
        StringTokenizer temp = new StringTokenizer(datee, "/");
        return temp.nextToken();
    }
    
    public static String readFile(String fileName) throws IOException 
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
        return sb.toString();
    } finally {
        br.close();
    }
    
    
}
    
    
          
          
}
