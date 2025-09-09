package java;

import java.util.Date;

public class Pointage {
    private final Date date;
    private Travail TypeTravail;
    private final double quotaTemps;
    private final String descriptionTextuelle;

    public Pointage(Date date, Travail typeTravail, double quotaTemps, String descriptionTextuelle) {
        this.date = date;
        this.TypeTravail = TypeTravail;
        this.quotaTemps = quotaTemps;
        this.descriptionTextuelle = descriptionTextuelle;
    }

    public Date getDate() {
        return date;
    }

    public Travail getTypeTravail() {
        return TypeTravail;
    }

    public double getQuotaTemps() {
        return quotaTemps;
    }

    public String getDescriptionTextuelle() {
        return descriptionTextuelle;
    }

}

