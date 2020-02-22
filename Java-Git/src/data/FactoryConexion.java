package data;

import java.sql.*;


public class FactoryConexion {
	private static FactoryConexion instancia;
	
	private String driver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String db="taller_mecanico";
	private String user="root";
	private String pass="852456ale";
	
	private Connection conn=null;
	private int conectados=0;
	
	private FactoryConexion() {
		try {
				Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FactoryConexion getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
				if (conn == null || conn.isClosed()) {
					conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?serverTimezone=UTC", user, pass);
					conectados=0;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
				if (conectados == 0) {
					conn.close();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}