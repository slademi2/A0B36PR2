/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Michal
 */
public class Semestralka {
    public static int pocet = 0; 
    public static class Kniha implements Serializable{
    String autor,titul,rok,zanr;
        
        public Kniha (String autor,String titul,String rok, String zanr){
            this.autor = autor;
            this.titul = titul;
            this.rok = rok;
            this.zanr = zanr;
            pocet ++;
        }

        @Override
        public String toString() {
            return "Autor: "+ autor + ", Titul: " + titul + ", Rok: " + rok + ", Zanr: " + zanr;
        }
    }
    
    static class Prvek implements Serializable{
         
         Prvek dalsi;
        
         Kniha kn;
         
         public Prvek(Prvek dalsi, Kniha kn) {
            this.dalsi = dalsi;
            this.kn = kn;
        }
         
       
        public Kniha hodn() {
            return kn;
        }

        public Prvek dalsi() {
            return dalsi;
        }
     }
        
        static class ZasobnikKnih implements Serializable{

        Prvek vrchol;

        public ZasobnikKnih() {
            vrchol = null;
        }

        public void Vloz(Kniha kn) {
            vrchol = new Prvek(vrchol,kn );
        }

        boolean JePrazdny() {
            if (vrchol == null) {
                return true;
            } else {
                return false;
            }
        }

        void OdeberA() {
            if (JePrazdny()) {
                System.out.println("Seznam je prazdny.");
            } else {
                
                vrchol = vrchol.dalsi;
            }
        }
        void VypisZ() {
            int cislo = 0;
            
            Prvek pom = vrchol;
            while (pom != null) {
                System.out.print( " [ " + cislo + " ]" +" " + pom.kn.zanr );
                pom = pom.dalsi;
                System.out.println("");
                cislo ++;
                
            }
            pocet = cislo;
            System.out.println("");
        }
       
        void VypisT() {
            int cislo = 0;
            
            Prvek pom = vrchol;
            while (pom != null) {
                System.out.print( " [ " + cislo + " ]" +" " + pom.kn.titul );
                pom = pom.dalsi;
                System.out.println("");
                cislo ++;
                
            }
            pocet = cislo;
            System.out.println("");
        }
        void VypisA() {
            int cislo = 0;
            
            Prvek pom = vrchol;
            while (pom != null) {
                System.out.print( " [ " + cislo + " ]" +" " + pom.kn.autor );
                pom = pom.dalsi;
                System.out.println("");
                cislo ++;
                
            }
            pocet = cislo;
            System.out.println("");
        }

        void Vypis() {
            int cislo = 0;
            
            Prvek pom = vrchol;
            while (pom != null) {
                System.out.print( " [ " + cislo + " ]" +" " + pom.kn );
                pom = pom.dalsi;
                System.out.println("");
                cislo ++;
                
            }
            pocet = cislo;
            System.out.println("");
        }
        
        void hledejAutora(String hledejA){
            Prvek pom = vrchol;
            
            System.out.println("Výsledky hledání: ");
            int pocet = 0;
            while(pom!=null){
               // System.out.println(pom.kn);
             // boolean contains =   (pom.kn.autor.toLowerCase().contains(hledejA));
                
                if((pom.kn.autor.toLowerCase().contains(hledejA.toLowerCase())) == true )
                {
                    System.out.println(pom.kn);
                    pocet ++;
                }
               pom = pom.dalsi;
                
            }
            if(pocet ==0) {
                System.out.println("Nebyl nalezen žádný autor tohoto jména");
            }
        }
        void hledejTitul(String hledejT){
            Prvek pom = vrchol;
            
            System.out.println("Výsledky hledání: ");
            int pocet = 0;
            while(pom!=null){
               // System.out.println(pom.kn);
                
                if(pom.kn.titul.toLowerCase().contains(hledejT.toLowerCase()) == true ){
                    System.out.println(pom.kn);
                    pocet ++;
                }
               pom = pom.dalsi;
                
            }
            if(pocet ==0) {
                System.out.println("Nebyl nalezen žádný titul tohoto jména");
            }
        }
        
       
        
        void hledejZanr(String hledejZ){
            Prvek pom = vrchol;
            
            System.out.println("Výsledky hledání: ");
            int pocet = 0;
            while(pom!=null){
               // System.out.println(pom.kn);
                
                if(pom.kn.zanr.toLowerCase().contains(hledejZ.toLowerCase()) == true){
                    System.out.println(pom.kn);
                    pocet ++;
                }
               pom = pom.dalsi;
                
            }
            if(pocet ==0) {
                System.out.println("Nebyla nalezena žádná kniha tohoto žánru: ");
            }
        }
            void hledejRok(String hledejR){
            Prvek pom = vrchol;
            
            System.out.println("Výsledky hledání: ");
            int pocet = 0;
            while(pom!=null){
               // System.out.println(pom.kn);
                
                if(pom.kn.rok.toLowerCase().contains(hledejR.toLowerCase()) == true){
                    System.out.println(pom.kn);
                    pocet ++;
                }
               pom = pom.dalsi;
                
            }
            if(pocet ==0) {
                System.out.println("Nebyla nalezena žádná kniha z tohoto roku. ");
            }
        }
            
