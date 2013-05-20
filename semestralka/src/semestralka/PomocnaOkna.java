package semestralka;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import semestralka.Okno.Hledat;

public class PomocnaOkna extends JFrame {

    private static int n;
    private static int pocet;
    JLabel l1 = new JLabel("Zadejte jméno autora: ");
    private static JTextArea t1 = new JTextArea("", 1, 15);
    JLabel l2 = new JLabel("Zadejte příjmení autora: ");
    private static JTextArea t2 = new JTextArea("", 1, 15);
    JLabel l3 = new JLabel("Zadejte název knihy: ");
    private static JTextArea t3 = new JTextArea("", 1, 15);
    JLabel l4 = new JLabel("Zadejte žánr knihy: ");
    private static JTextArea t4 = new JTextArea("", 1, 15);
    JLabel l5 = new JLabel("Zadejte umístění knihy: ");
    private static JTextArea t5 = new JTextArea("", 1, 15);
    JLabel l6 = new JLabel("Místo pro poznámku ");
    private static JTextArea t6 = new JTextArea("", 1, 15);
    JLabel l7 = new JLabel("Rok vydání knihy ");
    private static JTextArea t7 = new JTextArea("", 1, 15);
    Tlacitko vytvorit = new Tlacitko("Vytvořit");
    Tlacitko zrusit = new Tlacitko("Zrušit");
    NumberFormat f = NumberFormat.getInstance();
    JFormattedTextField numberField = new JFormattedTextField(f);
    private static int index;
    String metoda;
    private String pred, ted;

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

    public String getPred() {
        return pred;
    }

    public void setPred(String pred) {
        this.pred = pred;
    }

    public String getTed() {
        return ted;
    }

    public void setTed(String ted) {
        this.ted = ted;
    }

