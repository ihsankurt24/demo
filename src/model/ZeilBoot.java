package model;

/**
 * @author Ihsan Kurt
 * @project Botenverhuur
 * @created 22 May Wednesday 2024 - 13:48
 */


public class ZeilBoot extends Boot{

    private final int VAARBEWIJS_LENGTE = 15;
    private final int LIMIT_LENGTE = 7;
    private final double MIN_PRIJS = 40.0;
    private final double MAX_PRIJS = 70.0;

    public ZeilBoot(String naam, int lengte) {
        super(naam, lengte);
    }

    @Override
    public double berekenHuurprijs() {

        if (getLengte() < LIMIT_LENGTE) {
            return MIN_PRIJS;
        }
        return MAX_PRIJS;

    }

    @Override
    public String toString() {
        String VaarbiwijsControl = "Nee";

        if (isVaarbewijsPlicht()) {
            VaarbiwijsControl = "Ja";
        }
        String str = String.format("Zeil%s \n\tVaarbewijs vereist: %s\n\tHuurprijs: %.2f", super.toString(), VaarbiwijsControl, berekenHuurprijs());
        return str;
    }

    @Override
    public boolean isVaarbewijsPlicht() {
        if (getLengte() >VAARBEWIJS_LENGTE ) {
            return true;
        }
        return false;
    }
}
