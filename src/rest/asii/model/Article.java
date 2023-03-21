package rest.asii.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article {
	
    private String libelle;
    private String marque;
    private double prix;
    private Categorie categorie;

    public Article(){

    }
    
    public Article (String libelle, String marque, double prix, Categorie categorie){
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.categorie = categorie;
    }

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
    
    public void affiche() {
    	System.out.println("hello");
    }


}