package com.tentact.mvcDemo.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tentact.mvcDemo.service.PersonService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonService service = new PersonService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int days = 0;
		String timeLength = request.getParameter("timelength");
		if (timeLength != null) {
			days = Integer.parseInt(timeLength);
		}
		int flag = service.login(name, pass);
		if (flag == 0) {
			request.setAttribute("message", "����״̬Ϊ����ˣ������ĵȴ���");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (flag == 1) {// ��¼�ɹ�
			if (days != 0) {
				// ����cookie
				Cookie nameCookie = new Cookie("name", name);
				Cookie passCookie = new Cookie("pass", pass);
				// ����ʱ��
				nameCookie.setMaxAge(24 * 3600 * days);
				passCookie.setMaxAge(24 * 3600 * days);
				// �������Ӧ
				response.addCookie(nameCookie);
				response.addCookie(passCookie);
			}
			//���session
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(3600);//������Чʱ��
			//Ϊsession���������
			session.setAttribute("loginName", name);
			//��������Ķ���
			ServletContext sc = this.getServletContext();
			//�ж��Ƿ����number����
			if(sc.getAttribute("number")==null) {
				sc.setAttribute("number", 1);
			}
			else {
				Integer num = (Integer)sc.getAttribute("number");
				sc.setAttribute("number", num+1);
			}
			
			request.getRequestDispatcher("ShowAllPersonServlet").forward(request, response);
		} else if (flag == 2) {
			request.setAttribute("message", "����״̬Ϊ���ܾ��������ɶ��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�û����������������������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
