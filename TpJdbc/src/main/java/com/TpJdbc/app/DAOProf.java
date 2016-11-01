package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOProf {
	static private DAOProf instance;
    private Connection conn;

	
	public Prof insert(Prof prof)
	{    
        final String req = "INSERT INTO MODULE VALUES ("
                		+ prof.getNumProf() 		+ ", " 	+ prof.getNomProf() 		+ ", "
                		+ prof.getPrenomProf() 		+ ", " 	+ prof.getAdrProf() 		+ ", "
                		+ prof.getCpProf() 			+ ", " 	+ prof.getVilleProf() 		+ ", "
                		+ prof.getEstSpecialiste()	+ ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
		return prof;

	}
	
	public boolean delete(Prof prof)
	{
		final String req = "DELETE INTO MODULE WHERE CODE = " + prof.getNumProf();
		
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
	
	public boolean update(Prof prof)
	{
		final String req = "UPDATE MODULE "
						 + "SET NUM_PROF = " 	+ prof.getNumProf() 	+ ", NOM_PROF = "		+ prof.getNomProf()
						 + ", PRENOM_PROF = " 	+ prof.getPrenomProf() 	+ ", ADR_PROF = " 		+ prof.getAdrProf()
						 + ", CP_PROF = "		+ prof.getCpProf() 		+ ", VILLE_PROF = " 	+ prof.getVilleProf()
						 + ", MAT_SPEC = "		+ prof.getEstSpecialiste() 	
						 + " WHERE CODE = " 	+ prof.getNumProf();					

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
	
	public Prof getById(int numProf)
	{
		final String req = "SELECT * "
				+ "FROM PROF "
				+ "WHERE NUM_PROF = " + numProf;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			Prof prof = new Prof();
			if(rset.next())
			{

				Module moduleSpec = new Module();
			    moduleSpec.setCode(rset.getString("MAT_SPEC"));

				prof.setNumProf(rset.getInt("NUM_ET"));
				prof.setNomProf(rset.getString("NOM_ET"));
				prof.setPrenomProf(rset.getString("PRENOM_ET"));
				prof.setAdrProf(rset.getString("ADR_PROF"));
				prof.setCpProf(rset.getString("CP_PROF"));
				prof.setVilleProf(rset.getString("VILLE_PROF"));
				prof.setEstSpecialiste(moduleSpec);
				stmt.close();
			}
			return prof;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Prof> findAll()
	{
		final String req = "SELECT * "
				+ "FROM PROF ";
		ArrayList<Prof> ListeProf = new ArrayList<Prof>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{

				Module moduleSpec = new Module();
			    moduleSpec.setCode(rset.getString("MAT_SPEC"));
				Prof prof = new Prof();

				prof.setNumProf(rset.getInt("NUM_ET"));
				prof.setNomProf(rset.getString("NOM_ET"));
				prof.setPrenomProf(rset.getString("PRENOM_ET"));
				prof.setAdrProf(rset.getString("ADR_PROF"));
				prof.setCpProf(rset.getString("CP_PROF"));
				prof.setVilleProf(rset.getString("VILLE_PROF"));
				prof.setEstSpecialiste(moduleSpec);
				stmt.close();
			}
			return ListeProf;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	static public DAOProf getInstance()
	{
		if (instance == null)
			instance = new DAOProf();
		return instance;
	}
}
