package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Commande;

public class CommandeRequest {

  private List<Commande> commandes;

  public CommandeRequest() {
    commandes = new ArrayList<>();
  }

  public List<Commande> getCommandes() {
    return commandes;
  }

  public void setCommandes(List<Commande> commandes) {
    this.commandes = commandes;
  }
}
