package com.tentact.mvcDemo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tentact.mvcDemo.dao.VisitCountDao;

public class CountListener implements ServletContextListener {
	VisitCountDao dao= new VisitCountDao();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("����");
		//��������Ķ���
		ServletContext sc = arg0.getServletContext();
		Integer count = (Integer)sc.getAttribute("number");
		dao.updateCount(count);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("��ʼ��");
		//��ѯ���ݿ����
		Integer count = dao.selectCount();
		//��������Ķ���
		ServletContext sc = arg0.getServletContext();
		//��Ӧservlet�еļ�������
		sc.setAttribute("number", count);
	}

}
