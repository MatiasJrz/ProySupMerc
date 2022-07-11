package Sup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class Conexion {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private String DB_URL = "jdbc:mysql://localhost:3306/";
	//Credenciales de la BDD
	private static final String USER ="root";
	private static final String PASS ="40889045Ma";
	
	private Connection con=null;
	private Statement stmt=null;// Objeto para realizar las declaraciones.
	private ResultSet rs=null;// Conjunto de resultados
	
	public Conexion(String db){
	    this.DB_URL += db;
	}
	
	
	public void connect() {
		try {
			Class.forName(JDBC_DRIVER);
			
//			System.out.println("Conectando a la base de datos");
			con=DriverManager.getConnection(DB_URL,USER,PASS);
			
           
//            System.out.println("Creando sentencias SQL");
            stmt=con.createStatement();// Especificamos que crearemos
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
}
