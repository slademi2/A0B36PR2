
package semestralka;

import java.awt.HeadlessException;
import javax.swing.*;



public class Okno extends JFrame{
    private Tlacitko novy=new Tlacitko("Novy");
    
    
    
    
   public Okno()throws HeadlessException{
        super("Moje Okno");
        int vyska= 320;
        int sirka = 200;
        
        this.setSize(vyska,sirka);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(null);
        JLabel l1 = new JLabel();
        l1.setBounds(20,10,320,32);
        l1.setText("Vítejte v Databázi knih, zadejte požadavek");

        Tlacitko novy = new Tlacitko("Nový");
        novy.setBounds(50,50,130,32);

        Tlacitko smazat = new Tlacitko("Smazat");
        smazat.setBounds(50,90,130,32);
        smazat.setText("B");
        
        Menulista m = new  Menulista();
        setJMenuBar(m);
        
        
        this.add(novy);
        this.add(l1);
        this.add(smazat);
        
        this.setVisible(true);
        
    }
   

}
