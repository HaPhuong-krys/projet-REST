package rest.asii.model;


import rest.asii.model.Categorie;


public class Article {
	
	private String id;
    private String libelle;
    private String marque;
    private double prix;
    private Categorie categorie;
    private String photo;

    public Article(){

    }
    
    public Article (String id, String libelle, String marque, double prix, Categorie categorie, String photo){
        this.id = id;
    	this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.categorie = categorie;
        this.photo = photo;
    }
    
    public String getId() {
    	return this.id;
    }
    
    public void setId(String id) {
    	this.id = id;
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
    
	public String getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}


}