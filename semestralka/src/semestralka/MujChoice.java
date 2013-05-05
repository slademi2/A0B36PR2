package semestralka;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import javax.swing.*;

public class MujChoice extends Choice implements ItemListener {

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

    @Override
    public void itemStateChanged(ItemEvent e) {
        int p = this.getSelectedIndex();

        Okno.list.removeAll();

        if (p == 0) {
            for (int i = 0; i < Okno.pomocna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.pomocna.toStringAutorDilo(i));
                

            }
            Okno.knihovna = Okno.pomocna;
            System.out.println("dfdsfsddsh");
        }
        if (p == 1) {
            Collections.sort(Okno.knihovna.getKnihovna(), new PodleJmena());

            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }

        }
        if (p == 2) {
            Collections.sort(Okno.knihovna.getKnihovna(), new PodlePrijmeni());
            
            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
        }
        if (p == 3) {
            Collections.sort(Okno.knihovna.getKnihovna(), new PodleNazvu());
            System.out.println(Okno.knihovna);

            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
        }
        if (p == 4) {
            Collections.sort(Okno.knihovna.getKnihovna(), new PodleRoku());
            System.out.println(Okno.knihovna);
            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
        }
        if (p == 5) {
            Collections.sort(Okno.knihovna.getKnihovna(), new PodleZanru());
            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
            System.out.println(Okno.knihovna);
        }
        if (p == 6) {
            Collections.sort(Okno.knihovna.getKnihovna(), new PodleUmisteni());
            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
            System.out.println(Okno.knihovna);
        }
    }
}
