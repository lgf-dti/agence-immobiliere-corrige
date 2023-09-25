public class PieceCirculaire extends Piece{

    private double rayon;

    public PieceCirculaire(TypePiece typePiece, String niveau, double rayon) {
        super(typePiece, niveau);
        this.rayon = rayon;
    }

    @Override
    public double surface() {
        return Math.PI * Math.pow(rayon, 2);
    }
    
}
