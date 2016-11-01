package com.TpJdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testDAO {
	
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-drabby.alwaysdata.net/drabby_testjdbc";
	static final String LOGIN = "drabby_user1";
	static final String PASSWORD = "666";
	
    public static void main (String[] args) throws SQLException {

    DAOEtudiant DAOEt = DAOEtudiant.getInstance();
    DAOModule DAOMod = DAOModule.getInstance();
    DAONotation DAONote = DAONotation.getInstance();
	Connection conn = null;

    try {
    	// Connexion a la base
    				System.out.println("Connexion a " + CONNECT_URL);
    				conn = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
    				System.out.println("Connecte\n");
    				// Creation d'une instruction SQL
    				
    	@SuppressWarnings("unused")
		//Statement stmt = ConnexionUnique.getInstance().getConnection().createStatement();

    	List<Etudiant> ALEtudiant = new ArrayList<Etudiant>();
        ArrayList<Etudiant> etuAnnee2 = new ArrayList<Etudiant>();
        ALEtudiant = DAOEt.findAll();
        
        for(Etudiant e : ALEtudiant)
        {
        	if(e.getAnnee() == 2)
        	{
        		etuAnnee2.add(e);
        	}
        }
        
        ArrayList<Notation> ALNotes = new ArrayList<Notation>();
        ALNotes = DAONote.findAll();
        
        List<Notation> notesA2 = new ArrayList<Notation>();

        
        for(Etudiant e : etuAnnee2)
        {

        	for (Notation n : ALNotes)
        	{
        		if (n.getEtudiant().getNumEt() == e.getNumEt())
        		{
        			notesA2.add(n);
        		}

        	}
        }
		System.out.println("hey");	

        for(int i = 0; i < 6; i++)
        {
        	Notation n = new Notation();
        	n = notesA2.get(i);
    		System.out.println("hola");	

        	if(n.getModule().getCode().equals("ACSI"))
        	{
        		System.out.print(n.getEtudiant().getPrenomEt() + " " 
        					   + n.getEtudiant().getNomEt() + " | MoyCC : " 
        					   + n.getMoyCC() + " + 1 = ");
        		n.setMoyCC(n.getMoyCC()+1);
        		System.out.print(n.getMoyCC() + "; MoyTest : " + n.getMoyTest() + " + 1 = ");
        		n.setMoyTest(n.getMoyTest()+1);
        		System.out.println(n.getMoyTest());	
        	}
        }
    }
    catch ( SQLException e ) {
        e.printStackTrace() ; // Arggg!!!
        System.out.println(e. getMessage() + "\n" ) ;
    }

    finally {
        if ( conn != null ) {
    		System.out.println("stop");	

            conn.close();
        }
    }
}



}