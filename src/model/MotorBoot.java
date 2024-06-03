package model;

/**
 * @author Ihsan Kurt
 * @project Botenverhuur
 * @created 22 May Wednesday 2024 - 13:47
 */

public class MotorBoot extends Boot {

    private final int VAARBEWIJS_LENGTE = 15;
    private final int VAARBEWIJS_SNELHEID = 20;
    private final int LIMIT_LENGTE = 10;
    private final double MIN_PRIJS = 60.0;
    private final double MAX_PRIJS = 90.0;
    private int maxSnelheid;

    public int getMaxSnelheid() {
        return maxSnelheid;
    }

    public MotorBoot(String naam, int lengte, int maxSnelheid) {
        super(naam, lengte);
        this.maxSnelheid = maxSnelheid;
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
        String str = String.format("Motor%s \n\tVaarbewijs vereist: %s\n\tHuurprijs: %.2f", super.toString(), VaarbiwijsControl, berekenHuurprijs());
        return str;
    }

    @Override
    public boolean isVaarbewijsPlicht() {
        if (getLengte() > VAARBEWIJS_LENGTE || getMaxSnelheid() > VAARBEWIJS_SNELHEID) {
            return true;
        }
        return false;
    }
}
