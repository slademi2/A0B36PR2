package semestralka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObsluhaHledani implements ActionListener {

    private String hledat;
    private String com;

    @Override
    public void actionPerformed(ActionEvent e) {
        hledat = Panely.text.getText();
        com = e.getActionCommand();


        if ("Jména".equals(com)) {
            Panely.kn = Okno.knihovna.HledejJmeno(hledat);
            Panely.li.removeAll();

            for (int i = 0; i < Panely.kn.velikost(); i++) {
                Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
            }
            Panely.pocet = Panely.kn.velikost();
        }
        if ("Příjmení".equals(com)) {
            Panely.kn = Okno.knihovna.HledejPrijmeni(hledat);
            Panely.li.removeAll();

            for (int i = 0; i < Panely.kn.velikost(); i++) {
                Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
            }
            Panely.pocet = Panely.kn.velikost();
        }
        if ("Roku".equals(com)) {
            Panely.kn = Okno.knihovna.HledejRok(hledat);
            Panely.li.removeAll();

            for (int i = 0; i < Panely.kn.velikost(); i++) {
                Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
            }
           Panely.pocet = Panely.kn.velikost();
        }
        if ("Názvu".equals(com)) {
            Panely.kn = Okno.knihovna.HledejNazev(hledat);
            Panely.li.removeAll();

            for (int i = 0; i < Panely.kn.velikost(); i++) {
                Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
            }
            Panely.pocet = Panely.kn.velikost();
        }
        if ("Umístění".equals(com)) {
            Panely.kn = Okno.knihovna.HledejUmisteni(hledat);
            Panely.li.removeAll();

            for (int i = 0; i < Panely.kn.velikost(); i++) {
                Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
            }
            Panely.pocet = Panely.kn.velikost();
        }
        if ("Vše".equals(com)) {
            Panely.kn = Okno.knihovna.HledejVse(hledat);
            Panely.li.removeAll();

            for (int i = 0; i < Panely.kn.velikost(); i++) {
                Panely.li.add((i + 1) + " - " + Panely.kn.toStringAutorDilo(i));
            }
            Panely.pocet = Panely.kn.velikost();
        }
    }
    /*public void actionPerformed(ActionEvent e) {
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
     }  */
}
