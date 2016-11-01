package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAONotation {

	static private DAONotation instance;
    private Connection conn;

	
	public Notation insert(Notation notation)
	{    
        final String req = "INSERT INTO NOTATION VALUES ("
                		+ notation.getEtudiant().getNumEt() 		+ ", " 	+ notation.getModule().getCode() 		+ ", "
                		+ notation.getMoyCC() 						+ ", " 	+ notation.getMoyTest() 				+ ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
		return notation;

	}
	
	public boolean delete(Notation notation)
	{
		final String req = "DELETE INTO NOTATION WHERE CODE = " + notation.getModule().getCode()
							+ " AND NUM_ET = " + notation.getEtudiant().getNumEt();
		
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
	
	public boolean update(Notation notation)
	{
		final String req = "UPDATE NOTATION "
						 + "SET NUM_ET = " 	+ notation.getEtudiant().getNumEt() 	+ ", CODE = "		+ notation.getModule().getCode()
						 + ", MOY_CC = " 	+ notation.getMoyCC() 	+ ", MOY_TEST = " 	+ notation.getMoyCC() 	
						 + " WHERE CODE = " + notation.getModule().getCode()
						         + " AND NUM_ET = " + notation.getEtudiant().getNumEt();					

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
	
	public Notation getById(int numEt, String code)
	{
		final String req = "SELECT * "
				+ "FROM NOTATION "
				+ "WHERE NUM_ET = " + numEt
				+ " AND CODE = " + code;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(req);
			Notation notation = new Notation();
			if(rset.next())
			{
				Module module = new Module();
			    module.setCode(rset.getString("CODE"));
			    Etudiant etudiant = new Etudiant();
			    etudiant.setNumEt(rset.getInt("NUM_ET"));
			    
				notation.setModule(module);
				notation.setEtudiant(etudiant);
				notation.setMoyCC(rset.getInt("MOY_CC"));
				notation.setMoyTest(rset.getInt("MOY_TEST"));
				stmt.close();
			
			}
			return notation;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Notation> findAll()
	{
		final String req = "SELECT * "
				+ "FROM NOTATION ";
		ArrayList<Notation> ListeNotation = new ArrayList<Notation>();
		
		try {
			Statement stmt = ConnexionUnique.getInstance().getConnection().createStatement();

			ResultSet rset = stmt.executeQuery(req);
			if(rset.next())
			{

				Module module = new Module();
			    module.setCode(rset.getString("CODE"));
			    Etudiant etudiant = new Etudiant();
			    etudiant.setNumEt(rset.getInt("NUM_ET"));
			    
				Notation notation = new Notation();

				notation.setModule(module);
				notation.setEtudiant(etudiant);
				notation.setMoyCC(rset.getInt("MOY_CC"));
				notation.setMoyTest(rset.getInt("MOY_TEST"));
				stmt.close();
			}
			return ListeNotation;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	static public DAONotation getInstance()
	{
		if (instance == null)
			instance = new DAONotation();
		return instance;
	}
}
