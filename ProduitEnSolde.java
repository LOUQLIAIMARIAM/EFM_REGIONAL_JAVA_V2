package EFM_REGIONAL_JAVA_V2;

public class ProduitEnSolde extends Produit {
    private double remise;

    public ProduitEnSolde(int code, double prix, double remise) throws Exception {
        super(code, prix);
        if (remise < 0 || remise > 90) {
            throw new Exception("La remise doit être comprise entre 0 et 90.");
        }
        this.remise = remise;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) throws Exception {
        if (remise < 0 || remise > 90) {
            throw new Exception("La remise doit être comprise entre 0 et 90.");
        }
        this.remise = remise;
    }

    @Override
    public double prixProduit() {
        return super.getPrix() * (100 - remise) / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + remise;
    }}
