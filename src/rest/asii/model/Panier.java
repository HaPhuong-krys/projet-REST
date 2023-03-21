package rest.asii.model;

import java.util.*;
import java.io.*;

public class Panier {
	
	private int id;
    private List<ArticleChoisi> articles;
    private double prixTotal;
  
	public Panier(int id, List<ArticleChoisi> articles) {
		this.id = id;
		this.articles = articles;
		for(ArticleChoisi a : articles) {
			this.prixTotal += a.getPrixTotal();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ArticleChoisi> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleChoisi> articles) {
		this.articles = articles;
	}

	public double getPrixTotal() {
		return prixTotal;
	}


	

}
