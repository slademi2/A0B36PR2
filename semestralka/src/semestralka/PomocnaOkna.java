package semestralka;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import semestralka.Okno.Hledat;
import static semestralka.Panely.n;

public class PomocnaOkna extends JFrame {

    /*  // nahrazeno v PANELy
     * static int pocet;                     
     static Knihovna kn = new Knihovna();
     static JTextField text = new JTextField();
     private int n;
     static List li = new List(Okno.knihovna.velikost());*/
    private int n;
    private int pocet;
    JLabel l1 = new JLabel("Zadejte jméno autora: ");
    static JTextArea t1 = new JTextArea("", 1, 15);
    JLabel l2 = new JLabel("Zadejte příjmení autora: ");
    static JTextArea t2 = new JTextArea("", 1, 15);
    JLabel l3 = new JLabel("Zadejte název knihy: ");
    static JTextArea t3 = new JTextArea("", 1, 15);
    JLabel l4 = new JLabel("Zadejte žánr knihy: ");
    static JTextArea t4 = new JTextArea("", 1, 15);
    JLabel l5 = new JLabel("Zadejte umístění knihy: ");
    static JTextArea t5 = new JTextArea("", 1, 15);
    JLabel l6 = new JLabel("Místo pro poznámku ");
    static JTextArea t6 = new JTextArea("", 1, 15);
    JLabel l7 = new JLabel("Rok vydání knihy ");
    static JTextArea t7 = new JTextArea("", 1, 15);
    Tlacitko vytvorit = new Tlacitko("Vytvořit");
    Tlacitko zrusit = new Tlacitko("Zrušit");
    NumberFormat f = NumberFormat.getInstance();
    JFormattedTextField numberField = new JFormattedTextField(f);
    static int index;
    String metoda;

