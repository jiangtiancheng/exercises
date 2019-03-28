package com.tentact.mvcDemo.service;

import java.util.ArrayList;

import com.tentact.mvcDemo.dao.PersonDao;
import com.tentact.mvcDemo.vo.Person;

public class PersonService {
	PersonDao dao = new PersonDao();
	//登录业务，返回状态（。0为待审核，1为审核过了，2为审核被拒绝）
	public int login(String name,String password) {
		Person person = dao.selectPersonByNameAndPassword(name, password);
		//如果找到该人，获得他的状态
		if(person!=null) {
			return person.getStatus();
		}else {
			//没找到人
			return -1;
		}
	}
	public ArrayList<Person> getAllPerson(){
		return dao.selectAllPerson();
	}
	public boolean deletePerson(int id) {
		return dao.deletePersonById(id);
	}
	public boolean updatePerson(Person person) {
		return dao.updatePerson(person);
	}
	
	public Person getPersonById(int id) {
		return dao.selectPersonById(id);
	}
	/**
	 * 该方法实现查询
	 * */
	public ArrayList<Person> findPersonById(int id) {
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(dao.selectPersonById(id));
		return plist;
	}
}
