package rest.asii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rest.asii.model.Article;
import rest.asii.model.Categorie;
import java.util.*;

public class GestionArticles {
	
    private Map<String, Article> articles = new HashMap<>();
    
    public GestionArticles() {}
    
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3307/Articles";
		String user = "root";
		String pass = "root";

		Connection cn = null;
		Statement statement = null;
		ResultSet rs = null;
		ResultSet rsp=null;{
			for (Map.Entry<String, Article> entry : articles.entrySet()) {
			    String key = entry.getKey();
			    Article value = entry.getValue();
			    System.out.println("Clé : " + key + ", Valeur : " + value);
			}
			
		try {
			/*
			 * 1.Chargement d'un driver Mysql
			 */
			Class.forName(driver);

			/*
			 * 2.Le driverManager tente d'instancier une connexion vers la base,
			 * en utilisant le driver instancié précédemment
			 */
			cn = DriverManager.getConnection(url, user, pass);

			// formulation de la requete
			String requeteSQL = "Select * from articles";	
			
			// creation du Statement
			 statement=cn.createStatement();
			
			 // execution de la requete
			rs = statement.executeQuery(requeteSQL);

			// Traitement du resultat
			System.out.println("Resultat de l'execution de la requete de selection:");

			while (rs.next()) {

				 String id = rs.getString("id");
                 String libelle = rs.getString("libelle");
                 String marque = rs.getString("marque");
                 double prix = rs.getDouble("prix");
                 Categorie categorie = Categorie.valueOf(rs.getString("categorie"));
                 String description = rs.getString("description");
                 // Créez un objet Article à partir des résultats et ajoutez-le à la liste des articles
                 Article article = new Article(id, libelle, marque, prix, categorie, description);
                 
                 
                 
                 try {
					this.articles.put(id, article);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}catch(Exception es) {}
		

}
		
		

}
	
	