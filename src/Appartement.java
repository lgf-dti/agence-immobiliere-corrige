public class Appartement extends BienImmobilier{
    private String etage;
    private boolean ascenseur;

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage,
            boolean ascenseur) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = ascenseur;
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = false;
    }

    public String typeBien(){
        String resultat ="";
        int nombrePieces = 0;
        for(Piece unePiece : super.pieces){
            if(unePiece.getTypePiece().isPiece()){
                nombrePieces++;
            }
        }
        resultat = "T" + nombrePieces;
        if(nombrePieces >7){
            resultat = "T7+";
        }
        return resultat;
    }

    @Override
    public String toString() {
        String resultat ="";
        resultat = "Appartement de type "+ typeBien();
        if(ascenseur){
            resultat += " avec ascenseur ";
        }
        resultat += " situé au " + etage + " ";
        resultat += super.toString();
        return resultat;
    }

    
    
    
}
