package semestralka;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Okno extends JFrame {

    static Knihovna knihovna = new Knihovna();
    
    public static Panely hlavnipanel = new Panely();
    public static Panely panelodebrat = new Panely();
    
    static List list = new List(knihovna.velikost());
    static List zobrlist = new List(knihovna.velikost());
    
    
    public int vyska = 450;
    public int sirka = 280;

   

    public Okno() throws HeadlessException {

        super("Moje Okno");
        knihovna.load();

        
        
        this.setSize(vyska, sirka);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 10, 320, 32);
        l1.setText("Vítejte v Databázi knih, zadejte požadavek");

        Tlacitko novy = new Tlacitko("Přidat Knihu");

        novy.setBounds(50, 50, 130, 32);
        novy.addActionListener(new Okno.Novy());

       /* Tlacitko vypsat = new Tlacitko("Zobrazit knihy");
        vypsat.setBounds(50, 90, 130, 32);
        vypsat.addActionListener(new Okno.Zobrazit());*/

        Tlacitko odebrat = new Tlacitko("Zobrazit knihovnu");
        odebrat.setBounds(50, 130, 130, 32);
        odebrat.addActionListener(new Odebrat());

        hlavnipanel.add(l1);
        hlavnipanel.add(odebrat);
        hlavnipanel.add(novy);
        //hlavnipanel.add(vypsat);
        
        
        panelodebrat.setVisible(false);
        panelodebrat.odebrat();
        Menulista m = new Menulista();
        setJMenuBar(m);
        add(panelodebrat);
        add(hlavnipanel);
        this.setVisible(true);

    }
    void Oknoodeber(Component comp){
        this.remove(comp);
    }
    void OknoPridej(Component comp){
        this.add(comp);
    }
     
    static class Novy implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PomocnaOkna ok = new PomocnaOkna();
            ok.novy();
        }
    }

    static class Zobrazit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PomocnaOkna ok = new PomocnaOkna();
            ok.zobrazit();
        }
    }

    static class Odebrat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hlavnipanel.setVisible(false);  
            panelodebrat.setVisible(true);
            
        }
    }
    
    public class Zpet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hlavnipanel.setVisible(true);
            panelodebrat.setVisible(false);
            
        }
    
    }
     
}

