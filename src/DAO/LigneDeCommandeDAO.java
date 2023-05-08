package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectData;
import Model.LigneDeCommande;

public class LigneDeCommandeDAO {
	
	private List<LigneDeCommande> lignesDeCommande = new ArrayList<>();

	public static LigneDeCommandeDAO getInstance() {
		return new LigneDeCommandeDAO();
	}

	public void ajouter(LigneDeCommande l) {
		try {
			Connection con = ConnectData.getConnect();
			String sql = "INSERT INTO lignes_de_commande(commande_id, article_id, quantite, prix, panier_id) VALUES(?,?,?,?,?) WHERE ";
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, l.getCommandeId());
			s.setInt(2, l.getArticleId());
			s.setInt(3, l.getQuantite());
			s.setDouble(4, l.getQuantite() * getPrixArticle(l.getArticleId()));
			s.setInt(5, l.getPanier_id());
			s.executeUpdate();
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// Ajout de la méthode pour récupérer le prix d'un article en fonction de son ID
	public double getPrixArticle(int articleId) {
		double prix = 0;
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "SELECT prix FROM article WHERE id=" + articleId;
			ResultSet rs = s.executeQuery(requeteSQL);

			if (rs.next()) {
				prix = rs.getDouble("prix");
			}
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prix;
	}

	public void upDate(LigneDeCommande l) {
		try {
			Connection con = ConnectData.getConnect();
			String sql = "UPDATE lignes_de_commande SET commande_id = ?, article_id = ?, quantite = ? prix = ? panier_id = ? WHERE commande_id = ?";
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, l.getCommandeId());
			s.setInt(2, l.getArticleId());
			s.setInt(3, l.getQuantite());
			s.setInt(4, l.getPanier_id());
			s.setInt(5, l.getCommandeId());
			s.executeUpdate();
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int supprimer(LigneDeCommande l) {
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String sql = "DELETE from lignes_de_commande WHERE commande_id = " + l.getCommandeId();
			int res = s.executeUpdate(sql);
			ConnectData.closeConnect(con);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<LigneDeCommande> afficherLignesDeCommande() {
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "SELECT * from lignes_de_commande";
			ResultSet rs = s.executeQuery(requeteSQL);

			while (rs.next()) {
				LigneDeCommande ligne = new LigneDeCommande();
				ligne.setCommandeId(rs.getInt("commande_id"));
				ligne.setArticleId(rs.getInt("article_id"));
				ligne.setQuantite(rs.getInt("quantite"));
				ligne.setPrix(rs.getFloat("prix"));
				ligne.setPanier_id(rs.getInt("panier_id"));
				lignesDeCommande.add(ligne);
			}
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignesDeCommande;
	}

	public LigneDeCommande afficherLigneDeCommandeParID(int id) {
		LigneDeCommande ligne = new LigneDeCommande();
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "SELECT * FROM lignes_de_commande WHERE commande_id=" + id;
			ResultSet rs = s.executeQuery(requeteSQL);

			if (rs.next()) {
				ligne.setCommandeId(rs.getInt("commande_id"));
				ligne.setArticleId(rs.getInt("article_id"));
				ligne.setQuantite(rs.getInt("quantite"));
				ligne.setPrix(rs.getFloat("prix"));
				ligne.setPanier_id(rs.getInt("panier_id"));
			}
			System.out.println(ligne.getArticleId());
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligne;
	}

	
	public List<LigneDeCommande> afficherLignesDeCommandeParClient(int clientId) {
	    List<LigneDeCommande> lignesDeCommande = new ArrayList<>();
	    try {
			Connection conn = ConnectData.getConnect();
	        PreparedStatement st = conn.prepareStatement("SELECT * FROM lignes_de_commande WHERE panier_id IN (SELECT idpanier FROM panier WHERE client_id = ?)");
	        st.setInt(1, clientId);
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	            LigneDeCommande ldc = new LigneDeCommande();
	            ldc.setCommandeId(rs.getInt("commande_id"));
	            ldc.setArticleId(rs.getInt("article_id"));
	            ldc.setQuantite(rs.getInt("quantite"));
	            ldc.setPrix(rs.getFloat("prix"));
	            ldc.setPanier_id(rs.getInt("panier_id"));
	            lignesDeCommande.add(ldc);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lignesDeCommande;
	}

	
	
	
}



