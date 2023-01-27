package com.luv2code.web.jdbc;

public class Auto {
	
	private int id;
	private String modelo;
	private String marca;
	private String matricula;
	
	public Auto(String modelo, String marca, String matricula) {
		this.modelo = modelo;
		this.marca = marca;
		this.matricula = matricula;
	}

	public Auto(int id, String modelo, String marca, String matricula) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.matricula = matricula;
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
		return "Auto [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", matricula=" + matricula + "]";
	}
}
