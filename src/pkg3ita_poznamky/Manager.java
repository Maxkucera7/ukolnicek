/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3ita_poznamky;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krouzek
 */
public class Manager { // nacteni a ukladani poznamek
    private BufferedReader br;
    private BufferedWriter bw;
    private static Manager mng = new Manager();
    private String cesta = "./src/poznamky/poznamka.txt";
    
    public ArrayList<Poznamka> getPoznamky () 
    {
        String [] data_poznaky = new String[3]; // data pro novy objekt Poznamka
        int counter = 0; // ukazatel pro pole data_poznamky
        try 
        {
            ArrayList<Poznamka> poznamky = new ArrayList<>();
            br = new BufferedReader(new FileReader(cesta));
            String line;
            
            try 
            {
                while ( (line = br.readLine()) != null )
                {
                    data_poznaky[counter++] = line;
                    if (counter == 3) 
                    {
                        counter = 0;
                        poznamky.add(new Poznamka(data_poznaky[0], data_poznaky[1], data_poznaky[2]));
                    }
                }
            } 
            catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return poznamky;
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void ulozPoznamky (ArrayList<Poznamka> poznamky) 
    {
        try 
        {
            bw = new BufferedWriter(new FileWriter(cesta));
            for (Poznamka p : poznamky) {
                bw.write(p.getCas());
                bw.newLine();
                bw.write(p.getNadpis());
                bw.newLine();
                bw.write(p.getText());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Manager getInstance () 
    {
        return mng;
    }
}
