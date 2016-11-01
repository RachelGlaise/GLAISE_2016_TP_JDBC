package com.TpJdbc.app;

import java.sql.*;
import java.util.ArrayList;



public class testEntite {
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-drabby.alwaysdata.net/drabby_testjdbc";
	static final String LOGIN = "drabby_user1";
	static final String PASSWORD = "666";
	// La requete de test
	static final String req = "SELECT * " +
	                          "FROM ETUDIANT " +
	                          "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";    
	
	static ArrayList<Etudiant> ListeEt = new ArrayList<Etudiant>();	 
	
	
	public static void main(String[] args) throws SQLException {
		// Objet materialisant la connexion a la base de donnees
		Connection conn = null;
		try {
			// Connexion a la base
			System.out.println("Connexion a " + CONNECT_URL);
			conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
			System.out.println("Connecte\n");
			// Creation d'une instruction SQL
			Statement stmt = conn.createStatement();
			// Execution de la requete
			System.out.println("Execution de la requete : " + req );
			ResultSet rset = stmt.executeQuery(req);
			// Affichage du resultat
			while (rset.next()){	
				Etudiant etu = new Etudiant();
				etu.setNumEt((rset.getInt("NUM_ET")));
				etu.setNomEt((rset.getString("NOM_ET")));
				etu.setPrenomEt((rset.getString("PRENOM_ET")));					
				
				ListeEt.add(etu);

				System.out.println(etu.toString());
				

			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println("\nOk.\n");
		} catch (SQLException e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		} finally {
			if (conn != null) {
				// Deconnexion de la base de donnees
				conn.close();
			}
		}
	}
}