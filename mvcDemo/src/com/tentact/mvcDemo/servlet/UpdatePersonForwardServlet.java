package com.tentact.mvcDemo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tentact.mvcDemo.service.PersonService;
import com.tentact.mvcDemo.vo.Person;

/**
 * Servlet implementation class UpdatePersonForwardServlet
 */
@WebServlet("/UpdatePersonForwardServlet")
public class UpdatePersonForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonService service = new PersonService();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Person person = service.getPersonById(id);
		request.setAttribute("person", person);
		request.getRequestDispatcher("personUpdate2.jsp").forward(request, response);
	}

}
