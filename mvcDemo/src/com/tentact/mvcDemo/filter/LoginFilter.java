package com.tentact.mvcDemo.filter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements FileFilter {

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter����");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("loginName")==null){
			req.setAttribute("message", "����Դ��Ҫ��¼�����");
			//���ص���¼ҳ��
			req.getRequestDispatcher("../login.jsp").forward(request, response);
		}
		//���ݵ���Դ������һ����Դ
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter��ʼ��");
	}

	@Override
	public boolean accept(File arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
