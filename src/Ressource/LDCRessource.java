package Ressource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.LigneDeCommandeDAO;
import Model.LigneDeCommande;

@Path("/lignes-de-commande")
public class LDCRessource {

    LigneDeCommandeDAO ligneDeCommandeDAO = LigneDeCommandeDAO.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LigneDeCommande> getLignesDeCommande() {
        return ligneDeCommandeDAO.afficherLignesDeCommande();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LigneDeCommande getLigneDeCommande(@PathParam("id") int id) {
        return ligneDeCommandeDAO.afficherLigneDeCommandeParID(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LigneDeCommande addLigneDeCommande(LigneDeCommande ligne) {
        ligneDeCommandeDAO.ajouter(ligne);
        return ligne;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LigneDeCommande updateLigneDeCommande(@PathParam("id") int id, LigneDeCommande ligne) {
        ligne.setCommandeId(id);
        ligneDeCommandeDAO.upDate(ligne);
        return ligne;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteLigneDeCommande(@PathParam("id") int id) {
        LigneDeCommande ligne = ligneDeCommandeDAO.afficherLigneDeCommandeParID(id);
        ligneDeCommandeDAO.supprimer(ligne);
    }
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LigneDeCommande> getLignesDeCommandeByUser(@PathParam("userId") int userId) {
        return ligneDeCommandeDAO.afficherLignesDeCommandeParClient(userId);
    }

    
}
