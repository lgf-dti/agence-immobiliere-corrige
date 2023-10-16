public class Appartement extends BienImmobilier {
    private String etage;
    private boolean rezDeChaussee;
    private boolean dernierEtage;
    private int facesExterieures;
    private boolean ascenseur;

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage,
            boolean ascenseur) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = ascenseur;
        this.dernierEtage = false;
        this.rezDeChaussee = false;
        this.facesExterieures = 1;
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = false;
        this.dernierEtage = false;
        this.rezDeChaussee = false;
        this.facesExterieures = 1;
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage,
            int facesExterieures) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = false;
        this.dernierEtage = false;
        this.rezDeChaussee = false;
        this.facesExterieures = facesExterieures;
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage, int facesExterieures,
            boolean dernierEtage) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = false;
        this.rezDeChaussee = false;
        this.facesExterieures = facesExterieures;
        this.dernierEtage = dernierEtage;

    }

    public String typeBien() {
        String resultat = "";
        int nombrePieces = 0;
        for (Piece unePiece : super.pieces) {
            if (unePiece.getTypePiece().isPiece()) {
                nombrePieces++;
            }
        }
        resultat = "T" + nombrePieces;
        if (nombrePieces > 7) {
            resultat = "T7+";
        }
        return resultat;
    }

    public boolean isRezDeChaussee() {
        return rezDeChaussee;
    }

    public boolean isDernierEtage() {
        return dernierEtage;
    }

    @Override
    public String toString() {
        String resultat = "";
        resultat = "Appartement de type " + typeBien();
        if (ascenseur) {
            resultat += " avec ascenseur ";
        }
        resultat += " situé au " + etage + " ";
        resultat += super.toString();
        return resultat;
    }

    @Override
    public double dpe() {

        double resultat = super.dpe();

        // Modifier le résultat en fonction de la situation dans l'immeuble
        if (this.isDernierEtage() || this.isRezDeChaussee()) {
            resultat *= 1.2;
        } else {
            resultat *= 0.9;
        }

        // Modifier le résultat en fonction du nombre de faces donnant sur l'extérieur
        switch (this.facesExterieures) {
            case 2:
                resultat *= 1.1;
                break;
            case 3:
                resultat *= 1.15;
                break;
            case 4:
                resultat *= 1.25;
                break;
        }

        return resultat;
    }

}
