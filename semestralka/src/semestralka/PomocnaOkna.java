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

    JLabel l1 = new JLabel("Zadejte jméno autora: ");
    JTextArea t1 = new JTextArea("Jméno", 1, 15);
    JLabel l2 = new JLabel("Zadejte příjmení autora: ");
    JTextArea t2 = new JTextArea("Příjmení", 1, 15);
    JLabel l3 = new JLabel("Zadejte název knihy: ");
    JTextArea t3 = new JTextArea("název", 1, 15);
    JLabel l4 = new JLabel("Zadejte žánr knihy: ");
    JTextArea t4 = new JTextArea("žánr", 1, 15);
    JLabel l5 = new JLabel("Zadejte umístění knihy: ");
    JTextArea t5 = new JTextArea("umístění: ", 1, 15);
    JLabel l6 = new JLabel("Místo pro poznámku ");
    JTextArea t6 = new JTextArea(" ", 1, 15);
    JLabel l7 = new JLabel("Rok vydání knihy ");
    JTextArea t7 = new JTextArea(" ", 1, 15);
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

        for (int i = 0; i < Okno.knihovna.velikost(); i++) {
            Okno.zobrlist.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
        }


        add(Okno.zobrlist);
        Okno.zobrlist.addActionListener(new ListAction());
        Okno.zobrlist.addItemListener(new ItemAction());
        this.setBounds(320, 200, 300, 200);
    }

    void hledat() {
        int vyska = 450;
        int sirka = 280;
        this.setSize(vyska, sirka);
        this.setTitle("Vyhledávání knih: ");

        JTextField text = new JTextField();
        text.setBounds(115, 185, 205, 30);
        text.setEditable(true);

        Tlacitko zpet = new Tlacitko("Zpět");
        zpet.setBounds(325, 185, 100, 30);
        zpet.addActionListener(new Zpet());

        Tlacitko smazat = new Tlacitko("Smazat");
        smazat.setBounds(10, 185, 100, 30);
        smazat.addActionListener(new Smazat());

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 181, 450, 10);


       /* for (int i = 0; i < Okno.knihovna.velikost(); i++) {

            Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
*/
        
            this.add(text);
            this.add(smazat);
            this.add(zpet);
            this.add(sep);
            this.add(Okno.list);

    }
    

    private class ListAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kn = new Kniha();
            JFrame f = new JFrame("Kniha");
            //System.out.println(e.getActionCommand().charAt(0));


            int i = (int) (e.getActionCommand().charAt(0));
            System.out.println(e.getSource());

            kn = Okno.knihovna.getI(i - 49);

            GridLayout gl = new GridLayout(5, 1, 10, 20);
            f.setLayout(gl);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel jmeno = new JLabel("Autor:   " + kn.getJmeno() + " " + kn.getPrijmeni());
            JLabel titul = new JLabel("Titul:   " + kn.getNazev());
            JLabel rok = new JLabel("Rok vydání:   " + kn.getRok());
            JLabel poznamka = new JLabel("Poznámky:   " + kn.getPoznamka());
            JLabel umisteni = new JLabel("Umístění:   " + kn.getUmisteni());

            f.add(jmeno);
            f.add(titul);
            f.add(rok);
            f.add(poznamka);
            f.add(umisteni);

            f.setBounds(320, 200, 300, 200);
            f.setAlwaysOnTop(true);


        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            JFrame f = new JFrame();
            f.setBounds(200, 200, 100, 100);
            JLabel jmeno = new JLabel("e.toString()");
            add(jmeno);
        }
    }

    public class Zpet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PomocnaOkna.this.dispose();
        }
    }

    public class Smazat implements ActionListener {

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
}
