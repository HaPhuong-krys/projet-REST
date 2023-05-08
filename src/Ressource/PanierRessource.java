package Ressource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.LigneDeCommandeDAO;
import Model.LigneDeCommande;
import Model.Panier;

@Path("/panier")
public class PanierRessource {

    LigneDeCommandeDAO ligneDeCommandeDAO = LigneDeCommandeDAO.getInstance();
    Panier panier = new Panier();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Panier getPanier() {
        return panier;
    }  

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LigneDeCommande ajouterAuPanier(LigneDeCommande ligne) {
        ligneDeCommandeDAO.ajouter(ligne);
        panier.ajouterArticle(ligne);
        return ligne;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LigneDeCommande modifierLigneDeCommande(@PathParam("id") int id, LigneDeCommande ligne) {
        ligne.setCommandeId(id);
        ligneDeCommandeDAO.upDate(ligne);
        panier.modifierArticle(ligne.getArticleId(), ligne.getQuantite());
        return ligne;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void supprimerLigneDeCommande(@PathParam("id") int id) {
        LigneDeCommande ligne = ligneDeCommandeDAO.afficherLigneDeCommandeParID(id);
        ligneDeCommandeDAO.supprimer(ligne);
        panier.supprimerArticle(ligne.getArticleId());
    }

    
    //L'idee c'est que l'id du panier est le même que celui du client
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LigneDeCommande getLigneDeCommande(@PathParam("id") int id) {
        LigneDeCommande ligne = ligneDeCommandeDAO.afficherLigneDeCommandeParID(id);
        if (ligne == null) {
            throw new NotFoundException("Ligne de commande introuvable pour l'ID " + id);
        }
        return ligne;
    }


}
