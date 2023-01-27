package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class AutoDbUtil {

	private DataSource dataSource;

	public AutoDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Auto> getAuto() throws Exception {
		
		List<Auto> auto = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from auto order by marca";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String modelo = myRs.getString("first_name");
				String marca = myRs.getString("last_name");
				String matricula = myRs.getString("email");
				
				// create new student object
				Auto tempAuto = new Auto(id, modelo, marca, matricula);
				
				// add it to the list of students
				auto.add(tempAuto);				
			}
			
			return auto;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addAuto(Auto theAuto) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into auto "
					   + "(modelo, marca, matricula) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theAuto.getModelo());
			myStmt.setString(2, theAuto.getMarca());
			myStmt.setString(3, theAuto.getMatricula());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Auto getAuto(String theAutoId) throws Exception {

		Auto theAuto = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int autoId;
		
		try {
			// convert student id to int
			autoId = Integer.parseInt(theAutoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from auto where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, autoId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String modelo = myRs.getString("modelo");
				String marca = myRs.getString("marca");
				String matricula = myRs.getString("matricula");
				
				// use the studentId during construction
				theAuto = new Auto(autoId, modelo, marca, matricula);
			}
			else {
				throw new Exception("Could not find auto id: " + autoId);
			}				
			
			return theAuto;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateAuto(Auto theAuto) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update auto "
						+ "set modelo=?, marca=?, matricula=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theAuto.getModelo());
			myStmt.setString(2, theAuto.getMarca());
			myStmt.setString(3, theAuto.getMatricula());
			myStmt.setInt(4, theAuto.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteAuto(String theAutoId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int autoId = Integer.parseInt(theAutoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from auto where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, autoId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















