/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Knihovna implements Serializable {

    private ArrayList<Kniha> knihovna = new ArrayList<Kniha>();
    private String pole[];

    public ArrayList<Kniha> getKnihovna() {
        return knihovna;
    }
    
    

    public void pridej(Kniha kn) {
        knihovna.add(kn);
    }

    public String tisk() {
        String s = " ";
        for (int i = 0; i < knihovna.size(); i++) {

            s = knihovna.get(i).toString();
        }
        return s;


    }

    public int velikost() {
        int velikost;
        velikost = knihovna.size();
        return velikost;
    }

    @Override
    public String toString() {
        String s = "Knihovna obsahuje: ";
        for (int i = 0; i < knihovna.size(); i++) {
            s = s + knihovna.get(i).toString();
            return s;
        }
        return s;

    }

    public String toStringAutorDilo(int i) {
        return knihovna.get(i).getJmeno() + " " + knihovna.get(i).getPrijmeni() + " - "
                + knihovna.get(i).getNazev() + " , " + knihovna.get(i).getRok();
    }

    public void save() {
        try {
            FileOutputStream fwJm = new FileOutputStream("Knihovna.txt");
            ObjectOutputStream fw = new ObjectOutputStream(fwJm);
            fw.writeObject(knihovna);
            fw.close();
            fwJm.close();
            JOptionPane.showMessageDialog(null, "Successfully saved", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {

        File file = new File("Knihovna.txt");

        if (file.exists() == true) {

            try {

                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream oip = new ObjectInputStream(fis);
                knihovna = (ArrayList<Kniha>) oip.readObject();
                oip.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex) {
                Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Byla vytvořena nová knihovna !!", "", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public Kniha getI(int i) {
        return knihovna.get(i);
    }

    public void Odeber(int i) {
        if (i < knihovna.size()) {
            knihovna.remove(i);
        } else {
            JOptionPane.showMessageDialog(null, " Nebya vybrána žádná kniha pro smazání !!", "", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public Knihovna HledejJmeno(String s){
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for(int i = 0; i <Okno.knihovna.velikost();i++){
           jmeno = Okno.knihovna.getI(i).getJmeno().toLowerCase();
           if(jmeno.contains(s)){
               kn.pridej(Okno.knihovna.getI(i));
           }
        }
        return kn;
    }
    public Knihovna HledejPrijmeni(String s){
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for(int i = 0; i <Okno.knihovna.velikost();i++){
           jmeno = Okno.knihovna.getI(i).getPrijmeni().toLowerCase();
           if(jmeno.contains(s)){
               kn.pridej(Okno.knihovna.getI(i));
           }
        }
        return kn;
    }
    public Knihovna HledejRok(String s){
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for(int i = 0; i <Okno.knihovna.velikost();i++){
           jmeno = Okno.knihovna.getI(i).getRok().toLowerCase();
           if(jmeno.contains(s)){
               kn.pridej(Okno.knihovna.getI(i));
           }
        }
        return kn;
    }
    public Knihovna HledejNazev(String s){
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for(int i = 0; i <Okno.knihovna.velikost();i++){
           jmeno = Okno.knihovna.getI(i).getNazev().toLowerCase();
           if(jmeno.contains(s)){
               kn.pridej(Okno.knihovna.getI(i));
           }
        }
        return kn;
    }
    public Knihovna HledejUmisteni(String s){
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for(int i = 0; i <Okno.knihovna.velikost();i++){
           jmeno = Okno.knihovna.getI(i).getUmisteni().toLowerCase();
           if(jmeno.contains(s)){
               kn.pridej(Okno.knihovna.getI(i));
           }
        }
        return kn;
    }
    public Knihovna HledejZanr(String s){
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for(int i = 0; i <Okno.knihovna.velikost();i++){
           jmeno = Okno.knihovna.getI(i).getZanr().toLowerCase();
           if(jmeno.contains(s)){
               kn.pridej(Okno.knihovna.getI(i));
           }
        }
        return kn;
    }
    
    
}
class PodleJmena implements Comparator<Kniha> {

    @Override
    public int compare(Kniha o1, Kniha o2) {
        return o1.getJmeno().compareTo(o2.getJmeno());
    }
}


class PodleNazvu implements Comparator<Kniha> {

    @Override
    public int compare(Kniha o1, Kniha o2) {
        return o1.getNazev().compareTo(o2.getNazev());
    }
}

class PodlePrijmeni implements Comparator<Kniha> {

    @Override
    public int compare(Kniha o1, Kniha o2) {
        return o1.getPrijmeni().compareTo(o2.getPrijmeni());
        
    }
}

class PodleRoku implements Comparator<Kniha> {

    @Override
    public int compare(Kniha o1, Kniha o2) {
        return o1.getRok().compareTo(o2.getRok());
    }
}

class PodleUmisteni implements Comparator<Kniha> {

    @Override
    public int compare(Kniha o1, Kniha o2) {
        return o1.getUmisteni().compareTo(o2.getUmisteni());
    }
}

class PodleZanru implements Comparator<Kniha> {

    @Override
    public int compare(Kniha o1, Kniha o2) {
        return o1.getZanr().compareTo(o2.getZanr());
    }
}
