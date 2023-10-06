import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnnonceTest {
@Test
    public void testCommissionWithTaux0_05For267988_22ShouldReturn13399_41() {
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        TypePiece cuisine = new TypePiece(TypePiece.CUISINE, true, false);
        TypePiece salleDeBain = new TypePiece(TypePiece.SALLE_DE_BAIN, true, false);
        TypePiece Wc = new TypePiece(TypePiece.WC, true, false);
        TypePiece Cave = new TypePiece(TypePiece.CAVE, false, false);

        // Création d'un vendeur
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");

        // Création d'un nouveau bien immobilier : Appartement
        Appartement appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage");
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 4, 3));
        appartement.ajouterPiece(new PieceTriangulaire(cuisine, "0", 6, 2.3));
        appartement.ajouterPiece(new PieceCirculaire(salon, "0", 2.1));
        appartement.ajouterPiece(new PieceQuadrilatere(Wc, "0", 1.5, 2));
        appartement.ajouterPiece(new PieceQuadrilatere(salleDeBain, "0", 2, 2));
        appartement.ajouterPiece(new PieceQuadrilatere(Cave, "-1", 3, 3));
        // Création de l'annonce associée au bien immobilier : Appartement
        Annonce annonceAppartement = new Annonce("AA0922001", "27/09/2022", "Appartement avec vue sur le Lac d'Annecy",
                6380, appartement);
    
               

        double resultat = annonceAppartement.commission();
        assertEquals(13399.41, resultat, 1e-2);
    }
}


