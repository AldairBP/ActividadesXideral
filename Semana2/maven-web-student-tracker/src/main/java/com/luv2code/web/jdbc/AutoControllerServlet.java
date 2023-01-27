package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/AutoControllerServlet")
public class AutoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AutoDbUtil autoDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			autoDbUtil = new AutoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listAutos(request, response);
				break;
				
			case "ADD":
				addAuto(request, response);
				break;
				
			case "LOAD":
				loadAuto(request, response);
				break;
				
			case "UPDATE":
				updateAuto(request, response);
				break;
			
			case "DELETE":
				deleteAuto(request, response);
				break;
				
			default:
				listAutos(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteAuto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theAutoId = request.getParameter("autoId");
		
		// delete student from database
		autoDbUtil.deleteAuto(theAutoId);
		
		// send them back to "list students" page
		listAutos(request, response);
	}

	private void updateAuto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("AutoId"));
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String matricula = request.getParameter("matricula");
		
		// create a new student object
		Auto theAuto = new Auto(id, modelo, marca, matricula);
		
		// perform update on database
		autoDbUtil.updateAuto(theAuto);
		
		// send them back to the "list students" page
		listAutos(request, response);
		
	}

	private void loadAuto(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theAutoId = request.getParameter("autoId");
		
		// get student from database (db util)
		Auto theAuto = autoDbUtil.getAuto(theAutoId);
		
		// place student in the request attribute
		request.setAttribute("THE_AUTO", theAuto);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-auto-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addAuto(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String matricula = request.getParameter("matricula");		
		
		// create a new student object
		Auto theAuto = new Auto(modelo, marca, matricula);
		
		// add the student to the database
		autoDbUtil.addAuto(theAuto);
				
		// send back to main page (the student list)
		listAutos(request, response);
	}

	private void listAutos(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Auto> auto = autoDbUtil.getAuto();
		
		// add students to the request
		request.setAttribute("AUTO_LIST", auto);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-autos.jsp");
		dispatcher.forward(request, response);
	}

}













