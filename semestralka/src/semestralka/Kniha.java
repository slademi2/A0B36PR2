package semestralka;

import java.io.Serializable;
import java.util.Calendar;

public class Kniha implements Serializable {
   private String jmeno;
   private String prijmeni;
   private String nazev;
   private String umisteni;
   private String poznamka;
   String zanr;
    String rok;
    
    public Kniha(){
    
    }
    
    public Kniha(String jmeno,String prijmeni,String nazev,String zanr,String umisteni,String poznamka,String rok){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.nazev = nazev;
        this.rok = rok;
        this.umisteni = umisteni;
        this.poznamka = poznamka;
        this.zanr = zanr;
    }
    @Override
    public String toString(){
        return "Autor: " + jmeno + " "+ prijmeni  + " nazev: "+ nazev + " rok: "+ rok + " žánr: "+ zanr + " umístění: " + umisteni + " poznámka: "+ poznamka;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getUmisteni() {
        return umisteni;
    }

    public void setUmisteni(String umisteni) {
        this.umisteni = umisteni;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public void prectiJmeno(String p){
        this.setJmeno(p);
    }
    public void prectiPrijmeni(String p){
        this.setPrijmeni(p);
    }
    public void prectiNazev(String p){
        this.setNazev(p);
    }
    public void prectiZanr(String p){
        this.setZanr(p);
    }
    public void prectiUmisteni(String p){
        if(p==null){
            p = "Umístění nebylo zadáno.";
            this.setUmisteni(p);
        }
        else{
            this.setUmisteni(p);
        }
    }
    public void prectiPoznamka (String p){
        if(p==null){
            p = "Umístění nebylo zadáno.";
            this.setPoznamka(p);
        }
        else{
            this.setPoznamka(p);
        }
    }
    public void prectiRok(String n){// throws InvalidYearNumberException{
        
      /*  int year = Calendar.getInstance().get(Calendar.YEAR);
        int c=0;
        
        if(n.length()>4){
            //throw new InvalidYearNumberException(n);
        }
        
        try {
            c = Integer.parseInt(n);
            
        } catch (NumberFormatException ex) {
            //throw new InvalidYearNumberException(n);
        }
        this.setRok(c);*/
        this.setRok(n);
    }
    
}
