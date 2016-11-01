package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOModule {
	static private DAOModule instance;
    private Connection conn;

	
	public Module insert(Module module)
	{    
        final String req = "INSERT INTO MODULE VALUES ("
                		+ module.getCode() 			+ ", " 	+ module.getLibelle() 		+ ", "
                		+ module.gethCoursPrev() 	+ ", " 	+ module.gethCoursRea() 	+ ", "
                		+ module.gethTpPrev() 		+ ", " 	+ module.gethTpRea() 		+ ", "
                		+ module.getDiscipline() 	+ ", " 	+ module.getCoeffTest() 	+ ", " 
                		+ module.getCoeffCC()		+ ", " 	+ module.getResponsable() 	+ ", " 
                		+ module.getPere() 			+ ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
		return module;

	}
	
	public boolean delete(Module module)
	{
		final String req = "DELETE INTO MODULE WHERE CODE = " + module.getCode();
		
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
	
	public boolean update(Module module)
	{
		final String req = "UPDATE MODULE "
						 + "SET CODE = " 		+ module.getCode() 			+ ", LIBELLE = "		+ module.getLibelle()
						 + ", H_COURS_PREV = " 	+ module.gethCoursPrev() 	+ ", H_COURS_REA = " 	+ module.gethCoursRea()
						 + ", H_TP_PREV = "		+ module.gethTpPrev() 		+ ", H_TP_REA = " 		+ module.gethTpRea()
						 + ", DISCIPLINE = "	+ module.getDiscipline() 	+ ", COEFF_TEST = " 	+ module.getCoeffTest() 
						 + ", COEFF_CC = " 		+ module.getCoeffCC() 		+", RESP = " 			+ module.getResponsable() 
						 + ", CODEPERE = " 		+ module.getPere()
						 + " WHERE CODE = " 	+ module.getCode();					

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
	
	public Module getById(int code)
	{
		final String req = "SELECT * "
				+ "FROM MODULE "
				+ "WHERE CODE = " + code;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			Module module = new Module();

			if(rset.next())
			{

				Prof prof = new Prof();
			    prof.setNumProf(rset.getInt("RESP"));
				Module modulePere = new Module();
			    modulePere.setCode(rset.getString("CODEPERE"));

				module.setCode(rset.getString("CODE"));
				module.setLibelle(rset.getString("LIBELLE"));
				module.sethCoursPrev(rset.getInt("H_COURS_PREV"));
				module.sethCoursRea(rset.getInt("H_COURS_REA"));
				module.sethTpPrev(rset.getInt("H_TP_PREV"));
				module.sethTpRea(rset.getInt("H_TP_REA"));
				module.setDiscipline(rset.getString("DISCIPLINE"));
				module.setCoeffTest(rset.getInt("COEFF_TEST"));
				module.setCoeffCC(rset.getInt("COEFF_CC"));
				module.setResponsable(prof);
				module.setPere(modulePere);


				stmt.close();
			}
			return module;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Module> findAll()
	{
		final String req = "SELECT * "
				+ "FROM MODULE ";
		ArrayList<Module> ListeMod = new ArrayList<Module>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{
				Module module = new Module();
				Prof prof = new Prof();
			    prof.setNumProf(rset.getInt("RESP"));
				Module modulePere = new Module();
			    modulePere.setCode(rset.getString("CODEPERE"));

				module.setCode(rset.getString("CODE"));
				module.setLibelle(rset.getString("LIBELLE"));
				module.sethCoursPrev(rset.getInt("H_COURS_PREV"));
				module.sethCoursRea(rset.getInt("H_COURS_REA"));
				module.sethTpPrev(rset.getInt("H_TP_PREV"));
				module.sethTpRea(rset.getInt("H_TP_REA"));
				module.setDiscipline(rset.getString("DISCIPLINE"));
				module.setCoeffTest(rset.getInt("COEFF_TEST"));
				module.setCoeffCC(rset.getInt("COEFF_CC"));
				module.setResponsable(prof);
				module.setPere(modulePere);

				
				ListeMod.add(module);
				stmt.close();
			}
			return ListeMod;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	static public DAOModule getInstance()
	{
		if (instance == null)
			instance = new DAOModule();
		return instance;
	}
}
