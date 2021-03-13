package com.disenoAlgoritmos.edu;

public class Valores {
	
	private long duracion; 
	private int[] vector;
	
	public Valores(long posFila, int[] vector) {
        this.duracion = posFila;
        this.vector = vector;
    }

	
	public long getDuracion() {
		return duracion;
	}
	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}
	public int[] getVector() {
		return vector;
	}
	public void setVector(int[] vector) {
		this.vector = vector;
	}
	
	

}
