import java.util.ArrayList;

public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String numeroTelephone;
    private ArrayList<BienImmobilier> biens;

    public Personne(String nom, String prenom, String email, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.biens = new ArrayList<BienImmobilier>();
    }
    public void ajouterBienImmobilier(BienImmobilier unBienImmobilier) {
        this.biens.add(unBienImmobilier);
    }

    @Override
    public String toString() {
        return "Vendeur [email=" + email + ", nom=" + nom + ", numeroTelephone=" + numeroTelephone + ", prenom="
                + prenom + "]";
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

}
