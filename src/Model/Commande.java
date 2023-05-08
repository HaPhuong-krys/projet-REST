package Model;
public class Commande {

	private int id;
    private int articleId;
    private String articleName;
    private int prix;
    private int quantite;

    public Commande() {}
    public Commande(int id, int articleId, String articleName, int prix, int quantite) {
        this.id = id;
        this.articleId = articleId;
        this.articleName = articleName;
        this.prix = prix;
        this.quantite = quantite;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
    




}
