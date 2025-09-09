package java;

import java.time.LocalDateTime;

public class Promotion {
    private LocalDateTime date;
    private final String description;
    private final double valeur;

    public Promotion(String description, LocalDateTime date, double valeur) {
        this.description = description;
        this.valeur = valeur;
    }

    public double getValeur() {
        return valeur;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
