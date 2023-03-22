package rest.asii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import rest.asii.model.*;


public enum ArticlesDao {
    instance;

    private Map<String, Article> articles = new HashMap<>();

    private ArticlesDao() {}
       
 		String driver = "com.mysql.jdbc.Driver";
 		String url = "jdbc:mysql://localhost:3306/asii";
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
 			String requeteSQL = "Select * from asii.articles";	
 			
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
              Article article = new Article(id, libelle, marque, prix, categorie, description);
              this.articles.put(id, article);
              System.out.println(article);
 				
 			}
 			}catch(Exception es) {}
 	
 }
 		
 		   public Map<String, Article> getModel(){
 		        return articles;
 		    } 

}