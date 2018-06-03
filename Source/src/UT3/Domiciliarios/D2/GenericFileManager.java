/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.Domiciliarios.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author yago
 */
public class GenericFileManager {
    
    public static void writeFile(String filePath, String[] fileWriteLines) {
        FileWriter fw;
        try 
        {
            fw = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < fileWriteLines.length; i++)
            {
                String currentLine = fileWriteLines[i];
                bw.write(currentLine);
                bw.newLine();
            }
            
            bw.close();
            fw.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Error al escribir el archivo "+filePath);
            e.printStackTrace();
        }
    }

    public static String[] readFile(String filePath)
    {
        FileReader fr;
        ArrayList<String> fileLines = new ArrayList<String>();
        try 
        {
            fr = new FileReader(filePath);        
            BufferedReader br = new BufferedReader(fr);
            
            String currentLine = br.readLine();
            while (currentLine != null)
            {
                fileLines.add(currentLine);
                currentLine = br.readLine();
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error al leer el archivo "+filePath);
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            System.out.println("Error al leer el archivo "+filePath);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");
        return fileLines.toArray (new String [0]);
    }
}
