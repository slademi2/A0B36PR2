package semestralka;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;


/*
 *  Tato třída je potomken JPanel
 *  instanci teto tridy jsou Panely (celkem jsou vytvoreny 3)
 */
public class Panely extends JPanel {

    private String pred;
    private String soucastne;
    static private int pocet;
    private static Knihovna kn = new Knihovna();
    private static JTextField text = new JTextField();
    private static int n;
    private static List li = new List(Okno.getKnihovna().velikost());
    private int vyska = 450;
    private int sirka = 280;
    private boolean oznaceno = false;
    private boolean oznaceno_List = false;
    private int predchozi;
    private static JFrame f = new JFrame("Kniha");

    public Panely() {
        this.setSize(vyska, sirka);
        this.setVisible(true);
        this.setLayout(null);
    }

    void odebrat() {

        setVyska(455);
        setSirka(340);
        this.setSize(getVyska(), getSirka());

        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {

            Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));

        }

        MujChoice choc = new MujChoice(); // trideni podle ceho zobrazit
        choc.setBounds(208, 245, 110, 30);



        Okno.getList().addActionListener(new ListAction());
        Okno.getList().addItemListener(new ItemAction());
        Okno.getList().setVisible(true);
        Okno.getList().setBounds(5, 2, 435, 240);

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
        this.add(Okno.getList());
        this.add(upravit);


    }
    /*
     * zobrazit, spatne pojmenovani.
     * obsahuje volani razeni, ktere je uskutecnovano ve tride MujChoice.java
     */

    void hledat() {
        Panely.getLi().removeAll();
        this.setVisible(true);
        setVyska(455);
        setSirka(340);
        this.setSize(getVyska(), getSirka());

        for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
            Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
        }
        Panely.getLi().setBounds(2, 2, 440, 180);

        Panely.getLi().addActionListener(new ListAction_Hledat());
        Panely.getLi().addItemListener(new ItemAction_Hledat());
        this.add(Panely.getLi());
        setPocet(Panely.getLi().getItemCount());
        setText(new JTextField());
        getText().setBounds(200, 185, 205, 30);
        getText().setEditable(true);


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

        this.add(getText());
        this.add(smazat);
        this.add(zpet);
        this.add(sep);
        this.add(mep);
        this.add(upravit);
    }
    /*
     * vola hledani, ktere je uskutecnovano pomoci tridy ObsluhaHledani,java
     */

    private static class Upravit_Hledat implements ActionListener {

        public Upravit_Hledat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("UPRAVIT");
            PomocnaOkna p = new PomocnaOkna(getN(), "Hledat");
            p.upravit();
            p.setVisible(true);
            getF().dispose();
        }
    }
    /*
     * actionlistener tlacitka upravit pro pannel Hledani
     */

    private static class Upravit_Zobrazit implements ActionListener {

        public Upravit_Zobrazit() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            PomocnaOkna p = new PomocnaOkna(getN(), "Zobrazit");
            p.upravit();
            p.setVisible(true);
            getF().dispose();

        }
    }
    /*
     * actipnlistener tlacitka upravit pro panel zobrazit
     */

    private class ListAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Kniha kl = new Kniha();
            getF().setResizable(false);
            JFrame oki = new JFrame();
            oki.setResizable(false);
            int i = (int) (e.getActionCommand().charAt(0));

            kl = Okno.getKnihovna().getI(i - 49);

            GridLayout gl = new GridLayout(6, 1, 10, 20);
            oki.setLayout(gl);
            oki.setVisible(true);
            oki.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel jmeno = new JLabel("Autor:   " + kl.getJmeno() + " " + kl.getPrijmeni());
            JLabel titul = new JLabel("Titul:   " + kl.getNazev());
            JLabel rok = new JLabel("Rok vydání:   " + kl.getRok());
            JLabel poznamka = new JLabel("Poznámky:   " + kl.getPoznamka());
            JLabel umisteni = new JLabel("Umístění:   " + kl.getUmisteni());

            Tlacitko upravit = new Tlacitko("Upravit");
            upravit.setSize(100, 30);
            upravit.addActionListener(new Upravit_Zobrazit());

            oki.add(jmeno);
            oki.add(titul);
            oki.add(rok);
            oki.add(poznamka);
            oki.add(umisteni);
            oki.add(upravit);

            oki.setBounds(320, 200, 300, 350);
        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            String s = (e.getItem().toString());
            setN(Integer.parseInt(s));
        }
    }

    public class Zpet implements ActionListener { // zpet pro panel zobrazeni

        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.getHlavnipanel().setVisible(true);
            Okno.getPanelodebrat().remove(Okno.getList());
            Okno.getPanelodebrat().add(Okno.getList());
            Okno.getPanelodebrat().setVisible(false);
            Okno.getPanelhledat().setVisible(false);
        }
    }
    /*
     * actionlistener zpet pro panel zobrazeni
     */

    public class Zpet_Hledat implements ActionListener { // zpet pro panel hledani

        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.getHlavnipanel().setVisible(true);
            Okno.getPanelodebrat().remove(Okno.getList());
            Okno.getPanelodebrat().add(Okno.getList());
            Okno.getPanelodebrat().setVisible(false);
            Okno.getPanelhledat().setVisible(false);
            Okno.getPanelhledat().removeAll();
            //oznaceno = false;
            //oznaceno_List = false;

        }
    }
    /*
     * zpet pro panel hledani
     */

    public class Smazat implements ActionListener { //(smazat v normálním prohlizeni)

        @Override
        public void actionPerformed(ActionEvent e) {


            Okno.getKnihovna().Odeber(getN());

            System.out.println(Okno.getKnihovna().velikost());
            Okno.setPomocna(Okno.getKnihovna());
            Okno.getList().removeAll();

            for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
            }
        }
    }
    /*
     * smazat, v panelu prohlizeni
     */

    public class Smazat_Hledat implements ActionListener { // smazat v hledani (panel hledatú)

        @Override
        public void actionPerformed(ActionEvent e) {

            Kniha kp = new Kniha();


            if (Panely.getPocet() == Okno.getKnihovna().velikost()) {

                Okno.getKnihovna().Odeber(getN());
                Okno.setPomocna(Okno.getKnihovna());
                Okno.getList().removeAll();

                for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                    Okno.getList().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                }

                Panely.getLi().removeAll();
                for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                }

            } else if (Panely.getPocet() != 0) {
                kp = Panely.getKn().getI(getN());
                for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                    if (kp.equals(Okno.getKnihovna().getI(i))) {

                        Okno.getKnihovna().Odeber(i);
                        Panely.getKn().Odeber(getN());

                        Okno.getList().removeAll();
                        for (int j = 0; j < Okno.getKnihovna().velikost(); j++) {
                            Okno.getList().add((j + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(j));
                        }

                    }
                }
            } else if (Panely.getPocet() == 0) {
                for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                }
            }

            Panely.setPocet(Panely.getKn().velikost());
            int poc = Panely.getKn().velikost();



            Panely.getLi().removeAll();

            if (poc != 0) {
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
            } else {
                for (int i = 0; i < Okno.getKnihovna().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Okno.getKnihovna().toStringAutorDilo(i));
                    Panely.setPocet(Okno.getKnihovna().velikost());
                    Panely.getText().setText(null);
                }
            }

        }
    }
    /*
     * zmazat v panelu hledani
     */

    private class ListAction_Hledat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Kniha kp;
            getF().setResizable(false);
            //JFrame k = new JFrame();
            JFrame ok = new JFrame();
            ok.setResizable(false);
            setSoucastne(getDateTime());
            if (!getSoucastne().equals(getPred())) {

                if (Panely.getPocet() == Okno.getKnihovna().velikost()) {


                    kp = Okno.getKnihovna().getI(getN());

                    GridLayout gl = new GridLayout(6, 1, 10, 20);

                    ok.setLayout(gl);
                    ok.setVisible(true);
                    ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel jmeno = new JLabel("Autor:   " + kp.getJmeno() + " " + kp.getPrijmeni());
                    JLabel titul = new JLabel("Titul:   " + kp.getNazev());
                    JLabel rok = new JLabel("Rok vydání:   " + kp.getRok());
                    JLabel poznamka = new JLabel("Poznámky:   " + kp.getPoznamka());
                    JLabel umisteni = new JLabel("Umístění:   " + kp.getUmisteni());

                    ok.add(jmeno);
                    ok.add(titul);
                    ok.add(rok);
                    ok.add(poznamka);
                    ok.add(umisteni);

                    Tlacitko upravit = new Tlacitko("Upravit");
                    upravit.addActionListener(new Upravit_Hledat());
                    ok.add(upravit);
                    ok.setBounds(320, 200, 300, 350);


                    //
                    setPred(getDateTime());
                } else {


                    kp = Panely.getKn().getI(getN());

                    GridLayout gl = new GridLayout(6, 1, 10, 20);
                    ok.setLayout(gl);
                    ok.setVisible(true);
                    ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel jmeno = new JLabel("Autor:   " + kp.getJmeno() + " " + kp.getPrijmeni());
                    JLabel titul = new JLabel("Titul:   " + kp.getNazev());
                    JLabel rok = new JLabel("Rok vydání:   " + kp.getRok());
                    JLabel poznamka = new JLabel("Poznámky:   " + kp.getPoznamka());
                    JLabel umisteni = new JLabel("Umístění:   " + kp.getUmisteni());

                    ok.add(jmeno);
                    ok.add(titul);
                    ok.add(rok);
                    ok.add(poznamka);
                    ok.add(umisteni);

                    Tlacitko upravit = new Tlacitko("Upravit");
                    upravit.addActionListener(new Upravit_Hledat());
                    ok.add(upravit);
                    ok.setBounds(320, 200, 300, 350);

                    setPred(getDateTime());
                    // setF(k);
                    // }
                }
                setF(ok);

            }

        }
    }

    private class ItemAction_Hledat implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            String s = (e.getItem().toString());
            setN(Integer.parseInt(s));

        }
    }
    
    
    /*
     * Gettery a Settery
     * 
     */
    

    public static int getPocet() {
        return pocet;
    }

    public static void setPocet(int pocet) {
        Panely.pocet = pocet;
    }

    public static Knihovna getKn() {
        return kn;
    }

    public static void setKn(Knihovna kn) {
        Panely.kn = kn;
    }

    public static JTextField getText() {
        return text;
    }

    public static void setText(JTextField text) {
        Panely.text = text;
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
        Panely.n = n;
    }

    public static List getLi() {
        return li;
    }

    public static void setLi(List li) {
        Panely.li = li;
    }

    public int getVyska() {
        return vyska;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
    }

    public int getSirka() {
        return sirka;
    }

    public void setSirka(int sirka) {
        this.sirka = sirka;
    }

    public boolean isOznaceno() {
        return oznaceno;
    }

    public void setOznaceno(boolean oznaceno) {
        this.oznaceno = oznaceno;
    }

    public boolean isOznaceno_List() {
        return oznaceno_List;
    }

    public void setOznaceno_List(boolean oznaceno_List) {
        this.oznaceno_List = oznaceno_List;
    }

    public int getPredchozi() {
        return predchozi;
    }

    public void setPredchozi(int predchozi) {
        this.predchozi = predchozi;
    }

    public static JFrame getF() {
        return f;
    }

    public static void setF(JFrame f) {
        Panely.f = f;
    }

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
}
