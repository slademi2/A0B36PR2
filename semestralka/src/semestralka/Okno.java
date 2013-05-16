package semestralka;

/**
 * Tato třída je stěžejní třída programu. její instancí je objekt, který je potomkem JFrame .
 *
 * @author Michal
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import javax.swing.*;

public class Okno extends JFrame {

    static Knihovna knihovna = new Knihovna();
    static Knihovna pomocna = new Knihovna();
    public static Panely hlavnipanel = new Panely();
    public static Panely panelodebrat = new Panely();
    public static Panely panelhledat = new Panely();
    static List list = new List(knihovna.velikost());
    static List zobrlist = new List(knihovna.velikost());
    static int pocet;

    public Okno() throws HeadlessException {

        super("Moje Okno");
        knihovna.load();
        pomocna.load();

        int vyska = 455;
        int sirka = 360;
        this.setBounds(400, 200, vyska, sirka);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 10, 320, 32);
        l1.setText("Vítejte v Databázi knih, zadejte požadavek");

        Tlacitko novy = new Tlacitko("Přidat Knihu");

        novy.setBounds(50, 50, 150, 30);
        novy.addActionListener(new Okno.Novy());

        Tlacitko hledat = new Tlacitko("Vyhledat knihu ");
        hledat.setBounds(50, 85, 150, 30);
        hledat.addActionListener(new Okno.Hledat());

        Tlacitko odebrat = new Tlacitko("Zobrazit knihovnu");
        odebrat.setBounds(50, 120, 150, 30);
        odebrat.addActionListener(new Odebrat());

        Tlacitko uloz = new Tlacitko("Uložit knihovnu");
        uloz.setBounds(50, 155, 150, 30);
        uloz.addActionListener(new Ulozit());

        Tlacitko konec = new Tlacitko("Ukončit program");
        konec.setBounds(50, 190, 150, 30);
        konec.addActionListener(new Konec());

        hlavnipanel.add(l1);
        hlavnipanel.add(odebrat);
        hlavnipanel.add(novy);
        hlavnipanel.add(hledat);
        hlavnipanel.add(uloz);
        hlavnipanel.add(konec);


        panelodebrat.setVisible(false);
        panelodebrat.odebrat();


        panelhledat.setVisible(false);

        //panelhledat.hledat();

        Menulista m = new Menulista();
        setJMenuBar(m);
        add(panelhledat);
        add(panelodebrat);
        add(hlavnipanel);
        this.setVisible(true);


    } 
    /*Konstruktor, obsahuje všechna
     * tlačítka hlavního okna programu*/

    static class Novy implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PomocnaOkna ok = new PomocnaOkna();
            ok.novy();
        }
    }
    /*
     * Action listener tlačítka "novy",
     * vytváří instanci třídy PomocnaOkna
     */

    static class Odebrat implements ActionListener {//zobrazeni knihovny

        @Override
        public void actionPerformed(ActionEvent e) {
            hlavnipanel.setVisible(false);
            panelodebrat.setVisible(true);
            panelhledat.setVisible(false);

        }
    }

    static class Hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hlavnipanel.setVisible(false);
            panelodebrat.setVisible(false);
            panelhledat.setVisible(true);
            panelhledat.hledat();
            pocet++;
            System.out.println("pocet stisknuti vyhledavani je: " + pocet);

        }
    }

    private static class Konec implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("EXIT");
            int n = JOptionPane.showConfirmDialog(frame, "Opravdu chcete ukončit program?",
                    "Exit", JOptionPane.YES_NO_OPTION);
            if (n == 1) {
                frame.dispose();
            } else {
                Okno.knihovna.save();
                System.exit(0);

            }
        }
    }

    public class Zpet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hlavnipanel.setVisible(true);
            panelodebrat.setVisible(false);
            panelhledat.setVisible(false);

        }
    }

    public class Zpet_Hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private class Ulozit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.knihovna.save();
        }
    }
}
