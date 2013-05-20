package semestralka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * trida obsluhujici hledani, actionlistener pro hledani.
 */

public class ObsluhaHledani implements ActionListener {

    private String hledat;
    private String com;

    /*
     * hledani, ktere vyuziva metod ve trida Knihovna
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        hledat = Panely.getText().getText();
        com = e.getActionCommand();
        switch (com) {
            case "Jména":
                Panely.setKn(Okno.getKnihovna().HledejJmeno(hledat));
                Panely.getLi().removeAll();
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
                Panely.setPocet(Panely.getKn().velikost());
                break;
            case "Příjmení":
                Panely.setKn(Okno.getKnihovna().HledejPrijmeni(hledat));
                Panely.getLi().removeAll();
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
                Panely.setPocet(Panely.getKn().velikost());
                break;
            case "Roku":
                Panely.setKn(Okno.getKnihovna().HledejRok(hledat));
                Panely.getLi().removeAll();
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
                Panely.setPocet(Panely.getKn().velikost());
                break;
            case "Názvu":
                Panely.setKn(Okno.getKnihovna().HledejNazev(hledat));
                Panely.getLi().removeAll();
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
                Panely.setPocet(Panely.getKn().velikost());
                break;
            case "Umístění":
                Panely.setKn(Okno.getKnihovna().HledejUmisteni(hledat));
                Panely.getLi().removeAll();
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
                Panely.setPocet(Panely.getKn().velikost());
                break;
            case "Vše":
                Panely.setKn(Okno.getKnihovna().HledejVse(hledat));
                Panely.getLi().removeAll();
                for (int i = 0; i < Panely.getKn().velikost(); i++) {
                    Panely.getLi().add((i + 1) + " - " + Panely.getKn().toStringAutorDilo(i));
                }
                Panely.setPocet(Panely.getKn().velikost());
                break;
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