            void mazani(int i){
                
                if(i==0){
                    vrchol = vrchol.dalsi;
                }else{
                    Prvek pom = vrchol;
                    for (int j = 0; j < i - 1; j++) {
                        pom = pom.dalsi;
                    }
                        pom.dalsi = pom.dalsi.dalsi;  
                }
            }
           
            
            
        }
     

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
       
       /* Okno ok1 = new Okno();
        ok1.set();*/
        
   //     MujGridBagLayout ff = new MujGridBagLayout();
      //  ff.setVisible(true);
        Scanner sc = new Scanner (System.in);
       ZasobnikKnih knihy = new ZasobnikKnih();       
        
        FileInputStream in = new FileInputStream("knihy.bin");
                    ObjectInputStream oin = new ObjectInputStream(in);

        knihy = (ZasobnikKnih)oin.readObject();
        oin.close();
        

       
 boolean podminka = true;
        String hledej;
        String hledejA;
        String hledejT;
        String hledejR;
        String hledejZ;
        String vypsat;
        
        int smaz;
        
        System.out.println("Vítejte v databázi knih "); 
        System.out.println("");
        
       while ( podminka == true){
        System.out.println("Zadejte příkaz z nabídky příkazů: novy, vypsat, smazat, vyhledat, konec");
        String prikaz = sc.next();
        
        
        switch (prikaz){
            case("novy"):{
                System.out.println("Vytvarite novou knihu: ");
                String p = sc.nextLine();
                System.out.println("Zadejte autora:");
                String autor = sc.nextLine();
                System.out.println("Zadejte název knihy: ");
                String titul = sc.nextLine();
                System.out.println("Zadejte rok vydání: ");
                String rok = sc.nextLine();
                System.out.println("Zadejte žánr: ");
                String zanr = sc.nextLine();
                
                
                Kniha kp = new Kniha(autor,titul,rok,zanr);
                System.out.println(kp);
               
                knihy.Vloz(kp);
                break;
            }//case Novy
            case("vypsat"):{
                System.out.println("podle čeho chcete vypsat knihy? (all, autor, titul, rok, zanr)");
                vypsat = sc.next();
                switch(vypsat.toLowerCase()){
                    case("all"):{
                        System.out.println("Knihovna obsahuje tyto položky: ");
                        System.out.println("");
                        knihy.Vypis();
                        break;
                    }
                    case("autor"):{
                        System.out.println("Knihovna obsahuje tyto autory: ");
                        System.out.println("");
                        knihy.VypisA();
                        break;
                    }
                    case("titul"):{
                        System.out.println("Knihovna obsahuje tyto tituly: ");
                        System.out.println("");
                        knihy.VypisT();
                        break;
                    }
                    case("zanr"):{
                        System.out.println("Knihovna obsahuje tyto žánry knih: ");
                        System.out.println("");
                        knihy.VypisZ();
                        break;
                    }
                    default:{
                        System.out.println("zadali jste špatný příkaz");
                        break;
                    }
                    
                }
                
                break;
            }//case vypsat
            case("vyhledat"):{
                System.out.println("podle čeho chcete vyhledávat? (autor, titul, rok, zanr)");
                hledej = sc.next();
                switch(hledej.toLowerCase()){
                    case("autor"): {
                        System.out.println("Zadejte jméno autora které chcete hledat:");
                        String p = sc.nextLine();
                        hledejA = sc.nextLine();
                        knihy.hledejAutora(hledejA);
                        System.out.println("");
                        break;
                    }
                    case("titul"):{
                        System.out.println("Zadjte titul který chcete hledat: ");
                        String p = sc.nextLine();
                        hledejT = sc.nextLine();
                        knihy.hledejTitul(hledejT);
                        System.out.println("");
                        break;
                    }//case titul
                        
                    case("rok"):{
                        System.out.println("Zadejte rok který chcete vyhledat: ");
                        String p = sc.nextLine();
                        hledejR = sc.nextLine();
                        knihy.hledejRok(hledejR);
                        System.out.println("");
                        break;
                    }//case rok
                        
                    case("zanr"):{
                        System.out.println("zadejte zanr ktery chcete vyhledat: ");
                        String p = sc.nextLine();
                        hledejZ = sc.nextLine();
                        knihy.hledejZanr(hledejZ);
                        System.out.println("");
                        break;
                    }//case zanr
                    default:{
                        System.out.println("Zadaly jste špatnou vyhledávací podmínku");
                    }//default hledej    
                }//switch hledej
                break;
            }//case vyhledat
            case("smazat"):{   
                        System.out.println("zadejte číslo knihy kterou chcete smazat");
                        knihy.Vypis();
                        smaz = sc.nextInt();
                        if((smaz >= pocet  )||(smaz<0)){
                            System.out.println("zadali jste špatné číslo");
                        }
                        else{
                        knihy.mazani(smaz);
                        pocet --;
                        knihy.Vypis();
                            System.out.println("pocet je knih je : "+pocet);
                        }
                        
                   
                    break;
                
                }//case smazat
            case("konec"):{
                podminka =false;
                System.out.println("!!!KONEC!!!");
                FileOutputStream fos = new FileOutputStream("knihy.bin");
                    ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(knihy);
                out.close();
                }
                break;
            default:{
                System.out.println("Byl zadán špatný příkaz!! opakujte akci");
            }
        }//Switch
        
    }//While
    }
}
