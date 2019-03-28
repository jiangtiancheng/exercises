package com.tentact.mvcDemo.service;

import java.util.ArrayList;

import com.tentact.mvcDemo.dao.PersonDao;
import com.tentact.mvcDemo.vo.Person;

public class PersonService {
	PersonDao dao = new PersonDao();
	//��¼ҵ�񣬷���״̬����0Ϊ����ˣ�1Ϊ��˹��ˣ�2Ϊ��˱��ܾ���
	public int login(String name,String password) {
		Person person = dao.selectPersonByNameAndPassword(name, password);
		//����ҵ����ˣ��������״̬
		if(person!=null) {
			return person.getStatus();
		}else {
			//û�ҵ���
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
	 * �÷���ʵ�ֲ�ѯ
	 * */
	public ArrayList<Person> findPersonById(int id) {
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(dao.selectPersonById(id));
		return plist;
	}
}
