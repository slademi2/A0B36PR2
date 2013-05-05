package semestralka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObsluhaHledani implements ActionListener{
       private String hledat;
       private String com;

 
     
    
    @Override
    public void actionPerformed(ActionEvent e) {
        hledat = PomocnaOkna.text.getText();
        com =e.getActionCommand();
        
        
        if("Jména".equals(com)){
            PomocnaOkna.kn = Okno.knihovna.HledejJmeno(hledat);
            PomocnaOkna.li.removeAll();
            
            for(int i = 0;i<PomocnaOkna.kn.velikost();i++){
                PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
            }
            PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
        }
        if("Příjmení".equals(com)){
            PomocnaOkna.kn = Okno.knihovna.HledejPrijmeni(hledat);
            PomocnaOkna.li.removeAll();
            
            for(int i = 0;i<PomocnaOkna.kn.velikost();i++){
                PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
            }
            PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
        }
        if("Roku".equals(com)){
            PomocnaOkna.kn = Okno.knihovna.HledejRok(hledat);
            PomocnaOkna.li.removeAll();
            
            for(int i = 0;i<PomocnaOkna.kn.velikost();i++){
                PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
            }
            PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
        }
        if("Názvu".equals(com)){
            PomocnaOkna.kn = Okno.knihovna.HledejNazev(hledat);
            PomocnaOkna.li.removeAll();
            
            for(int i = 0;i<PomocnaOkna.kn.velikost();i++){
                PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
            }
            PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
        }
        if("Umístění".equals(com)){
            PomocnaOkna.kn = Okno.knihovna.HledejUmisteni(hledat);
            PomocnaOkna.li.removeAll();
            
            for(int i = 0;i<PomocnaOkna.kn.velikost();i++){
                PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
            }
            PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
        }
        if("Vše".equals(com)){
            PomocnaOkna.kn = Okno.knihovna.HledejVse(hledat);
            PomocnaOkna.li.removeAll();
            
            for(int i = 0;i<PomocnaOkna.kn.velikost();i++){
                PomocnaOkna.li.add((i + 1) + " - " + PomocnaOkna.kn.toStringAutorDilo(i));
            }
            PomocnaOkna.pocet = PomocnaOkna.kn.velikost();
        }
    }  
}
