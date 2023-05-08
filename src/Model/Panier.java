package Model;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	
    private static int nextPanierId = 0;
	
    private List<LigneDeCommande> lignesDeCommande;
    private float prixTotal;
    private int client_id;
    private int panier_id;
    
    public Panier() {}
    public Panier(int client_id) {
        lignesDeCommande = new ArrayList<>();
        prixTotal = 0;
        this.client_id = client_id;
        this.panier_id = getNextPanierId();
    }

    public int getId() {
        return panier_id;
    }

    public int getClientId() {
        return client_id;
    }

    public float getTotal() {
        return prixTotal;
    }


    private static int getNextPanierId() {
        return ++nextPanierId;
    }


    public void ajouterArticle(LigneDeCommande ligneDeCommande) {
        lignesDeCommande.add(ligneDeCommande);
        prixTotal += ligneDeCommande.getPrix() * ligneDeCommande.getQuantite();
    }

    public void modifierArticle(int articleId, int newQuantite) {
        for (LigneDeCommande ligneDeCommande : lignesDeCommande) {
            if (ligneDeCommande.getArticleId()== articleId) {
                prixTotal -= ligneDeCommande.getPrix() * ligneDeCommande.getQuantite();
                ligneDeCommande.setQuantite(newQuantite);
                prixTotal += ligneDeCommande.getPrix() * ligneDeCommande.getQuantite();
                break;
            }
        }
    }

    public void supprimerArticle(int articleId) {
        LigneDeCommande articleToRemove = null;
        for (LigneDeCommande ligneDeCommande : lignesDeCommande) {
            if (ligneDeCommande.getArticleId() == articleId) {
                articleToRemove = ligneDeCommande;
                break;
            }
        }
        if (articleToRemove != null) {
            lignesDeCommande.remove(articleToRemove);
            prixTotal -= articleToRemove.getPrix() * articleToRemove.getQuantite();
        }
    }

    public void confirmerAchat() {
        // Implémentez ici la logique de confirmation d'achat, par exemple enregistrement de la commande, paiement, etc.
        System.out.println("Achat confirmé !");
    }

    public float getPrixTotal() {
        return prixTotal;
    }
}
