package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOEtudiant {
	static private DAOEtudiant instance;
    private Connection conn;

	
	public Etudiant insert(Etudiant etudiant)
	{    
        final String req = "INSERT INTO ETUDIANT VALUES ("
                		+ etudiant.getNumEt() + ", " + etudiant.getNomEt() + ", "
                		+ etudiant.getPrenomEt() + ", " + etudiant.getCpEt() + ", "
                		+ etudiant.getVilleEt() + ", " + etudiant.getAnnee() + ", "
                		+ etudiant.getGroupe() + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
		return etudiant;

	}
	
	public boolean delete(Etudiant etudiant)
	{
		final String req = "DELETE INTO ETUDIANT WHERE NUM_ET = " + etudiant.getNumEt();
		
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public boolean update(Etudiant etudiant)
	{
		final String req = "UPDATE ETUDIANT "
						 + "SET NUM_ET = " + etudiant.getNumEt() + ", NOM_ET = "+ etudiant.getNomEt()
						 + ", PRENOM_ET = " + etudiant.getPrenomEt() + ", CP_ET = " + etudiant.getCpEt()
						 + ", VILLE_ET = " + etudiant.getVilleEt() + ", ANNEE = " + etudiant.getAnnee()
						 + ", GROUPE = " + etudiant.getGroupe() 
						 + " WHERE NUM_ET = " + etudiant.getNumEt();					

		try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public Etudiant getById(int numEt)
	{
		final String req = "SELECT * "
				+ "FROM ETUDIANT "
				+ "WHERE NUM_ET = " + numEt;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			Etudiant etudiant = new Etudiant();
			if(rset.next())
			{
				etudiant.setNumEt(rset.getInt("NUM_ET"));
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				etudiant.setCpEt(rset.getString("CP_ET"));
				etudiant.setVilleEt(rset.getString("VILLE_ET"));
				etudiant.setAnnee(rset.getInt("ANNEE"));
				etudiant.setGroupe(rset.getInt("GROUPE"));
				
				stmt.close();
			}
			return etudiant;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Etudiant> findAll()
	{
		final String req = "SELECT * "
				+ "FROM ETUDIANT ";
		ArrayList<Etudiant> ListeEtu = new ArrayList<Etudiant>();
		
		try {
			Statement stmt = ConnexionUnique.getInstance().getConnection().createStatement();

			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{
				Etudiant etudiant = new Etudiant();
				etudiant.setNumEt(rset.getInt("NUM_ET"));
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				etudiant.setCpEt(rset.getString("CP_ET"));
				etudiant.setVilleEt(rset.getString("VILLE_ET"));
				etudiant.setAnnee(rset.getInt("ANNEE"));
				etudiant.setGroupe(rset.getInt("GROUPE"));
				
				ListeEtu.add(etudiant);
				stmt.close();
			}
			return ListeEtu;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Etudiant> findByNom(String nomEt)
	{
		final String req = "SELECT * "
				+ "FROM ETUDIANT "
				+ " WHERE NOM_ET = " + nomEt;
		ArrayList<Etudiant> ListeEtu = new ArrayList<Etudiant>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{
				Etudiant etudiant = new Etudiant();
				etudiant.setNumEt(rset.getInt("NUM_ET"));
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				etudiant.setCpEt(rset.getString("CP_ET"));
				etudiant.setVilleEt(rset.getString("VILLE_ET"));
				etudiant.setAnnee(rset.getInt("ANNEE"));
				etudiant.setGroupe(rset.getInt("GROUPE"));
				
				ListeEtu.add(etudiant);
				stmt.close();
			}
			return ListeEtu;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Etudiant> findByGroupe(int groupe)
	{		
		final String req = "SELECT * "
				+ "FROM ETUDIANT "
				+ " WHERE GROUPE = " + groupe;
		ArrayList<Etudiant> ListeEtu = new ArrayList<Etudiant>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{
				Etudiant etudiant = new Etudiant();
				etudiant.setNumEt(rset.getInt("NUM_ET"));
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				etudiant.setCpEt(rset.getString("CP_ET"));
				etudiant.setVilleEt(rset.getString("VILLE_ET"));
				etudiant.setAnnee(rset.getInt("ANNEE"));
				etudiant.setGroupe(rset.getInt("GROUPE"));
				
				ListeEtu.add(etudiant);
				stmt.close();
			}
			return ListeEtu;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Etudiant> findByAnnee(int annee)
	{
		final String req = "SELECT * "
				+ "FROM ETUDIANT "
				+ " WHERE ANNEE = " + annee;
		ArrayList<Etudiant> ListeEtu = new ArrayList<Etudiant>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{
				Etudiant etudiant = new Etudiant();
				etudiant.setNumEt(rset.getInt("NUM_ET"));
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				etudiant.setCpEt(rset.getString("CP_ET"));
				etudiant.setVilleEt(rset.getString("VILLE_ET"));
				etudiant.setAnnee(rset.getInt("ANNEE"));
				etudiant.setGroupe(rset.getInt("GROUPE"));
				
				ListeEtu.add(etudiant);
				stmt.close();
			}
			return ListeEtu;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public float computeMoyennePonderee(Etudiant etudiant)
	{
		final String req = "SELECT MOY_TEST, MOY_CC, COEFF "
				+ "FROM NOTATION "
				+ " WHERE NUM_ET = " + etudiant.getNumEt();
		float moyenne = 0;
		float coeff = 0;

        List<Float> ListeMoy = new ArrayList<Float>();
        List<Float> ListeCoeff = new ArrayList<Float>();

		try{
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{
                ListeMoy.add(rset.getFloat("MOY_TEST") * rset.getFloat("COEFF_TEST"));
                ListeMoy.add(rset.getFloat("MOY_CC") * rset.getFloat("COEFF_CC"));
                ListeCoeff.add(rset.getFloat("COEFF_TEST"));
                ListeCoeff.add(rset.getFloat("COEFF_CC"));

			}
			
            for(float MoyenneI : ListeMoy) moyenne += MoyenneI;
            for(float CoeffI : ListeMoy) coeff += CoeffI;


            if (coeff != 0) moyenne = moyenne/coeff;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;

	}
	
	public int computeNbEtudiant()
	{
		final String req = "SELECT COUNT(*) NBE"
				+ "FROM ETUDIANT";
		int NbEtudiant = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			NbEtudiant = rset.getInt("NBE");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return NbEtudiant;
	}
	
	static public DAOEtudiant getInstance()
	{
		if (instance == null)
			instance = new DAOEtudiant();
		return instance;
	}



}
