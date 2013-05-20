package semestralka;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import javax.swing.*;

/*
 * trida ktera obsluhuje razeni knih, jejim itemlistenerem je ona sama
 */

public class MujChoice extends Choice implements ItemListener {
    /*
     * konstruktor
     */
    MujChoice() {

        this.add("           ");//0
        this.add("Autor jméno "); // 1
        this.add("Autor příjmení "); // 2
        this.add("Název: "); //3
        this.add("Rok "); // 4
        this.add("Žánr "); // 5
        this.add("Umístění "); // 6

        this.addItemListener(this);
    }
    

   /*
    * itemlistener
    * razeni vyuziva  tridy implementujici Comparatory 
    * umisteno ve tride Knihovna
    */
    @Override
    public void itemStateChanged(ItemEvent e) {
        int p = this.getSelectedIndex();

        Okno.getList().removeAll();

        if (p == 0) { // volba prvni ( neradi se)
            for (int i = 0; i < Okno.getPomocna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getPomocna().toStringAutorDilo(i));


            }
            Okno.setKnihovna(Okno.getPomocna());

        }
        if (p == 1) { // razeni podle jmena
            Collections.sort(Okno.getKnihovna().getKnihovna(), new PodleJmena());

            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }

        }
        if (p == 2) { // podle prijmeni
            Collections.sort(Okno.getKnihovna().getKnihovna(), new PodlePrijmeni());

            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
        }
        if (p == 3) { // podle nazvu
            Collections.sort(Okno.getKnihovna().getKnihovna(), new PodleNazvu());
            
            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
        }
        if (p == 4) { // podle roku
            Collections.sort(Okno.getKnihovna().getKnihovna(), new PodleRoku());
            
            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
        }
        if (p == 5) { // podle zanru
            Collections.sort(Okno.getKnihovna().getKnihovna(), new PodleZanru());
            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
        
        }
        if (p == 6) { // podle umisteni
            Collections.sort(Okno.getKnihovna().getKnihovna(), new PodleUmisteni());
            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
        }
    }
}
