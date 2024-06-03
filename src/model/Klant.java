package model;

/**
 * @author Ihsan Kurt
 * @project Botenverhuur
 * @created 22 May Wednesday 2024 - 13:22
 */

public class Klant {
    private String naam;
    private String emailadres;
    ;
    private boolean vaarVaardig = false;

    @Override
    public String toString() {
        String str = String.format("Klant %s", this.getNaam());
        return str;
    }

    public Klant(String naam, String emailadres, boolean vaarVaardig) {
        this.naam = naam;
        this.emailadres = emailadres;
        this.vaarVaardig = vaarVaardig;
    }

    public Klant(String naam) {
        this(naam, "Onbekand", false);
    }

    //no args
    public Klant() {
        this("Onbekand");
    }

    public String getNaam() {
        return naam;
    }

    public boolean isVaarVaardig() {
        return vaarVaardig;
    }


}
