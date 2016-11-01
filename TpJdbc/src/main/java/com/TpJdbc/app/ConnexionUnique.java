package com.TpJdbc.app;

import java.sql.*;


public class ConnexionUnique {

	private Connection connection;
	static private ConnexionUnique instance;

	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-drabby.alwaysdata.net/drabby_testjdbc";
	static final String LOGIN = "drabby_user1";
	static final String PASSWORD = "666";

	private ConnexionUnique() {
		super();
		// Connexion a la base
		try {
			System.out.println("Connexion a " + CONNECT_URL);
			connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
			System.out.println("Connecte\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;

	}

	public static ConnexionUnique getInstance() {
		if (instance == null)
			instance = new ConnexionUnique();
		return instance;
	}
		
}
