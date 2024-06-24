package Factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//até o projeto ja funciona, o que vem depois é para garantir
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bdprojeto05?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "120322";

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
	}
		


	
}
