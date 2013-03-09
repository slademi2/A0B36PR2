/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author Michal
 */
public class MujGridBagLayout extends JFrame {
    

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }
    GridBagLayout gb1;
    GridBagConstraints gbc;
        
    void vytvorTlacitko (String jmeno,int gridwidth){
        Button b = new Button(jmeno);
        gbc.gridwidth = gridwidth;
        gb1.setConstraints(b, gbc);
        add(b);
    }
     MujGridBagLayout() {
        super.setTitle(getClass().getName());
        gb1 = new GridBagLayout();
        this.setLayout(gb1);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        // začíná první řádek
        gbc.weightx = 1.0;
        vytvorTlacitko ("T1.1",1);// pres jednu bunku
        vytvorTlacitko ("Tlač 2",GridBagConstraints.RELATIVE);//relative- vedle tlacitka 1
        vytvorTlacitko ("Tlač 3",GridBagConstraints.REMAINDER);// vedle, a posledni v rade
        // druhý řádek
        gbc.weightx = 0.0;
        vytvorTlacitko("Tlač.4",2);//pres dve bunky
        
        gbc.weighty = 1.0;// nasavujo roztazitelnost do sirky
        gbc.gridheight = 2; // pro dalsí tlacitko nastavuji vysku 2
        vytvorTlacitko("Tlačítko 5", GridBagConstraints.REMAINDER);//poslední v řadě
        
        gbc.weighty=0.0;
        gbc.gridheight = 1;
        gbc.gridx= 0;
        gbc.gridy = 2;
        vytvorTlacitko("Tlacitko 6",1);
        gbc.gridx = 1;
        vytvorTlacitko("T. 7", 1);
        
       // this.setSize(200,120);
        this.setVisible(true);
        this.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