    public PomocnaOkna() {



        this.setVisible(true);
        this.setBounds(320, 200, 300, 500);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public PomocnaOkna(int index, String metoda) {
        this.index = index;
        this.metoda = metoda;
        this.setBounds(320, 200, 300, 500);
        this.setVisible(true);
    }

    void upravit() {
        GridLayout gl = new GridLayout(8, 2, 5, 20);
        
        
        this.setResizable(false);
        this.setLayout(gl);

        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(l3);
        this.add(t3);
        this.add(l4);
        this.add(t4);
        this.add(l5);
        this.add(t5);
        this.add(l6);
        this.add(t6);
        this.add(l7);
        this.add(t7);

        Kniha k = new Kniha();

        if ("Hledat".equals(metoda)) {
            if (Panely.pocet == Okno.knihovna.velikost()) {
                k = Okno.knihovna.getI(index);
                t1.setText(k.getJmeno());
                t2.setText(k.getPrijmeni());
                t3.setText(k.getNazev());
                t4.setText(k.getZanr());
                t5.setText(k.getUmisteni());
                t6.setText(k.getPoznamka());
                t7.setText(k.getRok());

            } else {
                System.out.println(Panely.kn);
                k = Panely.kn.getI(index);
                t1.setText(k.getJmeno());
                t2.setText(k.getPrijmeni());
                t3.setText(k.getNazev());
                t4.setText(k.getZanr());
                t5.setText(k.getUmisteni());
                t6.setText(k.getPoznamka());
                t7.setText(k.getRok());
            }
        }
        if("Zobrazit".equals(metoda)){
            k = Okno.knihovna.getI(index);
                t1.setText(k.getJmeno());
                t2.setText(k.getPrijmeni());
                t3.setText(k.getNazev());
                t4.setText(k.getZanr());
                t5.setText(k.getUmisteni());
                t6.setText(k.getPoznamka());
                t7.setText(k.getRok());
        }
        Tlacitko hotovo = new Tlacitko("Hotovo");
        hotovo.addActionListener(new Hotovo_hledat());
        Tlacitko konec = new Tlacitko("Zrusit");
        konec.addActionListener(new Zrusit());

        this.add(hotovo);
        this.add(konec);
        this.pack();

    }

    void novy() {
        this.setTitle("Nová Kniha");
        GridLayout gl = new GridLayout(8, 2, 5, 20);

        this.setResizable(false);
        this.setLayout(gl);

        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(l3);
        this.add(t3);
        this.add(l4);
        this.add(t4);
        this.add(l5);
        this.add(t5);
        this.add(l6);
        this.add(t6);
        this.add(l7);
        this.add(t7);


        NumberFormat f = NumberFormat.getInstance();

        f.setGroupingUsed(false);

        JFormattedTextField numberField = new JFormattedTextField(f);

        // this.add(numberField);

        add(vytvorit);
        add(zrusit);

        vytvorit.addActionListener(new Vytvorit());
        zrusit.addActionListener(new Zrusit());

        this.pack();
    }

    private class Hotovo_hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Kniha k = new Kniha();
            int q = 0;
            k.prectiJmeno(t1.getText());
            k.prectiPrijmeni(t2.getText());
            k.prectiNazev(t3.getText());
            k.prectiZanr(t4.getText());
            k.prectiUmisteni(t5.getText());
            k.prectiPoznamka(t6.getText());

            k.prectiRok(t7.getText());



            // Okno.knihovna.pridej(k);
            // Okno.pomocna = Okno.knihovna;
            // Okno.list.removeAll();
            // Panely.li.removeAll();

            if (Panely.pocet == Okno.knihovna.velikost()) { // kdyz je vyhledavani stejne jako cela knihovna (nezacalo se hledat)

                System.out.println("Stejna");
                Okno.knihovna.UpravI(k, index);
                Panely.li.removeAll();

                for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                    Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                }


            } else { // uz se zacalo hledat
                Kniha p = new Kniha();
                if (Panely.pocet != 0) { // kdyz pocet neni rovny nule
                    p = Panely.kn.getI(index);
                    for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                        if (p.equals(Okno.knihovna.getI(i))) {

                            Okno.knihovna.UpravI(k, i);
                            //Panely.kn.Odeber(n);

                        }
                    }
                } else if (Panely.pocet == 0) {
                    for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                        Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                    }
                }

                Panely.pocet = Panely.kn.velikost();
                int poc = Panely.kn.velikost();
                System.out.println("Velikost " + poc);
                Panely.li.removeAll();

                if (poc != 0) {
                    for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                        Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                        Panely.kn = Okno.knihovna;
                        
                    }
                } else {
                    for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                        Panely.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
                        Panely.pocet = Okno.knihovna.velikost();
                        Panely.text.setText(null);
                    }
                }
                // Panely.kn.UpravI(k, index);
            }
            Okno.list.removeAll();

            for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
            dispose();
        }
    }

    private class Vytvorit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            Kniha k = new Kniha();

            k.prectiJmeno(t1.getText());
            k.prectiPrijmeni(t2.getText());
            k.prectiNazev(t3.getText());
            k.prectiZanr(t4.getText());
            k.prectiUmisteni(t5.getText());
            k.prectiPoznamka(t6.getText());

            k.prectiRok(t7.getText());

            // k.prectiRok(Integer.parseInt(numberField.getText()));

            Okno.knihovna.pridej(k);
            Okno.pomocna = Okno.knihovna;
            Okno.list.removeAll();

            for (int i = 0; i < Okno.knihovna.velikost(); i++) {
                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }

            dispose();

            // }catch (InvalidYearNumberException ex) {


        }
    }

    private class Zrusit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    void zobrazit() {
       
        Okno.list.removeAll();
        for (int i = 0; i < Okno.knihovna.velikost(); i++) {
            Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
        }
        add(Okno.list);
        Okno.list.addActionListener(new ListAction());
        Okno.list.addItemListener(new ItemAction());
    }
 // nepotrebna metoda asi(nahrazeno panel_vyhledat)
    private class ListAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kp;

            JFrame f = new JFrame("Kniha");
            System.out.println("PomocnaOkna");

            if (Panely.pocet == Okno.knihovna.velikost()) {

                int i = (int) (e.getActionCommand().charAt(0));
                System.out.println("vase volba je " + i);

                kp = Okno.knihovna.getI(i - 49);

                GridLayout gl = new GridLayout(5, 1, 10, 20);
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

                f.setBounds(320, 200, 300, 200);

                n = 1;
            } else {

                int i = (int) (e.getActionCommand().charAt(0));

                kp = Panely.kn.getI(i - 49);

                GridLayout gl = new GridLayout(5, 1, 10, 20);
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

                f.setBounds(320, 200, 300, 200);

                n = 1;
            }

        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            //PomocnaOkna k = new PomocnaOkna();


            String s = (e.getItem().toString());
            System.out.println("Vybrána kniha číslo: " + s);
            n = Integer.parseInt(s);


        }
    }
    /*
     public class Zpet implements ActionListener {

     @Override
     public void actionPerformed(ActionEvent e) {
            
     PomocnaOkna.li.removeAll();
            
     PomocnaOkna.this.dispose();
     }
     }

     public class Smazat implements ActionListener {

     @Override
     public void actionPerformed(ActionEvent e) {

     Kniha kp = new Kniha();
            
            
     if (PomocnaOkna.pocet == Okno.knihovna.velikost()) {

     Okno.knihovna.Odeber(n);
     Okno.pomocna = Okno.knihovna;
     Okno.list.removeAll();

     for (int i = 0; i < Okno.knihovna.velikost(); i++) {
     Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
     }

     PomocnaOkna.li.removeAll();
     for (int i = 0; i < Okno.knihovna.velikost(); i++) {
     PomocnaOkna.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
     }

     } else if(PomocnaOkna.pocet != 0) {
     kp = PomocnaOkna.kn.getI(n);
     for (int i = 0; i < Okno.knihovna.velikost(); i++) {
     if (kp.equals(Okno.knihovna.getI(i))) {
                        
     Okno.knihovna.Odeber(i);
     PomocnaOkna.kn.Odeber(n);
                        
     Okno.list.removeAll();
     for (int j = 0; j < Okno.knihovna.velikost(); j++) {
     Okno.list.add((j + 1) + " - " + Okno.knihovna.toStringAutorDilo(j));
     }

     }
     }
     }
     else if(PomocnaOkna.pocet == 0){
     for (int i = 0; i < Okno.knihovna.velikost(); i++) {
     PomocnaOkna.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
     }
     }
          
     PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
     int poc = PomocnaOkna.kn.velikost();

            

     PomocnaOkna.li.removeAll();
            
     if (poc != 0) {
     for (int i = 0; i < PomocnaOkna.kn.velikost(); i++) {
     PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
     }
     } else {
     for (int i = 0; i < Okno.knihovna.velikost(); i++) {
     PomocnaOkna.li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
     PomocnaOkna.pocet = Okno.knihovna.velikost();
     PomocnaOkna.text.setText(null);
     }
     }
            
     }
     }*/
}
