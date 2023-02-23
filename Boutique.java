package EFM_REGIONAL_JAVA_V2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Boutique {
    private List<Produit> produits;

    public Boutique() {
        produits = new ArrayList<>();
    }

    public int indiceDe(int code) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    public void ajouter(Produit p) throws Exception {
        if (produits.contains(p)) {
            throw new Exception("Le produit existe déjà dans la boutique.");
        }
        produits.add(p);
    }

    public boolean supprimer(int code) {
        int indice = indiceDe(code);
        if (indice >= 0) {
            produits.remove(indice);
            return true;
        }
        return false;
    }

    public boolean supprimer(Produit p) {
        return produits.remove(p);
    }

    public int nombreProduitsEnSolde() {
        int count = 0;
        for (Produit p : produits) {
            if (p instanceof ProduitEnSolde) {
                count++;
            }
        }
        return count;
    }

    public void enregistrer(String chemin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(chemin));
        for (Produit p : produits) {
            writer.write(p.toString());
        }
    }
}
