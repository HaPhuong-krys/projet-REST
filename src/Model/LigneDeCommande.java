package Model;

public class LigneDeCommande {
	private int commande_id;
	private int art_id;
	private int quantite;
	private float prix;
	private int panier_id;
	public LigneDeCommande() {}
	public LigneDeCommande(int commande_id, int art_id, int quantite, float prix, int panier_id) {
		super();
		this.commande_id = commande_id;
		this.art_id = art_id;
		this.quantite = quantite;
		this.prix = prix;
		this.panier_id = panier_id;
	}
	public int getCommandeId() {
		return commande_id;
	}
	public void setCommandeId(int commande_id) {
		this.commande_id = commande_id;
	}
	public int getArticleId() {
		return art_id;
	}
	public void setArticleId(int art_id) {
		this.art_id = art_id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getPanier_id() {
		return panier_id;
	}
	public void setPanier_id(int panier_id) {
		this.panier_id = panier_id;
	}
	
	
}
