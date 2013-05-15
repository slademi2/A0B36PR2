package semestralka;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Panely extends JPanel {

    private String pred;
    private String soucastne;
    static public int pocet;
    static Knihovna kn = new Knihovna();
    static JTextField text = new JTextField();
    static int n;
    static List li = new List(Okno.knihovna.velikost());
    public int vyska = 450;
    public int sirka = 280;
    boolean oznaceno = false;
    boolean oznaceno_List = false;
    int predchozi;
    static JFrame f = new JFrame("Kniha");

    //public int n;
    public String getPred() {
        return pred;
    }

    public void setPred(String pred) {
        this.pred = pred;
    }

    public String getSoucastne() {
        return soucastne;
    }

    public void setSoucastne(String soucastne) {
        this.soucastne = soucastne;
    }

    public Panely() {
        this.setSize(vyska, sirka);
        this.setVisible(true);
        this.setLayout(null);
    }

    void odebrat() { // panel zobrazit, spatne pojmenovani

        int vyska = 455;
        int sirka = 340;
        this.setSize(vyska, sirka);

        for (int i = 0; i < Okno.knihovna.velikost(); i++) {

            Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));

        }

        MujChoice choc = new MujChoice(); // trideni podle ceho zobrazit
        choc.setBounds(208, 245, 110, 30);



        Okno.list.addActionListener(new ListAction());
        Okno.list.addItemListener(new ItemAction());
        Okno.list.setVisible(true);
        Okno.list.setBounds(5, 2, 435, 240);

        JLabel lab = new JLabel("Seřadit podle: ");
        lab.setBounds(115, 245, 90, 20);



        Tlacitko zpet = new Tlacitko("Zpět");
        zpet.setBounds(340, 270, 100, 30);
        zpet.addActionListener(new Zpet());

        Tlacitko upravit = new Tlacitko("Upravit");
        upravit.setBounds(175, 270, 100, 30);
        upravit.addActionListener(new Upravit_Zobrazit());


        Tlacitko smazat = new Tlacitko("Smazat");
        smazat.setBounds(5, 270, 100, 30);
        smazat.addActionListener(new Smazat());

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 240, 450, 10);

        this.add(lab);
        this.add(choc);
        this.add(smazat);
        this.add(zpet);
        this.add(sep);
        this.add(Okno.list);
        this.add(upravit);


    }

    void hledat() {
        li.removeAll();
        this.setVisible(true);
        int vyska = 455;
        int sirka = 340;
        this.setSize(vyska, sirka);
        //this.setResizable(false);
        //this.setTitle("Vyhledávání knih: ");

        for (int i = 0; i < Okno.knihovna.velikost(); i++) {
            Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
        }



        Panely.li.setBounds(2, 2, 440, 180);

        Panely.li.addActionListener(new ListAction_Hledat());
        Panely.li.addItemListener(new ItemAction_Hledat());
        this.add(li);
        /* pocet = li.getItemCount();
         System.out.println("pocet knih v listu je : " + pocet);*/
        pocet = Panely.li.getItemCount();
        System.out.println("pocet knih v listu je : " + pocet);

        text = new JTextField();
        text.setBounds(200, 185, 205, 30);
        text.setEditable(true);


        ObsluhaHledani ob = new ObsluhaHledani();

        Tlacitko zpet = new Tlacitko("Zpět");
        zpet.setBounds(340, 270, 100, 30);
        zpet.addActionListener(new Zpet_Hledat());

        Tlacitko upravit = new Tlacitko("Upravit");
        upravit.setBounds(175, 270, 100, 30);
        upravit.addActionListener(new Upravit_Hledat());

        Tlacitko smazat = new Tlacitko("Smazat");
        smazat.setBounds(5, 270, 100, 30);
        smazat.addActionListener(new Smazat_Hledat());

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 181, 440, 5);

        JSeparator mep = new JSeparator();
        sep.setBounds(04, 262, 438, 5);

        JLabel retezec = new JLabel("Zadejte řetězec pro hledání: ");
        retezec.setBounds(5, 185, 300, 30);

        this.add(retezec);

        JLabel hled = new JLabel("Vyhledat podle: ");
        hled.setBounds(5, 215, 100, 30);
        this.add(hled);

        Tlacitko jmeno = new Tlacitko("Jména");
        jmeno.addActionListener(ob);
        jmeno.setBounds(130, 215, 100, 20);
        this.add(jmeno);

        Tlacitko prijmeni = new Tlacitko("Příjmení");
        prijmeni.addActionListener(ob);
        prijmeni.setBounds(235, 215, 100, 20);
        this.add(prijmeni);

        Tlacitko nazev = new Tlacitko("Názvu");
        nazev.addActionListener(ob);
        nazev.setBounds(340, 215, 100, 20);
        this.add(nazev);

        Tlacitko rok = new Tlacitko("Roku");
        rok.addActionListener(ob);
        rok.setBounds(130, 240, 100, 20);
        this.add(rok);

        Tlacitko umisteni = new Tlacitko("Umístění");
        umisteni.addActionListener(ob);
        umisteni.setBounds(235, 240, 100, 20);
        this.add(umisteni);

        Tlacitko vse = new Tlacitko("Vše");
        vse.addActionListener(ob);
        vse.setBounds(340, 240, 100, 20);

        this.add(vse);

        this.add(text);
        this.add(smazat);
        this.add(zpet);
        this.add(sep);
        this.add(mep);
        this.add(upravit);
    }

    private static class Upravit_Hledat implements ActionListener {
        public Upravit_Hledat(){
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Panely.f.dispose();
            System.out.println("UPRAVIT");
            PomocnaOkna p = new PomocnaOkna(n, "Hledat");
            p.upravit();
            p.setVisible(true);
        } 
    }

    private static class Upravit_Zobrazit implements ActionListener {

        public Upravit_Zobrazit() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("UPRAVIT");
            PomocnaOkna p = new PomocnaOkna(n, "Zobrazit");
            p.upravit();
            p.setVisible(true);
            f.dispose();

        }
    }

    private class ListAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kn = new Kniha();
            
            //System.out.println(e.getActionCommand().charAt(0));

            int i = (int) (e.getActionCommand().charAt(0));


            kn = Okno.knihovna.getI(i - 49);

            GridLayout gl = new GridLayout(6, 1, 10, 20);
            f.setLayout(gl);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel jmeno = new JLabel("Autor:   " + kn.getJmeno() + " " + kn.getPrijmeni());
            JLabel titul = new JLabel("Titul:   " + kn.getNazev());
            JLabel rok = new JLabel("Rok vydání:   " + kn.getRok());
            JLabel poznamka = new JLabel("Poznámky:   " + kn.getPoznamka());
            JLabel umisteni = new JLabel("Umístění:   " + kn.getUmisteni());

            /* Tlacitko zpet = new Tlacitko("Zpět");
             zpet.setSize(100, 30);*/
            Tlacitko upravit = new Tlacitko("Upravit");
            upravit.setSize(100, 30);
            upravit.addActionListener(new Upravit_Zobrazit());



            f.add(jmeno);
            f.add(titul);
            f.add(rok);
            f.add(poznamka);
            f.add(umisteni);
            f.add(upravit);
            // f.add(zpet);
            f.setBounds(320, 200, 300, 350);


        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            String s = (e.getItem().toString());
            n = Integer.parseInt(s);
        }
    }

    public class Zpet implements ActionListener { // zpet pro panel zobrazeni

        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.hlavnipanel.setVisible(true);
            Okno.panelodebrat.remove(Okno.list);
            Okno.panelodebrat.add(Okno.list);
            Okno.panelodebrat.setVisible(false);
            Okno.panelhledat.setVisible(false);

            //Okno.panelhledat.remove(Panely.li);
            //Okno.panelhledat.add(PomocnaOkna.li);

        }
    }

    public class Zpet_Hledat implements ActionListener { // zpet pro panel hledani

        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.hlavnipanel.setVisible(true);
            Okno.panelodebrat.remove(Okno.list);
            Okno.panelodebrat.add(Okno.list);
            Okno.panelodebrat.setVisible(false);
            Okno.panelhledat.setVisible(false);
            Okno.panelhledat.removeAll();
            oznaceno = false;
            oznaceno_List = false;

        }
    }

    public class Smazat implements ActionListener { //(smazat v normálním prohlizeni)

        @Override
        public void actionPerformed(ActionEvent e) {


            Okno.knihovna.Odeber(n);

            System.out.println(Okno.knihovna.velikost());
            Okno.pomocna = Okno.knihovna;
            Okno.list.removeAll();

            for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
        }
    }

    public class Smazat_Hledat implements ActionListener { // smazat v hledani (panel hledatú)

        @Override
        public void actionPerformed(ActionEvent e) {

            Kniha kp = new Kniha();


            if (Panely.pocet == Okno.knihovna.velikost()) {

                Okno.knihovna.Odeber(n);
                Okno.pomocna = Okno.knihovna;
                Okno.list.removeAll();

                for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                    Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                }

                Panely.li.removeAll();
                for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                    Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                }

            } else if (Panely.pocet != 0) {
                kp = Panely.kn.getI(n);
                for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                    if (kp.equals(Okno.knihovna.getI(i))) {

                        Okno.knihovna.Odeber(i);
                        Panely.kn.Odeber(n);

                        Okno.list.removeAll();
                        for (int j = 0; j < Okno.knihovna.velikost(); j++) {
                            Okno.list.add((j + 1) + " - " + Okno.knihovna.toStringAutorDilo(j));
                        }

                    }
                }
            } else if (Panely.pocet == 0) {
                for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                    Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                }
            }

            Panely.pocet = Panely.kn.velikost();
            int poc = Panely.kn.velikost();



            Panely.li.removeAll();

            if (poc != 0) {
                for (int i = 0; i < Panely.kn.velikost(); i++) {
                    Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
                }
            } else {
                for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                    Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                    Panely.pocet = Okno.knihovna.velikost();
                    Panely.text.setText(null);
                }
            }

        }
    }

    private class ListAction_Hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kp;

            

            //if (oznaceno_List == false) {

            setSoucastne(getDateTime());
            if (!getSoucastne().equals(getPred())) {
                
                if (Panely.pocet == Okno.knihovna.velikost()) {

                    int i = (int) (e.getActionCommand().charAt(0));
                    System.out.println("vase volba je " + i);

                    //   kp = Okno.knihovna.getI(i - 49);
                    kp = Okno.knihovna.getI(n);

                    GridLayout gl = new GridLayout(6, 1, 10, 20);

                    f.setLayout(gl);
                    f.setVisible(true);
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel jmeno = new JLabel("Autor:   " + kp.getJmeno() + " " + kp.getPrijmeni());
                    JLabel titul = new JLabel("Titul:   " + kp.getNazev());
                    JLabel rok = new JLabel("Rok vydání:   " + kp.getRok());
                    JLabel poznamka = new JLabel("Poznámky:   " + kp.getPoznamka());
                    JLabel umisteni = new JLabel("Umístění:   " + kp.getUmisteni());



                    f.add(jmeno);
                    f.add(titul);
                    f.add(rok);
                    f.add(poznamka);
                    f.add(umisteni);

                    Tlacitko upravit = new Tlacitko("Upravit");
                    upravit.addActionListener(new Upravit_Hledat());
                    f.add(upravit);
                    f.setBounds(320, 200, 300, 350);

                    oznaceno_List = true;
                    setPred(getDateTime());
                } else {

                    int i = (int) (e.getActionCommand().charAt(0) - 49);
                    System.out.println("Vybiras " + i);
                    System.out.println(Panely.kn);
                    kp = Panely.kn.getI(n);

                    GridLayout gl = new GridLayout(6, 1, 10, 20);
                    f.setLayout(gl);
                    f.setVisible(true);
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel jmeno = new JLabel("Autor:   " + kp.getJmeno() + " " + kp.getPrijmeni());
                    JLabel titul = new JLabel("Titul:   " + kp.getNazev());
                    JLabel rok = new JLabel("Rok vydání:   " + kp.getRok());
                    JLabel poznamka = new JLabel("Poznámky:   " + kp.getPoznamka());
                    JLabel umisteni = new JLabel("Umístění:   " + kp.getUmisteni());

                    f.add(jmeno);
                    f.add(titul);
                    f.add(rok);
                    f.add(poznamka);
                    f.add(umisteni);
                    
                    Tlacitko upravit = new Tlacitko("Upravit");
                    upravit.addActionListener(new Upravit_Hledat());
                    f.add(upravit);
                    f.setBounds(320, 200, 300, 350);


                    oznaceno_List = true;
                    setPred(getDateTime());
                }
            }

        }
        // }
    }

    private class ItemAction_Hledat implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            //if (oznaceno == false) {
            String s = (e.getItem().toString());
            if (predchozi != Integer.parseInt(s)) {

                System.out.println("Vybrána kniha číslo: " + s);
                n = Integer.parseInt(s);
                oznaceno = true;
                predchozi = n;
            }
            // }
        }
    }

    private String getDateTime() {
        DateFormat dfFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Date dNow = new Date();
        return dfFormat.format(dNow);
    }
}
