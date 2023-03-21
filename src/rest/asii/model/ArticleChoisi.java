package rest.asii.model;

public class ArticleChoisi {
	
	private Article art;
	private int quantity;
	
	public ArticleChoisi(Article art, int quantity) {
		this.art = art;
		this.quantity = quantity;
	}
	
	public double getPrixTotal() {
		return this.art.getPrix() * this.quantity;
	}
	
}
