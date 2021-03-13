package com.disenoAlgoritmos.edu;

public class Main {
	public static int cantidad = 100;
	public static int[] response;
	
	public static void main(String[] args) {
		int[] vector = new int[cantidad];
		
		App app = new App();
		Valores valores;
		
		response = app.llenaVector(vector);
		
		
		System.out.println("SE PROCEDE A ORGANIZAR EL VECTOR CON METODO BURBUJA");
		valores = app.burbuja(response);
		System.out.println("LA DURACION ES ["+valores.getDuracion()/ 1e6+"] ms");
		app.imprimirVector(valores.getVector());
		
		
		System.out.println("SE PROCEDE A ORGANIZAR EL VECTOR CON METODO QUICKSORT");
		valores = app.duracionQu(vector);
		System.out.println("LA DURACION ES [" + valores.getDuracion()/ 1e6  + "] ms");
		app.imprimirVector(valores.getVector());



	}

}
