
package semestralka;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.*;

public class Menulista extends JMenuBar {
    
    public Menulista(){
        JMenu fileMenu = new JMenu("File");
        this.add(fileMenu);
        
        
        
        
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new Ulozit());
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new Exit());
        
        
        fileMenu.add(save);
        
        fileMenu.addSeparator();
        fileMenu.add(exit);
        
        JMenu knihaMenu = new JMenu("Kniha");
        this.add(knihaMenu);
        
        JMenuItem novy = new JMenuItem("Nová");
        novy.addActionListener(new Okno.Novy());
        JMenuItem smazat = new JMenuItem("Smazat");
        smazat.addActionListener(new Okno.Odebrat());
        JMenuItem vyhledat = new JMenuItem("Vyhledat");
        knihaMenu.add(novy);
        
        knihaMenu.add(smazat);
        knihaMenu.add(vyhledat);
    }
    private class Ulozit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Okno.getKnihovna().save();
        }
    
    }
    private class Exit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("EXIT");
            int n = JOptionPane.showConfirmDialog(frame,"Opravdu chcete ukončit program?",
                    "Exit",JOptionPane.YES_NO_OPTION);
            if( n == 1){
                frame.dispose();
            }
            else{
                Okno.getKnihovna().save();
                System.exit(0);
                
            }
            
        }
        
    }
    
}
