import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PieceQuadrilatereTest {
    
    @Test
    public void testSurfaceLongueur2Largeur2DoitDonner4() {
        TypePiece monTypePiece = new TypePiece("Cuisine", true, true);
        PieceQuadrilatere maPieceQuadrilatere = new PieceQuadrilatere(monTypePiece, "0", 2, 2);

        double resultat = maPieceQuadrilatere.surface();

        assertEquals("Piece quadrilatere 2x2 = 4", 4.0, resultat, 0);

    }
}