    void upravit() {
        GridLayout gl = new GridLayout(8, 2, 5, 20);
        this.setResizable(false);
        this.setLayout(gl);

        this.add(getL1());
        this.add(getT1());
        this.add(getL2());
        this.add(getT2());
        this.add(getL3());
        this.add(getT3());
        this.add(getL4());
        this.add(getT4());
        this.add(getL5());
        this.add(getT5());
        this.add(getL6());
        this.add(getT6());
        this.add(getL7());
        this.add(getT7());

        Kniha k = new Kniha();


        if ("Hledat".equals(getMetoda())) {
            if (Panely.getPocet() == Okno.getKnihovna().velikost()) {
                k = Okno.getKnihovna().getI(getIndex());
                getT1().setText(k.getJmeno());
                getT2().setText(k.getPrijmeni());
                getT3().setText(k.getNazev());
                getT4().setText(k.getZanr());
                getT5().setText(k.getUmisteni());
                getT6().setText(k.getPoznamka());
                getT7().setText(k.getRok());

            } else {
                System.out.println(Panely.getKn());
                k = Panely.getKn().getI(getIndex());
                getT1().setText(k.getJmeno());
                getT2().setText(k.getPrijmeni());
                getT3().setText(k.getNazev());
                getT4().setText(k.getZanr());
                getT5().setText(k.getUmisteni());
                getT6().setText(k.getPoznamka());
                getT7().setText(k.getRok());
            }

        }
        if ("Zobrazit".equals(getMetoda())) {
            k = Okno.getKnihovna().getI(getIndex());
            getT1().setText(k.getJmeno());
            getT2().setText(k.getPrijmeni());
            getT3().setText(k.getNazev());
            getT4().setText(k.getZanr());
            getT5().setText(k.getUmisteni());
            getT6().setText(k.getPoznamka());
            getT7().setText(k.getRok());
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
        /*
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
         this.add(t7);*/
        this.add(getL1());
        this.add(getT1());
        this.add(getL2());
        this.add(getT2());
        this.add(getL3());
        this.add(getT3());
        this.add(getL4());
        this.add(getT4());
        this.add(getL5());
        this.add(getT5());
        this.add(getL6());
        this.add(getT6());
        this.add(getL7());
        this.add(getT7());

        add(getVytvorit());
        add(getZrusit());

        getVytvorit().addActionListener(new Vytvorit());
        getZrusit().addActionListener(new Zrusit());

        this.pack();
    }

    private class Hotovo_hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Kniha k = new Kniha();
            int q = 0;
            k.prectiJmeno(getT1().getText());
            k.prectiPrijmeni(getT2().getText());
            k.prectiNazev(getT3().getText());
            k.prectiZanr(getT4().getText());
            k.prectiUmisteni(getT5().getText());
            k.prectiPoznamka(getT6().getText());
            k.prectiRok(getT7().getText());


            if (Panely.getPocet() == Okno.getKnihovna().velikost()) { // kdyz je vyhledavani stejne jako cela knihovna (nezacalo se hledat)

                System.out.println("Stejna");
                Okno.getKnihovna().UpravI(k, getIndex());
                Panely.getLi().removeAll();

                for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                }


            } else { // uz se zacalo hledat
                Kniha p = new Kniha();
                if (Panely.getPocet() != 0) { // kdyz pocet neni rovny nule
                    p = Panely.getKn().getI(getIndex());
                    for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                        if (p.equals(Okno.getKnihovna().getI(i))) {
                            Okno.getKnihovna().UpravI(k, i);
                        }
                    }
                } else if (Panely.getPocet() == 0) {
                    for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                        Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                    }
                }

                Panely.setPocet(Panely.getKn().velikost());
                int poc = Panely.getKn().velikost();
                System.out.println("Velikost " + poc);
                Panely.getLi().removeAll();

                if (poc != 0) {
                    for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                        Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                        Panely.setKn(Okno.getKnihovna());

                    }
                } else {
                    for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                        Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                        Panely.setPocet(Okno.getKnihovna().velikost());
                        Panely.getText().setText(null);
                    }
                }
            }
            Okno.getList().removeAll();

            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
            dispose();
        }
    }

    private class Vytvorit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            Kniha k = new Kniha();

            k.prectiJmeno(getT1().getText());
            k.prectiPrijmeni(getT2().getText());
            k.prectiNazev(getT3().getText());
            k.prectiZanr(getT4().getText());
            k.prectiUmisteni(getT5().getText());
            k.prectiPoznamka(getT6().getText());
            k.prectiRok(getT7().getText());

            Okno.getKnihovna().pridej(k);
            Okno.setPomocna(Okno.getKnihovna());
            Okno.getList().removeAll();

            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
            dispose();
        }
    }

    private class Zrusit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class ListAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kp;

            JFrame l = new JFrame("Kniha");

            setTed(getDateTime());

            // if (!getTed().equals(getPred())) {

            if (Panely.getPocet() == Okno.getKnihovna().velikost()) {

                int i = (int) (e.getActionCommand().charAt(0));


                kp = Okno.getKnihovna().getI(i - 49);

                GridLayout gl = new GridLayout(5, 1, 10, 20);
                l.setLayout(gl);
                l.setVisible(true);
                l.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JLabel jmeno = new JLabel("Autor:   " + kp.getJmeno() + " " + kp.getPrijmeni());
                JLabel titul = new JLabel("Titul:   " + kp.getNazev());
                JLabel rok = new JLabel("Rok vydání:   " + kp.getRok());
                JLabel poznamka = new JLabel("Poznámky:   " + kp.getPoznamka());
                JLabel umisteni = new JLabel("Umístění:   " + kp.getUmisteni());

                l.add(jmeno);
                l.add(titul);
                l.add(rok);
                l.add(poznamka);
                l.add(umisteni);

                l.setBounds(320, 200, 300, 200);

                setPred(getDateTime());

            } else {

                int i = (int) (e.getActionCommand().charAt(0));

                kp = Panely.getKn().getI(i - 49);

                GridLayout gl = new GridLayout(5, 1, 10, 20);
                l.setLayout(gl);
                l.setVisible(true);
                l.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JLabel jmeno = new JLabel("Autor:   " + kp.getJmeno() + " " + kp.getPrijmeni());
                JLabel titul = new JLabel("Titul:   " + kp.getNazev());
                JLabel rok = new JLabel("Rok vydání:   " + kp.getRok());
                JLabel poznamka = new JLabel("Poznámky:   " + kp.getPoznamka());
                JLabel umisteni = new JLabel("Umístění:   " + kp.getUmisteni());

                l.add(jmeno);
                l.add(titul);
                l.add(rok);
                l.add(poznamka);
                l.add(umisteni);

                l.setBounds(320, 200, 300, 200);

                setPred(getDateTime());
                //  }

            }
        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            String s = (e.getItem().toString());
            System.out.println("Vybrána kniha číslo: " + s);
            setN(Integer.parseInt(s));
        }
    }

    private String getDateTime() {
        DateFormat dfFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Date dNow = new Date();
        return dfFormat.format(dNow);
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        PomocnaOkna.n = n;
    }

    public static int getPocet() {
        return pocet;
    }

    public static void setPocet(int pocet) {
        PomocnaOkna.pocet = pocet;
    }

    public JLabel getL1() {
        return l1;
    }

    public void setL1(JLabel l1) {
        this.l1 = l1;
    }

    public static JTextArea getT1() {
        return t1;
    }

    public static void setT1(JTextArea t1) {
        PomocnaOkna.t1 = t1;
    }

    public JLabel getL2() {
        return l2;
    }

    public void setL2(JLabel l2) {
        this.l2 = l2;
    }

    public static JTextArea getT2() {
        return t2;
    }

    public static void setT2(JTextArea t2) {
        PomocnaOkna.t2 = t2;
    }

    public JLabel getL3() {
        return l3;
    }

    public void setL3(JLabel l3) {
        this.l3 = l3;
    }

    public static JTextArea getT3() {
        return t3;
    }

    public static void setT3(JTextArea t3) {
        PomocnaOkna.t3 = t3;
    }

    public JLabel getL4() {
        return l4;
    }

    public void setL4(JLabel l4) {
        this.l4 = l4;
    }

    public static JTextArea getT4() {
        return t4;
    }

    public static void setT4(JTextArea t4) {
        PomocnaOkna.t4 = t4;
    }

    public JLabel getL5() {
        return l5;
    }

    public void setL5(JLabel l5) {
        this.l5 = l5;
    }

    public static JTextArea getT5() {
        return t5;
    }

    public static void setT5(JTextArea t5) {
        PomocnaOkna.t5 = t5;
    }

    public JLabel getL6() {
        return l6;
    }

    public void setL6(JLabel l6) {
        this.l6 = l6;
    }

    public static JTextArea getT6() {
        return t6;
    }

    public static void setT6(JTextArea t6) {
        PomocnaOkna.t6 = t6;
    }

    public JLabel getL7() {
        return l7;
    }

    public void setL7(JLabel l7) {
        this.l7 = l7;
    }

    public static JTextArea getT7() {
        return t7;
    }

    public static void setT7(JTextArea t7) {
        PomocnaOkna.t7 = t7;
    }

    public Tlacitko getVytvorit() {
        return vytvorit;
    }

    public void setVytvorit(Tlacitko vytvorit) {
        this.vytvorit = vytvorit;
    }

    public Tlacitko getZrusit() {
        return zrusit;
    }

    public void setZrusit(Tlacitko zrusit) {
        this.zrusit = zrusit;
    }

    public NumberFormat getF() {
        return f;
    }

    public void setF(NumberFormat f) {
        this.f = f;
    }

    public JFormattedTextField getNumberField() {
        return numberField;
    }

    public void setNumberField(JFormattedTextField numberField) {
        this.numberField = numberField;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        PomocnaOkna.index = index;
    }

    public String getMetoda() {
        return metoda;
    }

    public void setMetoda(String metoda) {
        this.metoda = metoda;
    }
}
