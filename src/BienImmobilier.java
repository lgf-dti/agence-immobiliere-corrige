import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BienImmobilier {
    private String rue;
    private String ville;
    private String codePostal;
    private Vendeur  vendeur;
    private Proprietaire proprietaire;
    protected ArrayList<Piece> pieces;
    private Annonce annonce;
    private String orientation, menuiserie, chauffage, isolation;

    public static Map<String, Double> dicOrientation;
    public static Map<String, Double> dicMenuiserie;
    public static Map<String, Double> dicChauffage;
    public static Map<String, Double> dicIsolation;

    static {
        dicOrientation = new HashMap<>();
        dicMenuiserie = new HashMap<>();
        dicChauffage = new HashMap<>();
        dicIsolation = new HashMap<>();

        dicOrientation.put("Nord", 1.8);
        dicOrientation.put("Sud", 1.0);
        dicOrientation.put("Est", 1.2);
        dicOrientation.put("Ouest", 1.4);

        dicChauffage.put("Bois", 0.8);
        dicChauffage.put("Géothermie", 0.6);
        dicChauffage.put("Electrique", 1.0);
        dicChauffage.put("Gaz", 0.9);

        dicMenuiserie.put("Excellente", 1.0);
        dicMenuiserie.put("Bonne", 1.1);
        dicMenuiserie.put("Moyenne", 1.3);
        dicMenuiserie.put("Mauvaise", 1.6);

        dicIsolation.put("Excellente", 0.8);
        dicIsolation.put("Bonne", 1.0);
        dicIsolation.put("Moyenne", 1.4);
        dicIsolation.put("Aucune", 2.0);
    }

    public BienImmobilier(String rue, String ville, String codePostal, Vendeur vendeur) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.vendeur = vendeur;
        vendeur.ajouterBienImmobilier(this);;
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

    public double consommationKWhAn(){
        double resultat = 0;
        resultat = surfaceHabitable() * 110;
        return resultat;
    }

    public double dpe() {
        double resultat = 0;
        resultat = (consommationKWhAn() * dicOrientation.get(this.orientation) * dicMenuiserie.get(this.menuiserie) * dicChauffage.get(this.chauffage) * dicIsolation.get(this.isolation)) /100;
        return resultat;
    }

    public String lettreDpe() {
        String lettre = "";
        double dpe = dpe();
        if (dpe <= 70) {
            lettre = "A";
        } else if (dpe > 70 && dpe <= 110) {
            lettre = "B";
        } else if (dpe > 110 && dpe <= 180) {
            lettre = "C";
        } else if (dpe > 180 && dpe <= 250) {
            lettre = "D";
        } else if (dpe > 250 && dpe <= 330) {
            lettre = "E";
        } else if (dpe > 330 && dpe <= 420) {
            lettre = "F";
        } else if (dpe > 420) {
            lettre = "G";
        }
        return lettre;
    }

    public void diagnosticDPE(String orientation, String menuiserie, String chauffage, String isolation) {
        this.orientation = orientation;
        this.menuiserie = menuiserie;
        this.chauffage = chauffage;
        this.isolation = isolation;

    }








}
