import java.text.DecimalFormat;

public abstract class Piece {
    private TypePiece typePiece;
    private String niveau;

    public Piece(TypePiece typePiece, String niveau) {
        this.typePiece = typePiece;
        this.niveau = niveau;
    }

    public abstract double surface();

    public boolean isSurfaceHabitable(){
        boolean resultat = true;
        if(typePiece.isSurfaceHabitable() == false){
            resultat = false;
        }
        return resultat;
    }

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public String getNiveau() {
        return niveau;
    }

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "- " + typePiece + " surface : " + numberFormat.format(surface()) + " m2\n";
    }

    
    

}
