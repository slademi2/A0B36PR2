
package semestralka;

import java.awt.HeadlessException;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Okno extends JFrame{
    
    static Knihovna knihovna = new Knihovna();
  
    
   public Okno()throws HeadlessException{
        super("Moje Okno");
        knihovna.load();
        
        int vyska= 450;
        int sirka = 280;
        
        this.setSize(vyska,sirka);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.setLayout(null);
        JLabel l1 = new JLabel();
        l1.setBounds(20,10,320,32);
        l1.setText("Vítejte v Databázi knih, zadejte požadavek");

        Tlacitko novy = new Tlacitko("Přidat Knihu");
        
        novy.setBounds(50,50,130,32);
        novy.addActionListener(new Novy());

        Tlacitko vypsat = new Tlacitko("Zobrazit knihy");
        vypsat.setBounds(50,90,130,32);
        vypsat.addActionListener(new Zobrazit());
        
        Menulista m = new  Menulista();
        setJMenuBar(m);
        
       /* List list = new List(knihovna.velikost());
            for(int i = 0; i< knihovna.velikost(); i ++){
                list.add(knihovna.toStringAutorDilo(i));
            }
        list.setBounds(50,130,280,45); //celkem obstojná velikost
        this.add(list);
        */
        this.add(novy);
        this.add(l1);
        this.add(vypsat);
        
        this.setVisible(true);
        
    }
    private static class Novy implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            PomocnaOkna ok = new PomocnaOkna();
            ok.novy();
        }      
    }
    private static class Zobrazit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            PomocnaOkna ok = new PomocnaOkna();
            ok.zobrazit();
        }
        
    }
}
    
