package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectData;
import Model.Panier;

public class PanierDAO {
	
	private List<Panier> paniers = new ArrayList<>();
	
	public static PanierDAO getInstance() {
		return new PanierDAO();
	}
	
	
	
	public void ajouter(Panier p) {
		try {
			Connection con = ConnectData.getConnect();
			String sql = "INSERT INTO panier(client_id, total) VALUES(?,?)";
			PreparedStatement s = con.prepareStatement(sql);
				s.setInt(1, p.getClientId());
				s.setDouble(2, p.getTotal());
				
			s.executeUpdate();
			ConnectData.closeConnect(con);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void upDate(Panier p) {
		try {	
			Connection con = ConnectData.getConnect();
			String sql = "UPDATE panier SET client_id = ?, total = ? WHERE id = ?";
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, p.getClientId());
			s.setDouble(2, p.getTotal());
			s.setInt(3, p.getId());
			
			s.executeUpdate();
			ConnectData.closeConnect(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int supprimer(Panier p) {
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String sql = "DELETE from panier WHERE id = " + p.getId();
						
			int res = s.executeUpdate(sql);
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Ajouter d'autres méthodes pour gérer les paniers si nécessaire
}
