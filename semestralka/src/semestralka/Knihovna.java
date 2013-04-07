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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Knihovna implements Serializable {

    private ArrayList<Kniha> knihovna = new ArrayList<Kniha>();
    private String pole[];

    public void pridej(Kniha kn) {
        knihovna.add(kn);
    }

    public String tisk() {
        String s = "vhy";
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
                ObjectInputStream ois = new ObjectInputStream(fis);
                knihovna = (ArrayList<Kniha>) ois.readObject();
                ois.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex) {
                Logger.getLogger(Knihovna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Byla vytvořena nová knihovna !!", "", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public Kniha getI(int i) {
        return knihovna.get(i);
    }
}
