package semestralka;

/**
 * Tato třída je stěžejní třída programu. její instancí je objekt, který je
 * potomkem JFrame .
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

    private static Knihovna knihovna = new Knihovna();
    private static Knihovna pomocna = new Knihovna();
    private static Panely hlavnipanel = new Panely();
    private static Panely panelodebrat = new Panely();
    private static Panely panelhledat = new Panely();
    private static List list = new List(getKnihovna().velikost());
    private static List zobrlist = new List(getKnihovna().velikost());
    private static int pocet;

    
    public Okno() throws HeadlessException {

        super("Moje Okno");
        Knihovna kn = new Knihovna();
        kn.load();
        setKnihovna(kn);
        //knihovna.load();
        //pomocna.load();
        setPomocna(kn);

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
        
        Panely hlavnipanely = new Panely();

        hlavnipanely.add(l1);
        hlavnipanely.add(odebrat);
        hlavnipanely.add(novy);
        hlavnipanely.add(hledat);
        hlavnipanely.add(uloz);
        hlavnipanely.add(konec);

        setHlavnipanel(hlavnipanely);
        
        Panely panelodebrati = new Panely();
        panelodebrati.setVisible(false);
        panelodebrati.odebrat();
        setPanelodebrat(panelodebrati);

        getPanelhledat().setVisible(false);
       // panelhledat.setVisible(false);

        //panelhledat.hledat();

        Menulista m = new Menulista();
        setJMenuBar(m);
        add(getPanelhledat());
        add(getPanelodebrat());
        add(getHlavnipanel());
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
            getHlavnipanel().setVisible(false);
            getPanelodebrat().setVisible(true);
            getPanelhledat().setVisible(false);

        }
    }

    static class Hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getHlavnipanel().setVisible(false);
            getPanelodebrat().setVisible(false);
            getPanelhledat().setVisible(true);
            getPanelhledat().hledat();
           int p = Okno.getPocet();
           p++;
            Okno.setPocet(p);
            System.out.println("pocet stisknuti vyhledavani je: " + Okno.getPocet());

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
                Okno.getKnihovna().save();
                System.exit(0);

            }
        }
    }
    /*
     Metoda konec / ukončuje program, ukládá knihovnu
     */

    public class Zpet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getHlavnipanel().setVisible(true);
            getPanelodebrat().setVisible(false);
            getPanelhledat().setVisible(false);

        }
    }

    private class Ulozit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.getKnihovna().save();
        }
    }
    /*
     ActionListener tlacitka ulozit, uklada knihovnu
     */
    
    public static Knihovna getKnihovna() {
        return knihovna;
    }

    public static void setKnihovna(Knihovna knihovna) {
        Okno.knihovna = knihovna;
    }

    public static Knihovna getPomocna() {
        return pomocna;
    }

    public static void setPomocna(Knihovna pomocna) {
        Okno.pomocna = pomocna;
    }

    public static Panely getHlavnipanel() {
        return hlavnipanel;
    }

    public static void setHlavnipanel(Panely hlavnipanel) {
        Okno.hlavnipanel = hlavnipanel;
    }

    public static Panely getPanelodebrat() {
        return panelodebrat;
    }

    public static void setPanelodebrat(Panely panelodebrat) {
        Okno.panelodebrat = panelodebrat;
    }

    public static Panely getPanelhledat() {
        return panelhledat;
    }

    public static void setPanelhledat(Panely panelhledat) {
        Okno.panelhledat = panelhledat;
    }

    public static List getList() {
        return list;
    }

    public static void setList(List list) {
        Okno.list = list;
    }

    public static List getZobrlist() {
        return zobrlist;
    }

    public static void setZobrlist(List zobrlist) {
        Okno.zobrlist = zobrlist;
    }

    public static int getPocet() {
        return pocet;
    }

    public static void setPocet(int pocet) {
        Okno.pocet = pocet;
    }

}
