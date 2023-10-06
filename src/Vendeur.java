
public class Vendeur {
    private String nom;
    private String prenom;
    private String email;
    private String numeroTelephone;
    private double tauxCommission;
    
    public Vendeur(String nom, String prenom, String email, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.tauxCommission = 0.05;
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

    public double getTauxCommission() {
        return tauxCommission;
    }


    
}
