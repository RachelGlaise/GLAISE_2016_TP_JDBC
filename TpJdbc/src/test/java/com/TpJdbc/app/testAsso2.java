package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class testAsso2 {
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-drabby.alwaysdata.net/drabby_testjdbc";
	static final String LOGIN = "drabby_user1";
	static final String PASSWORD = "666";
	// La requete de test
	static final String req = "SELECT DISTINCT ANNEE, GROUPE, ET.NUM_ET, P.NUM_PROF, PRENOM_PROF, NOM_PROF, M.CODE, LIBELLE "
							+ "FROM ENSEIGNT E JOIN ETUDIANT ET ON E.NUM_ET = ET.NUM_ET "
								+ "JOIN MODULE M ON M.CODE = E.CODE "
								+ "JOIN PROF P ON P.NUM_PROF = E.NUM_PROF ";
	
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
			
			ArrayList<Enseignement> listeEnseignement = new ArrayList<>();
			
			while (rset.next())
			{
				Enseignement ens = new Enseignement();
                Etudiant etudiant = new Etudiant();
                Module module = new Module();
                Prof prof = new Prof();

                etudiant.setNumEt(rset.getInt("ET.NUM_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                module.setCode(rset.getString("CODE"));
                module.setLibelle(rset.getString("LIBELLE"));
                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));

                ens.setEtudiant(etudiant);
                ens.setModule(module);
                ens.setProf(prof);

                etudiant.addEnseignement(ens);
                prof.addEnseignement(ens);

                listeEnseignement.add(ens);
			}
			
			Set<Enseignement> ensPremGroupe = new HashSet<Enseignement>();
            for(Enseignement ens : listeEnseignement)
            {
                if(ens.getEtudiant().getGroupe() == 1) ensPremGroupe.add(ens);
            }
            for(Enseignement ens : ensPremGroupe) {
                System.out.println("Annee " + ens.getEtudiant().getAnnee() + " - Groupe " + ens.getEtudiant().getGroupe() 
                							+ " - Etudiant n" + ens.getEtudiant().getNumEt()+ " - Module : " 
                							+ ens.getModule().getCode() + " (" + ens.getModule().getLibelle()
                							+ "), Prof n" + ens.getProf().getNumProf() + " (" + ens.getProf().getPrenomProf() 
                							+ " " + ens.getProf().getNomProf() +")");
            }
			
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
