public class PieceTrapezoidale extends Piece{

    private double petiteBase;
    private double grandeBase;
    private double hauteur;
    
    public PieceTrapezoidale(TypePiece typePiece, String niveau, double petiteBase, double grandeBase, double hauteur) {
        super(typePiece, niveau);
        this.petiteBase = petiteBase;
        this.grandeBase = grandeBase;
        this.hauteur = hauteur;
    }

    @Override
    public double surface() {
        return (petiteBase + grandeBase) * hauteur * 1/2;
    }

    
    
}