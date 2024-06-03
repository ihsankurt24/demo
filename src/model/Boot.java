package model;

/**
 * @author Ihsan Kurt
 * @project Botenverhuur
 * @created 22 May Wednesday 2024 - 13:44
 */
public abstract class Boot implements VrijVerhuurbaar, Comparable<Boot> {

    private static int lastId = 1;
    private final int id = lastId;
    private String naam;
    private int lengte;
    private final int STANDART_LENGTE = 5;

    protected Boot(String naam, int lengte) {
        this.naam = naam;
        setLengte(lengte);
        lastId++;

    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }


    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        if (lengte < 0) {
            System.out.println("De lengte van de boot moet positief zijn.");
            this.lengte = STANDART_LENGTE;
        } else {
            this.lengte = lengte;
        }

    }
public abstract  double berekenHuurprijs();
    @Override
    public int compareTo(Boot anderBoot) {
        return this.getNaam().compareTo(anderBoot.getNaam());
    }

    @Override
    public String toString() {

        String str = String.format("Boot %d met naam %s ", getId(), getNaam());
        return str;
    }
}
