package com.twitter.main;

import java.sql.SQLException;

import com.twitter.controlador.Controlador;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Controlador controlador = new Controlador();
		
		controlador.ejecucionTwtter();

	}

}
