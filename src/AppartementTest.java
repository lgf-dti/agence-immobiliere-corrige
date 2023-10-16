import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppartementTest {

    private TypePiece chambre, salon;
    private Vendeur vendeur;
    private Appartement appartement;

    @Test
    public void testDpeSudExcellenteGeoExcellente88003FacesExterieuresDernierEtageShouldReturn58_29() {

        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        // Création d'un vendeur
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");
        // Création d'un nouveau bien immobilier : Appartement
        Appartement appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage", 3, true);
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 10, 3));
        appartement.ajouterPiece(new PieceTriangulaire(salon, "0", 10, 10));
        appartement.diagnosticDPE("Sud", "Excellente", "Géothermie", "Excellente");
        double resultat = appartement.dpe();
        assertEquals(58.29, resultat, 1e-2);
    }
}
