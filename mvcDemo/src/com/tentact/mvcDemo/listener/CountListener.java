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
		System.out.println("销毁");
		//获得上下文对象
		ServletContext sc = arg0.getServletContext();
		Integer count = (Integer)sc.getAttribute("number");
		dao.updateCount(count);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("初始化");
		//查询数据库计数
		Integer count = dao.selectCount();
		//获得上下文对象
		ServletContext sc = arg0.getServletContext();
		//对应servlet中的计数属性
		sc.setAttribute("number", count);
	}

}
