/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3ita_poznamky;

import java.util.ArrayList;

/**
 *
 * @author Krouzek
 */
public class Poznamkovy_blok {
    private ArrayList<Poznamka> poznamky;
    
    public Poznamkovy_blok () 
    {
        nactiPoznamky();
    }
    
    public ArrayList<Poznamka> getPoznamky () 
    {
        return poznamky;
    }
    
    public void nactiPoznamky () 
    {
        
        poznamky = Manager.getInstance().getPoznamky();
        System.out.println("");
    }
    
    public void pridejPoznamku (Poznamka p) 
    {
        poznamky.add(p);
        Manager.getInstance().ulozPoznamky(poznamky);
    }
    
    public void smazPoznamku (int index) 
    {
        poznamky.remove(index);
        Manager.getInstance().ulozPoznamky(poznamky);
    }
}
