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


/*
 * Knihovna - zastupuje obsah knihovny
 */
public class Knihovna implements Serializable {

    private ArrayList<Kniha> knihovna = new ArrayList<Kniha>();

    public ArrayList<Kniha> getKnihovna() {
        return knihovna;
    }

    /*
     * pridavani knihy do knihovny
     */
    public void pridej(Kniha kn) {
        getKnihovna().add(kn);
    }

    public String tisk() {
        String s = " ";
        for (int i = 0; i < getKnihovna().size(); i++) {

            s = getKnihovna().get(i).toString();
        }
        return s;


    }

    /*
     * zjisteni velikosti knihovny
     */
    public int velikost() {
        int velikost;
        velikost = getKnihovna().size();
        return velikost;
    }

    @Override
    public String toString() {
        String s = "Knihovna obsahuje: ";
        for (int i = 0; i < getKnihovna().size(); i++) {
            s = s + getKnihovna().get(i).toString();
            return s;
        }
        return s;

    }

    /*
     * zajistuje,jak budou polozky v Listu vypsany
     */
    public String toStringAutorDilo(int i) {
        return getKnihovna().get(i).getJmeno() + " " + getKnihovna().get(i).getPrijmeni() + " - "
                + getKnihovna().get(i).getNazev() + " , " + getKnihovna().get(i).getRok() + "  -  " + getKnihovna().get(i).getZanr()
                + "  -  " + getKnihovna().get(i).getUmisteni();
    }

    /*
     * Uklada Knihovnu
     */
    public void save() {
        try {
            FileOutputStream fwJm = new FileOutputStream("Knihovna.txt");
            ObjectOutputStream fw = new ObjectOutputStream(fwJm);
            fw.writeObject(getKnihovna());
            fw.close();
            fwJm.close();
            JOptionPane.showMessageDialog(null, "Successfully saved", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Nacita knihovnu
     */
    public void load() {

        File file = new File("Knihovna.txt");

        if (file.exists() == true) {//pokud je z ceho nacist

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
        } else { // Pokud neni
            JOptionPane.showMessageDialog(null, "Byla vytvořena nová knihovna !!", "", JOptionPane.INFORMATION_MESSAGE);
            try {
                FileOutputStream fwJm = new FileOutputStream("Knihovna.txt");
                ObjectOutputStream fw = new ObjectOutputStream(fwJm);
                fw.writeObject(getKnihovna());
                fw.close();
                fwJm.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    
    /*
     * vraci knihu na pozici (i)
     */
    public Kniha getI(int i) {

        return getKnihovna().get(i);

    }

    /*
     * nahrazuje knihu na pozici (i)
     */
    public void UpravI(Kniha p, int i) {
        getKnihovna().set(i, p);
    }
    /*
     * maze knihu na pozici i.
     */
    public void Odeber(int i) {
        if (i < getKnihovna().size()) {
            getKnihovna().remove(i);
        } else {
            JOptionPane.showMessageDialog(null, " Nebya vybrána žádná kniha pro smazání !!", "", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
   /*
    * hledani podle parametru
    * vyuziva trida ObsluhaHledani
    */

    public Knihovna HledejJmeno(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).getJmeno().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }

    public Knihovna HledejPrijmeni(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).getPrijmeni().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }

    public Knihovna HledejRok(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).getRok().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }

    public Knihovna HledejNazev(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).getNazev().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }

    public Knihovna HledejUmisteni(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).getUmisteni().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }

    public Knihovna HledejZanr(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).getZanr().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }

    public Knihovna HledejVse(String s) {
        s = s.toLowerCase();
        Knihovna kn = new Knihovna();
        String jmeno;
        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            jmeno = Okno.getKnihovna().getI(i).toStringall().toLowerCase();
            if (jmeno.contains(s)) {
                kn.pridej(Okno.getKnihovna().getI(i));
            }
        }
        return kn;
    }
}

/*
 * razeni podle parametru, vyuziva trida MujChoice
 */
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
