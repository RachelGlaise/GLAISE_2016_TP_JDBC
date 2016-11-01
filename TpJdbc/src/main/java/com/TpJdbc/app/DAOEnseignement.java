package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOEnseignement {
	static private DAOEnseignement instance;
    private Connection conn;

	
	public Enseignement insert(Enseignement esgn)
	{    
        final String req = "INSERT INTO ENSEIGNT VALUES ("
                		+ esgn.getModule().getCode() 		+ ", " 	+ esgn.getProf().getNumProf() 		+ ", "
                		+ esgn.getEtudiant().getNumEt() 	+ ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
		return esgn;

	}
	
	public boolean delete(Enseignement esgn)
	{
		final String req = "DELETE INTO ENSEIGNT WHERE CODE = " + esgn.getModule().getCode() 
						+ " AND NUM_PROF = " + esgn.getProf().getNumProf() 
						+ " AND NUM_ET = " + esgn.getEtudiant().getNumEt();
		
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
	
	public boolean update(Enseignement esgn)
	{
		final String req = "UPDATE ENSEIGNT "
						 + "SET CODE = " 	+ esgn.getModule().getCode() 	
						 + ", NUM_PROF = " 	+ esgn.getProf().getNumProf() 	
						 + ", NUM_ET = "		+ esgn.getEtudiant().getNumEt();					

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
	
	public Enseignement getById(String code, int numProf, int numEt )
	{
		final String req = "SELECT * "
				+ "FROM ENSEIGNT "
				+ "WHERE NUM_PROF = " + numProf + " AND CODE = " + code + " AND NUM_ET = " + numEt;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			Enseignement esgn = new Enseignement();
			if(rset.next())
			{
				Module module = new Module();
			    module.setCode(rset.getString("CODE"));
			    Prof prof = new Prof();
			    prof.setNumProf(rset.getInt("NUM_PROF"));
			    Etudiant etudiant = new Etudiant();
			    etudiant.setNumEt(rset.getInt("NUM_ET"));

				esgn.setModule(module);
				esgn.setEtudiant(etudiant);
				esgn.setProf(prof);

				stmt.close();
			}
			return esgn;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Enseignement> findAll()
	{
		final String req = "SELECT * "
				+ "FROM PROF ";
		ArrayList<Enseignement> ListeEnseignement = new ArrayList<Enseignement>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			Enseignement esgn = new Enseignement();

			if(rset.next())
			{
				Module module = new Module();
			    module.setCode(rset.getString("CODE"));
			    Prof prof = new Prof();
			    prof.setNumProf(rset.getInt("NUM_PROF"));
			    Etudiant etudiant = new Etudiant();
			    etudiant.setNumEt(rset.getInt("NUM_ET"));

				esgn.setModule(module);
				esgn.setEtudiant(etudiant);
				esgn.setProf(prof);

				stmt.close();
			}
			return ListeEnseignement;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	static public DAOEnseignement getInstance()
	{
		if (instance == null)
			instance = new DAOEnseignement();
		return instance;
	}
}


