package semestralka;

public class Kniha {
    String autor;
    String nazev;
    String rok;
    
    public Kniha(String autor,String nazev,String rok){
        this.autor = autor;
        this.nazev = nazev;
        this.rok = rok;
    }
    @Override
    public String toString(){
        return "Autor: " + autor + " nazev: "+ nazev + " rok: "+ rok;
    }
}
