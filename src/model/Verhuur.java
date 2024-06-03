package model;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * @author Ihsan Kurt
 * @project Botenverhuur
 * @created 23 May Thursday 2024 - 13:28
 */
public class Verhuur {
    private Klant klant;
    private List<Boot> boten;
    private LocalDate startdatum;
    private int aantalDagen;


    public Verhuur(Klant klant, LocalDate startdatum, int aantalDagen) {
        this.klant = klant;
        this.startdatum = startdatum;
        this.aantalDagen = aantalDagen;
        this.boten = new ArrayList<>();
    }

    public void voegBootToe(Boot boot) {
        if (magVerhuurd(boot)) {
            this.boten.add(boot);
        } else {
            System.out.println(boot);
            System.out.println("Mag niet verhuurd worden! Toevoegen mislukt!");
        }

    }

    public double berekenHuurBedrag() {
        double totoalBedrag = 0;
        for (Boot boot : boten) {
            totoalBedrag += boot.berekenHuurprijs();
        }
        return totoalBedrag * this.aantalDagen;
    }

    public boolean magVerhuurd(Boot boot) {
        if (boot.isVaarbewijsPlicht() && !this.klant.isVaarVaardig()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Collections.sort(boten);
        if(boten.isEmpty()){
            String str=String.format("De verhuur aan %s op %s is mislukt, geen boten\n" +
                    "toegevoegd.",klant.toString(),startdatum.toString());
            return str;
        }else {
            StringBuilder stringBuilder = new StringBuilder();
             String str=String.format("De verhuur aan %s van %s tot %s kost %.2f euro:\n",klant.toString(),startdatum.toString(),startdatum.plusDays(aantalDagen).toString(),this.berekenHuurBedrag());
            stringBuilder.append(str);
            for (Boot eachBoot: this.boten) {
                stringBuilder.append(eachBoot.toString()).append('\n');
            }
             return stringBuilder.toString();
        }



    }
}
