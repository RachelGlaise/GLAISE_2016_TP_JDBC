package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class testAsso1 {
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-drabby.alwaysdata.net/drabby_testjdbc";
	static final String LOGIN = "drabby_user1";
	static final String PASSWORD = "666";
	// La requete de test
	static final String req = "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF, MAT_SPEC " +
	                          "FROM PROF ";                                     
	
	static ArrayList<Prof> ListeProf = new ArrayList<Prof>();	 

	
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
				Prof prof = new Prof();
				Module specialite = new Module();
				specialite.setCode(rset.getString("MAT_SPEC"));//faire pour tous les parametres 
				prof.setNumProf(rset.getInt("NUM_PROF"));
				prof.setNomProf(rset.getString("NOM_PROF"));
				prof.setPrenomProf(rset.getString("PRENOM_PROF"));
				//prof.setEstSpecialiste(rset.getString("MAT_SPEC"));

				prof.setEstSpecialiste(specialite);
				ListeProf.add(prof);

			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println(ListeProf);
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

