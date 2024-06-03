package controller;

import model.*;

import java.time.LocalDate;

/**
 * @author Ihsan Kurt
 * @project Botenverhuur
 * @created 22 May Wednesday 2024 - 13:21
 */
public class BotenVerhuurLauncher {
    public static void main(String[] args) {

        // Check Klant toString methode
        Klant klant = new Klant("Ali");
        Klant ihsan= new Klant("ihsan", "kurt@gmail.com", false);
        System.out.println(klant);
        // Check Boot toString methode en lengte>0
        Boot boot = new MotorBoot("De Engel", -1,50);
        Boot boot1 = new MotorBoot("ADe Frans", 28,19);

        System.out.println(boot);
        System.out.println(boot1);

        Boot boot2= new ZeilBoot("AR SSS ", 5);
        Boot boot3= new ZeilBoot("ZZ SSS ", 5);
        System.out.println(boot2);

        Verhuur verhuur=new Verhuur(ihsan, LocalDate.now(),4);
        verhuur.voegBootToe(boot3);
        verhuur.voegBootToe(boot);
        verhuur.voegBootToe(boot2);
        verhuur.voegBootToe(boot2);

        System.out.println(verhuur);
    }


}
