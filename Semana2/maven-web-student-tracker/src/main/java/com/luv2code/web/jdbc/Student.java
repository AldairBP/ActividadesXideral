package com.luv2code.web.jdbc;

public class Student {

	private int id;
	private String nombre;
	private String apellido;
	private String email;

	public Student(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public Student(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.nombre = firstName;
		this.apellido = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return nombre;
	}

	public void setFirstName(String firstName) {
		this.nombre = firstName;
	}

	public String getLastName() {
		return apellido;
	}

	public void setLastName(String lastName) {
		this.apellido = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nombre =" + nombre + ", apellido =" + apellido + ", email=" + email + "]";
	}	
}
