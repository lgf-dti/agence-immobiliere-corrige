import java.text.DecimalFormat;
import java.util.ArrayList;

public class BienImmobilier {
    private String rue;
    private String ville;
    private String codePostal;
    private Vendeur  vendeur;
    protected ArrayList<Piece> pieces;
    private Annonce annonce;


    public BienImmobilier(String rue, String ville, String codePostal, Vendeur vendeur) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.vendeur = vendeur;
        pieces = new ArrayList<Piece>();
    }
    public double surfaceHabitable(){
        double resultat = 0;
        for(Piece unePiece : pieces){
            if(unePiece.isSurfaceHabitable() == true)
            resultat += unePiece.surface();
        }
        return resultat;
    }
    public double surfaceNonHabitable(){
        double resultat = 0;
        for(Piece unePiece : pieces){
            if(!unePiece.getTypePiece().isSurfaceHabitable())
            resultat += unePiece.surface();
        }
        return resultat;
    }
    public void ajouterPiece(Piece piece){
        pieces.add(piece);
    }

    public Vendeur getVendeur() {
        return vendeur;
    }   

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
    
    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "\nLocalisation : " + rue + " " + codePostal + " " + ville +
                "\n \n Description du bien : \n" +
                toStringPieces() +
                "\nPour une surface habitable de : " + numberFormat.format(surfaceHabitable())
                + " m2 et une surface non habitable de : " + numberFormat.format(surfaceNonHabitable()) + " m2.";
    }

    public String toStringPieces() {
        String resultat = "";
        for (Piece unePiece : pieces) {
            resultat += unePiece.toString();
        }
        return resultat;
    }



}
