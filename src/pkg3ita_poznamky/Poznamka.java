/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3ita_poznamky;

/**
 *
 * @author Krouzek
 */
public class Poznamka {
    private String cas;
    private String nadpis;
    private String text;
    
    public Poznamka (String cas, String nadpis, String text) 
    {
        this.cas = cas;
        this.nadpis = nadpis;
        this.text = text;
    }
    
    public String getCas () 
    {
        return cas;
    }
    
    public String getNadpis () 
    {
        return nadpis;
    }
    
    public String getText () 
    {
        return text;
    }
}
