
package semestralka;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menulista extends JMenuBar {
    
    public Menulista(){
        JMenu fileMenu = new JMenu("File");
        this.add(fileMenu);
        this.setAlignmentX(TOP_ALIGNMENT);
        this.setAlignmentY(TOP_ALIGNMENT);
        
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        
        fileMenu.add(open);
        fileMenu.add(save);
       // fileMenu.addSeparator();
        
        
    
    }
    
}
