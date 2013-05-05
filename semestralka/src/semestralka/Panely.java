package semestralka;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import javax.swing.*;

public class Panely extends JPanel {
    
    public int vyska = 450;
    public int sirka = 280;
    public int n;
    
    public Panely() {
        this.setSize(vyska,sirka);
        this.setVisible(true);
        this.setLayout(null);
    }
    void odebrat(){
    
            for (int i = 0; i < Okno.knihovna.velikost(); i++) {

                Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));

            }
        
            MujChoice choc = new MujChoice();
            choc.setBounds(208, 185, 110, 30);

            
           
            Okno.list.addActionListener(new ListAction());
            Okno.list.addItemListener(new ItemAction());
            Okno.list.setVisible(true);
            Okno.list.setBounds(2,2,430,180);

            JLabel lab = new JLabel("Seřadit podle: ");
            lab.setBounds(115, 185, 90, 20);
            
            
            
            Tlacitko zpet = new Tlacitko("Zpět");
            zpet.setBounds(325, 185, 100, 30);
            zpet.addActionListener(new Zpet());
            
            Tlacitko smazat = new Tlacitko("Smazat");
            smazat.setBounds(10,185,100,30);
            smazat.addActionListener(new Smazat());
            
            JSeparator sep = new JSeparator();
            sep.setBounds(0, 181, 450, 10);

            this.add(lab);
             this.add(choc);
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

           
        }
    }

    private class ItemAction implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            String s =( e.getItem().toString());
           n = Integer.parseInt(s);
        }
    }
   
    public class Zpet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           Okno.hlavnipanel.setVisible(true);
           Okno.panelodebrat.remove(Okno.list);
           Okno.panelodebrat.add(Okno.list);
           Okno.panelodebrat.setVisible(false);
        }
    
    }
    public class Smazat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            
            Okno.knihovna.Odeber(n);
            
            System.out.println(Okno.knihovna.velikost());
            Okno.pomocna= Okno.knihovna;
            Okno.list.removeAll();
            
            for(int i = 0;i < Okno.knihovna.velikost();i++){
            Okno.list.add((i + 1) + " - " + Okno.knihovna.toStringAutorDilo(i));
            }
        }
        
    }
     
}
