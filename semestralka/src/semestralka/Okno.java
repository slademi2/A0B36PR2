/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.*;

/**
 *
 * @author Michal
 */
public class Okno extends JFrame {
    JButton but = new JButton("Novy");
    JButton b = new JButton("Ahoj");
    public Okno(){
        GridBagLayout gb1 = new GridBagLayout();// mrizkovany layout
        this.setLayout(gb1);
        GridBagConstraints gbc = new GridBagConstraints();
        gb1.setConstraints(but, gbc);// vlozeni komponenty !!
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add (b);
    }
    void set (){
        
        this.pack();
        this.setVisible(true);
    }
    
}