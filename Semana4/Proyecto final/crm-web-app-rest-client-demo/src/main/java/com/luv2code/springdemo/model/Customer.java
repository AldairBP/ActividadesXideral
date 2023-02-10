package com.luv2code.springdemo.model;

public class Customer {

	private int id;
	
	private String modelo;
	
	private String marca;
	
	private String matricula;
	
	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", matricula=" + matricula + "]";
	}
		
}





