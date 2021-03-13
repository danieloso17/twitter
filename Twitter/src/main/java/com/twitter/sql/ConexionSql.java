package com.twitter.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.twitter.edu.Constants;

public class ConexionSql implements Constants {

	Connection conn = null;
	Statement stmt = null;
	ResultSet result = null;

	@SuppressWarnings("deprecation")
	public Connection conexion() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(DRIVE).newInstance();
			conn = DriverManager.getConnection(URL, USER, PASS);
			if (conn != null) {
				System.out.println("Conexion exitosa");
			} else {
				System.out.println("Error en la conexion");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

	public ResultSet ejecutarConsulta(Connection con) {
		ResultSet rs = null;
		try {
			String sql = "SELECT [idDatosconsulta], [Consulta] FROM [compensar].[dbo].[DatosConsulta];";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void insert(Connection con, int idDatosConsulta, String texto, String fecha, String retweet,
			String favoritos, String idioma, String localizacion) {
		try {
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO [dbo].[Tweet] ([idDatosConsulta],[texto],[fecha],[retweet],[favoritos],[idioma],[localizacion]) "
							+ "     VALUES(?, ?, ?, ?, ?, ?, ?)");
			System.out.println();
			stmt.setInt(1, idDatosConsulta);
			stmt.setString(2, texto);
			stmt.setString(3, fecha);
			stmt.setString(4, retweet);
			stmt.setString(5, favoritos);
			stmt.setString(6, idioma);
			stmt.setString(7, localizacion);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConexcion(Connection con) throws SQLException {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
