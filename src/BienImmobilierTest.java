import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BienImmobilierTest {
    @Test
    public void testSurfaceHabitable() {
        TypePiece cuisine = new TypePiece(TypePiece.CUISINE, true, true);
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        TypePiece sdb = new TypePiece(TypePiece.SALLE_DE_BAIN, true, false);
        TypePiece garage = new TypePiece(TypePiece.GARAGE, false, false);

        Maison maMaison = new Maison("rue de la Gare", "Annecy", "74000", null, 500);
        maMaison.ajouterPiece(new PieceQuadrilatere(cuisine, "0", 4.58888888888, 3));
        maMaison.ajouterPiece(new PieceQuadrilatere(chambre, "0", 5, 2));
        maMaison.ajouterPiece(new PieceQuadrilatere(sdb, "0", 2, 2));
        maMaison.ajouterPiece(new PieceQuadrilatere(garage, "0", 5, 4));

        double resultat = maMaison.surfaceHabitable(); // 23.76

        assertEquals("Surface habitable de la maison", 23.76, resultat, 1e-2);

    }
}
