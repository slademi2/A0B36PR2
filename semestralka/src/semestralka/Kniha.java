package semestralka;

import java.io.Serializable;
import java.util.Objects;

/*
 * Kniha , jeji instanci je polozka Knihovna - kniha
 */

public class Kniha implements Serializable {
   private String jmeno;
   private String prijmeni;
   private String nazev;
   private String umisteni;
   private String poznamka;
   private String zanr;
   private String rok;
    
   /*
    * konstruktory
    */
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
    public String toStringall(){
        return jmeno+" "+prijmeni+" " + nazev +" "+ rok +" "+ zanr +" "+ umisteni;
    }

    /*
     * Gettery A Settery.
     */
    
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

   /*
    * metody pro zjisteni parametru knihy, a pro nastaveni
    */
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
            p = "Žádná poznámka";
            this.setPoznamka(p);
        }
        else{
            this.setPoznamka(p);
        }
    }
    public void prectiRok(String n){
        this.setRok(n);
    }

    
    /*
     * metody hashCode a equals kvuli porovnavani
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.jmeno);
        hash = 97 * hash + Objects.hashCode(this.prijmeni);
        hash = 97 * hash + Objects.hashCode(this.nazev);
        hash = 97 * hash + Objects.hashCode(this.umisteni);
        hash = 97 * hash + Objects.hashCode(this.poznamka);
        hash = 97 * hash + Objects.hashCode(this.zanr);
        hash = 97 * hash + Objects.hashCode(this.rok);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kniha other = (Kniha) obj;
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (!Objects.equals(this.prijmeni, other.prijmeni)) {
            return false;
        }
        if (!Objects.equals(this.nazev, other.nazev)) {
            return false;
        }
        if (!Objects.equals(this.umisteni, other.umisteni)) {
            return false;
        }
        if (!Objects.equals(this.poznamka, other.poznamka)) {
            return false;
        }
        if (!Objects.equals(this.zanr, other.zanr)) {
            return false;
        }
        if (!Objects.equals(this.rok, other.rok)) {
            return false;
        }
        return true;
    }

}
