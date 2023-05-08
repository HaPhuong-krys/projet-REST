package Ressource;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import DAO.CommandeDAO;
import Model.Commande;
import Model.CommandeRequest;

@Path("/commandes")
public class CommandeRessource {
	private CommandeDAO commandeDAO = CommandeDAO.getInstance();

	@POST
	@Path("/creer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void creerCommande(CommandeRequest commandeRequest) {
	  for (Commande commande : commandeRequest.getCommandes()) {
	    commandeDAO.creerCommande(commande);
	  }
	}

    /**@POST
    @Path("/creer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void creerCommande(Commande commande) {
        commandeDAO.creerCommande(commande);
    }**/

    @GET
    @Path("/afficher")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> afficherListeCommandes() {
        return commandeDAO.afficherListeCommandes();
    }
}
