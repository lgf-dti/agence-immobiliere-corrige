import static org.junit.Assert.assertEquals;

import java.beans.BeanProperty;

import org.junit.Before;
import org.junit.Test;

public class BienImmobilierTest {

    private Appartement appartement; 
    @Before
    public void setUp() throws Exception {
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        // Création d'un vendeur
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");

        // Création d'un nouveau bien immobilier : Appartement
        appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage");
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 10, 3));
        appartement.ajouterPiece(new PieceTriangulaire(salon, "0", 10, 10));

    }
    @Test
    public void testSurfaceHabitable() {
        TypePiece cuisine = new TypePiece(TypePiece.CUISINE, true, true);
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        TypePiece sdb = new TypePiece(TypePiece.SALLE_DE_BAIN, true, false);
        TypePiece garage = new TypePiece(TypePiece.GARAGE, false, false);

        // Création d'un vendeur
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");

        Maison maMaison = new Maison("rue de la Gare", "Annecy", "74000", vendeur, 500);
        maMaison.ajouterPiece(new PieceQuadrilatere(cuisine, "0", 4.58888888888, 3));
        maMaison.ajouterPiece(new PieceQuadrilatere(chambre, "0", 5, 2));
        maMaison.ajouterPiece(new PieceQuadrilatere(sdb, "0", 2, 2));
        maMaison.ajouterPiece(new PieceQuadrilatere(garage, "0", 5, 4));

        double resultat = maMaison.surfaceHabitable(); //

        assertEquals("Surface habitable de la maison", 27.76, resultat, 1e-2);

    }

    @Test
    public void testConsommationKWhAn80m2ShouldReturn8800() {
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        // Création d'un vendeur
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");

        // Création d'un nouveau bien immobilier : Appartement
        Appartement appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage");
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 10, 3));
        appartement.ajouterPiece(new PieceTriangulaire(salon, "0", 10, 10));

        assertEquals(8800, appartement.consommationKWhAn(), 1e-2);
    }

    @Test
    public void testDpeEstMoyenneBoisMoyenne8800ShouldReturn153_75() {
   
        double resultat = appartement.dpe(1.2, 1.3, 0.8, 1.4);
        assertEquals(153.75, resultat, 1e-2);
    }

    @Test
    public void testDpeNordMauvaiseElecAucune8800ShouldReturn506_88() {
        
        double resultat = appartement.dpe(1.8, 1.6, 1, 2);
        assertEquals(506.88, resultat, 1e-2);
    }

    @Test
    public void testDpeSudExcellenteGeoExcellente8800ShouldReturn42_24() {
      
        double resultat = appartement.dpe(1, 1, 0.6, 0.8);
        assertEquals(42.24, resultat, 1e-2);
    }

    @Test
    public void testLettreDpe42_24ShouldReturnA() {
        String resultat = appartement.lettreDpe(1, 1, 0.6, 0.8);
        assertEquals("A", resultat);
    }

    @Test
    public void testLettreDpe506_88ShouldReturnG() {
        String resultat = appartement.lettreDpe(1.8, 1.6, 1, 2);
        assertEquals("G", resultat);
    }

    @Test
    public void testDictionnaireStatic(){
        assertEquals(1.8, BienImmobilier.dicOrientation.get("Nord"), 1e-2);
        assertEquals(1.0, BienImmobilier.dicOrientation.get("Sud"), 1e-2);
        assertEquals(1.2, BienImmobilier.dicOrientation.get("Est"), 1e-2);
        assertEquals(1.4, BienImmobilier.dicOrientation.get("Ouest"), 1e-2);

        assertEquals(0.8, BienImmobilier.dicChauffage.get("Bois"), 1e-2);
        assertEquals(0.6, BienImmobilier.dicChauffage.get("Géothermie"), 1e-2);
        
    }



}
