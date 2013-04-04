
package semestralka;

import java.awt.HeadlessException;
import javax.swing.*;

public class OknoNove extends JFrame{
    public OknoNove()throws HeadlessException{
        
        super("Moje Okno");
        this.setSize(320,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
}
