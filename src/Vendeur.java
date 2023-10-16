import java.util.ArrayList;

public class Vendeur extends Personne {
    private double tauxCommission;


    public Vendeur(String nom, String prenom, String email, String numeroTelephone) {
        super(nom, prenom, email, numeroTelephone);
        tauxCommission = 0.05;
    }

    public double getTauxCommission() {
        return tauxCommission;
    }

    public double calculCommissions() {
        double resultat = 0;
        for (BienImmobilier bienImmobilier : super.getBiens()) {
            resultat += bienImmobilier.getAnnonce().commission();
        }

        return resultat;
    }

}
