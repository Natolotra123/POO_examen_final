package java;

import java.util.Date;
import java.util.List;

public class Travailleur {
    private final String id;
    private final String nom;
    private final String prenom;
    private final String email;
    private final String telephone;
    private final double salaireMensuelInitial;
    private final double TJM;

    public Travailleur(String id, String nom, String prenom, String email, String telephone,
                       double salaireMensuelInitial, double TJM, List<Promotion> promotions,
                       List<Pointage> pointages) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.salaireMensuelInitial = salaireMensuelInitial;
        this.TJM = TJM;
        this.promotions = promotions;
        this.pointages = pointages;
    }

    public double getSalaireMensuelInitial() {
        return salaireMensuelInitial;
    }


    public double getTJM() {
        return TJM;
    }

    public List<Promotion> promotions;
    public List<Pointage> pointages;


    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    private List<Pointage> getPointagesParDate(Date date) {
        return null;
    }

    public boolean pointageRouge(Date date) {
        List<Pointage> pointagesDuJour = getPointagesParDate(date);
        double totalQuota = 0;
        for (Pointage p : pointagesDuJour) {
            if (p.getQuotaTemps() <= 0 || p.getQuotaTemps() > 1) {
                throw new IllegalArgumentException("Le quota de temps " +
                        "doit être positif et inférieur ou égal à 1.");
            }
            totalQuota += p.getQuotaTemps();
        }
        return totalQuota == 1;
    }

    public int totalJours(Date dateDebut, Date dateFin) {
        int joursPrestes = 0;
        for (Pointage p : this.pointages) {
            if (p.getDate().compareTo(dateDebut) >= 0 && p.getDate().compareTo(dateFin) <= 0 &&
                    p.getTypeTravail() != Travail.ABS_PAYÉE && p.getTypeTravail()
                    != Travail.ABS_NON_PAYÉE) {
                joursPrestes++;
            }
        }
        return joursPrestes;
    }
}
