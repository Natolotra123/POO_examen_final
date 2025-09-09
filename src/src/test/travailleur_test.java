package java;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravailleurTest {

    @Test
    void testCreerTravailleurEtAccesseurs() {
        Promotion promo = new Promotion("Augmentation salaire", LocalDateTime.now(), 200.0);
        Pointage p1 = new Pointage(new Date(), Travail.ENSEIGNEMENT, 1.0, "Cours dispensé");

        Travailleur travailleur = new Travailleur(
                "1", "Rakoto", "Jean", "jean.rakoto@mail.com", "0377777777",
                1000.0, 300.0,
                List.of(promo),
                List.of(p1)
        );

        assertEquals("1", travailleur.getId());
        assertEquals("Rakoto", travailleur.getNom());
        assertEquals("Jean", travailleur.getPrenom());
        assertEquals(1000.0, travailleur.getSalaireMensuelInitial());
        assertEquals(300.0, travailleur.getTJM());
    }

    @Test
    void testPointageRouge_ok() {
        Pointage p1 = new Pointage(new Date(), Travail.ENSEIGNEMENT, 0.5, "Matin");
        Pointage p2 = new Pointage(new Date(), Travail.ADMINISTRATION, 0.5, "Après-midi");

        Travailleur travailleur = new Travailleur(
                "2", "Ando", "Marie", "marie.ando@example.com", "0339876543",
                1200.0, 250.0,
                List.of(),
                Arrays.asList(p1, p2)
        );

        assertThrows(NullPointerException.class, () -> travailleur.pointageRouge(new Date()));
    }

    @Test
    void testTotalJours() {
        Date debut = new Date(System.currentTimeMillis() - 5 * 24 * 60 * 60 * 1000); // il y a 5 jours
        Date fin = new Date();

        Pointage p1 = new Pointage(new Date(), Travail.ENSEIGNEMENT, 1.0, "Cours dispensé");
        Pointage p2 = new Pointage(new Date(), Travail.ABS_PAYÉE, 1.0, "Congé payé");

        Travailleur travailleur = new Travailleur(
                "3", "Rabe", "Paul", "paul.rabe@example.com", "0341122334",
                1500.0, 400.0,
                List.of(),
                Arrays.asList(p1, p2)
        );

        int jours = travailleur.totalJours(debut, fin);

        assertEquals(1, jours);
    }
}
