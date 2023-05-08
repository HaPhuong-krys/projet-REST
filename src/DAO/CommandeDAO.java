package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectData;
import Model.Commande;

public class CommandeDAO {
    private List<Commande> commandes = new ArrayList<>();

    public static CommandeDAO getInstance() {
        return new CommandeDAO();
    }

    public void creerCommande(Commande commande) {
    	  try {
    	    Connection con = ConnectData.getConnect();
    	    String requeteSQL = "INSERT INTO commandes (article_id, article_name, prix, quantite) VALUES (?, ?, ?, ?)";
    	    PreparedStatement ps = con.prepareStatement(requeteSQL);
    	    ps.setInt(1, commande.getArticleId());
    	    ps.setString(2, commande.getArticleName());
    	    ps.setInt(3, commande.getPrix());
    	    ps.setInt(4, commande.getQuantite());
    	    ps.executeUpdate();
    	    ConnectData.closeConnect(con);
    	  } catch (SQLException e) {
    	    e.printStackTrace();
    	  } catch (Exception e) {
    	    e.printStackTrace();
    	  }
    	}


    public List<Commande> afficherListeCommandes() {
        try {
            Connection con = ConnectData.getConnect();
            Statement s = con.createStatement();
            String requeteSQL = "SELECT * FROM commandes";

            ResultSet rs = s.executeQuery(requeteSQL);
            System.out.println("COMMANDES:");

            while (rs.next()) {
                Commande commande = new Commande();
                commande.setId(rs.getInt("id"));
                commande.setArticleId(rs.getInt("article_id"));
                commande.setArticleName(rs.getString("article_name"));
                commande.setPrix(rs.getInt("prix"));
                commande.setQuantite(rs.getInt("quantite"));

                commandes.add(commande);
            }
            ConnectData.closeConnect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commandes;
    }
}
