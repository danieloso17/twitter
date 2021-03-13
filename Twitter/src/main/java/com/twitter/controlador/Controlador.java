package com.twitter.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.twitter.edu.TwitterController;
import com.twitter.sql.ConexionSql;

import twitter4j.QueryResult;
import twitter4j.Status;
public class Controlador {

	public void consultaTweet(Connection con, int id, String busqueda) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			TwitterController twitterController = new TwitterController();
			ConexionSql conexionSql = new ConexionSql();
			System.out.println(twitterController.Conecxion());
			QueryResult resultQry = twitterController.query("gratis");
			int i = 1;
			do {

				List<Status> tweets = resultQry.getTweets();
				System.out.println(tweets.size());
				for (Status s : tweets) {
					System.out.println("----------------------------------------------------------");
					System.out.println(String.format("User [%s]", s.getUser().getScreenName()));
					System.out.println(s.getText());
					System.out.println("Fecha: [" + sdf.format(s.getCreatedAt()) + "]");
					System.out.println(String.format("RT[%d] FAV[%d]", s.getRetweetCount(), s.getFavoriteCount()));
					System.out.println(String.format("Idioma[%s]", s.getLang()));
					System.out.println(String.format("Localizacion[%s]", s.getUser().getLocation()));
					System.out.println("----------------------------------------------------------");
					System.out.println("INICIANDO INSERT");

					conexionSql.insert(con, id, s.getText(), sdf.format(s.getCreatedAt()).toString(),
							s.getRetweetCount() + "", s.getFavoriteCount() + "", s.getLang(),
							s.getUser().getLocation());

					System.out.println("----------------------------------------------------------");
				}
				i++;
				resultQry.nextQuery();

			} while (i <= 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ejecucionTwtter() throws ClassNotFoundException, SQLException {
		try {
			ConexionSql conexionSql = new ConexionSql();
			Connection conn = conexionSql.conexion();
			ResultSet rs = conexionSql.ejecutarConsulta(conn);

			while (rs.next()) {
				System.out.println(rs.getString("idDatosconsulta") + " " + rs.getString("Consulta"));
				consultaTweet(conn, Integer.parseInt(rs.getString("idDatosconsulta")), rs.getString("Consulta"));
			}
			
			conexionSql.closeConexcion(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
