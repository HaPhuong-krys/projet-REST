package rest.asii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rest.asii.model.*;
import java.util.*;

public class UserDao {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/asii?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";
	String user = "root";
	String pass = "root";
	Connection cn = null;
	Statement statement = null;
	ResultSet rs = null;

	private List<User> users = new ArrayList<>();

	public List<User> testerBD() {

		try {
			
			Class.forName(driver);

			cn = DriverManager.getConnection(url, user, pass);

			// formulation de la requete pour récupérer les utilisateurs
			String requeteSQL = "SELECT * FROM user";	
			
			statement = cn.createStatement();
			rs = statement.executeQuery(requeteSQL);

			// Traitement du resultat
			System.out.println("Résultat de l'exécution de la requête de sélection :");

			//Création d'un utilisateur
			User user = new User();
			
			while (rs.next()) {

				//Complétion de l'objet 'User'
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setPasswd(rs.getString("password"));
				user.setRole(rs.getString("role"));

				System.out.println(user);	
				users.add(user);
				
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
				e.printStackTrace();
			}
		}
		
		return users;
	}	

}
