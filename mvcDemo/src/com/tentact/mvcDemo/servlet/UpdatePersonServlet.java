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
 * Servlet implementation class UpdatePersonServlet
 */
@WebServlet("/UpdatePersonServlet")
public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonService service = new PersonService();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonServlet() {
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
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int id=Integer.parseInt(request.getParameter("id"));
		Person person = new Person(id,name,pass);
		if (service.updatePerson(person)) {
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("ShowAllPersonServlet").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("ShowAllPersonServlet").forward(request, response);
		}
	}

}
