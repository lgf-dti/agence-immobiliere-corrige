public class PieceQuadrilatere extends Piece{

    private double longueur;
    private double largeur; 

    public PieceQuadrilatere(TypePiece typePiece, String niveau, double longueur, double largeur) {
        super(typePiece, niveau);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double surface() {
        return longueur * largeur;
    }
    
}
