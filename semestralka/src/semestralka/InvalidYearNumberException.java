package semestralka;

import javax.swing.JOptionPane;

public class InvalidYearNumberException extends Exception {

    String pl;
    
    public InvalidYearNumberException (String n){
        
        pl=n;
        JOptionPane.showMessageDialog(null,"Špatně zadaný rok.","",JOptionPane.ERROR_MESSAGE);
        
    }

    @Override
    public String toString() {
        return "Zadaný rok "+ pl + "není možný. ";
    }
    
}
