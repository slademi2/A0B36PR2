/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import java.util.ArrayList;

public class Knihovna {
    
    private ArrayList<Kniha> knihovna = new ArrayList<Kniha>();
    
    public void pridej(Kniha kn){
        knihovna.add(kn);
    }
    public String tisk (){
        String s = "vhy";
        for(int i = 0;i<knihovna.size();i++){
           
           s = knihovna.get(i).toString();
        }
        return s;
        
       
    }
    public int velikost(){
        int velikost;
        velikost = knihovna.size();
        return velikost;
    }
    public Kniha pridejdolist(int g){
        return knihovna.get(g);
    }

    @Override
    public String toString() {
        String s = "Knihovna obsahuje: ";
        for(int i = 0; i < knihovna.size();i++){
        s = s + knihovna.get(i).toString();
        return s;
        }
        return s;
      
    }
   
}
