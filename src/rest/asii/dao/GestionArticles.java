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
	
	private List<Article> articles = new ArrayList<>();
	
	
	public List<Article> testerBD() {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/asii?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";
		String user = "root";
		String pass = "root";

		Connection cn = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			
			Class.forName(driver);

			cn = DriverManager.getConnection(url, user, pass);

			// formulation de la requete pour récupérer les articles
			String requeteSQL = "Select * from articles";	
			
			 statement=cn.createStatement();
			
			rs = statement.executeQuery(requeteSQL);

			// Traitement du resultat
			System.out.println("Resultat de l'execution de la requete de selection:");

			//Création d'un article
			Article art = new Article();
			
			while (rs.next()) {

				//Complétion de l'objet 'Article'
				art.setId(rs.getString("id"));
				art.setLibelle(rs.getString("libelle"));
				art.setMarque(rs.getString("marque"));
				art.setPrix(rs.getDouble("prix"));
				art.setCategorie(rs.getString("categorie"));
				art.setPhoto(rs.getString("photo"));
				System.out.println("test");	

				System.out.println(art);	
				articles.add(art);
				
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return articles;}
	
}
	