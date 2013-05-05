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

public class PomocnaOkna extends JFrame {

    static int pocet;
    static JTextField text = new JTextField();
    static Knihovna kn = new Knihovna();
    static List li = new List(Okno.knihovna.velikost());
    JLabel l1 = new JLabel("Zadejte jméno autora: ");
    JTextArea t1 = new JTextArea("", 1, 15);
    JLabel l2 = new JLabel("Zadejte příjmení autora: ");
    JTextArea t2 = new JTextArea("", 1, 15);
    JLabel l3 = new JLabel("Zadejte název knihy: ");
    JTextArea t3 = new JTextArea("", 1, 15);
    JLabel l4 = new JLabel("Zadejte žánr knihy: ");
    JTextArea t4 = new JTextArea("", 1, 15);
    JLabel l5 = new JLabel("Zadejte umístění knihy: ");
    JTextArea t5 = new JTextArea("", 1, 15);
    JLabel l6 = new JLabel("Místo pro poznámku ");
    JTextArea t6 = new JTextArea("", 1, 15);
    JLabel l7 = new JLabel("Rok vydání knihy ");
    JTextArea t7 = new JTextArea("", 1, 15);
    Tlacitko vytvorit = new Tlacitko("Vytvořit");
    Tlacitko zrusit = new Tlacitko("Zrušit");
    NumberFormat f = NumberFormat.getInstance();
    JFormattedTextField numberField = new JFormattedTextField(f);
    private int n;

    public PomocnaOkna() {



        this.setVisible(true);
        this.setBounds(320, 200, 300, 500);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        /*Okno.zobrlist.removeAll();
         for (int i = 0; i < Okno.knihovna.velikost(); i++) {
         Okno.zobrlist.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
         }


         add(Okno.zobrlist);
         Okno.zobrlist.addActionListener(new ListAction());
         Okno.zobrlist.addItemListener(new ItemAction());
         this.setBounds(320, 200, 300, 200);
         }*/
        Okno.list.removeAll();
        for (int i = 0; i < Okno.knihovna.velikost(); i++) {
            Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
        }
        add(Okno.list);
        Okno.list.addActionListener(new ListAction());
        Okno.list.addItemListener(new ItemAction());
    }

    void hledat() {
               
        li.removeAll();
        
        int vyska = 455;
        int sirka = 340;
        this.setSize(vyska, sirka);
        this.setResizable(false);
        this.setTitle("Vyhledávání knih: ");

        for (int i = 0; i < Okno.knihovna.velikost(); i++) {
            li.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
        }


        li.setBounds(2, 2, 440, 180);

        li.addActionListener(new ListAction());
        li.addItemListener(new ItemAction());
        this.add(li);
        pocet = li.getItemCount();
        System.out.println("pocet knih v listu je : " + pocet);

        text = new JTextField();
        text.setBounds(200, 185, 205, 30);
        text.setEditable(true);


        ObsluhaHledani ob = new ObsluhaHledani();

        Tlacitko zpet = new Tlacitko("Zpět");
        zpet.setBounds(340, 270, 100, 30);
        zpet.addActionListener(new Zpet());

        Tlacitko smazat = new Tlacitko("Smazat");
        smazat.setBounds(5, 270, 100, 30);
        smazat.addActionListener(new Smazat());

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



    }

    private class ListAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kp;
            
            JFrame f = new JFrame("Kniha");
            System.out.println("PomocnaOkna");

            if (PomocnaOkna.pocet == Okno.knihovna.velikost()) {

                int i = (int) (e.getActionCommand().charAt(0));
                

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
                
                n=1;
            } else {

                int i = (int) (e.getActionCommand().charAt(0));
                
                kp = PomocnaOkna.kn.getI(i - 49);

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
                
                n=1;
            }
          
        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            PomocnaOkna k = new PomocnaOkna();
            
            
            String s = (e.getItem().toString());
            System.out.println("Vybrána kniha číslo: " + s);
            n = Integer.parseInt(s);
            

        }
    }

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
    }
}
