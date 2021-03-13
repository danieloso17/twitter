package com.disenoAlgoritmos.edu;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {

	static int cantidad = 100;

	public  int[] llenaVector(int[] vector) {
		System.out.println("LLenando vector....");
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Random().nextInt(4000);
			System.out.print(vector[i] + "\t");

		}
		System.out.println();
		return vector;
	}

	public  <E> Valores burbuja(int[] A) {
		
		Valores valores;
		
		int i, j, aux;
		long startTime = System.nanoTime();
		for (i = 0; i < A.length - 1; i++) {
			for (j = 0; j < A.length - i - 1; j++) {
				if (A[j + 1] < A[j]) {
					aux = A[j + 1];
					A[j + 1] = A[j];
					A[j] = aux;
				}
			}
		}

		long endTime = System.nanoTime();
		endTime = (long) (endTime - startTime);
		valores = new Valores(endTime, A);
		return valores;
	}

	

	public  int[] quicksort(int arreglo[], int primero, int ultimo) {
		int central, i, j;
		int pivote;
		central = (primero + ultimo) / 2;
		pivote = arreglo[central];
		i = primero;
		j = ultimo;
		do {
			while (arreglo[i] < pivote)
				i++;
			while (arreglo[j] > pivote)
				j--;
			if (i <= j) {
				int temp;
				temp = arreglo[i];
				arreglo[i] = arreglo[j]; /* intercambia A[i] con A[j] */
				arreglo[j] = temp;
				i++;
				j--;
			}
		}

		while (i <= j);
		if (primero < j)
			quicksort(arreglo, primero, j); /* mismo proceso con sublista izquierda */
		if (i < ultimo)
			quicksort(arreglo, i, ultimo); /* mismo proceso con sublista derecha */
		
		return arreglo;
	}


	public  Valores duracionQu(int vector[]) {
		
		Valores valores;
		long startTime = System.nanoTime();
		int[] response = quicksort(vector, 0, vector.length - 1);
		long endTime = System.nanoTime();
		endTime = (long) (endTime - startTime);
		valores = new Valores(endTime, response);
		return valores;
	}

	public void imprimirVector (int vector[]) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + "\t");

		}
	}

}
