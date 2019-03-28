package com.tentact.mvcDemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tentact.mvcDemo.vo.Person;

import util.DbUtil;

public class PersonDao {
	// �����û����������ѯ�û�
	public Person selectPersonByNameAndPassword(String name, String password) {
		Connection connection = null;// �������Ӷ���
		PreparedStatement statement = null; // ����������
		ResultSet resultSet = null; // ������������
		try {
			connection = DbUtil.getConnection();
			// 3�����������
			statement = connection.prepareStatement("select * from person where name=? and pass=?");
			statement.setString(1, name);
			statement.setString(2, password);
			// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
			resultSet = statement.executeQuery();
			// ��������
			if (resultSet.next()) {// �ж��Ƿ����
				return new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 5���ر���Դ
				DbUtil.close(connection, statement, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	// �������Ա����Ϣ
	public ArrayList<Person> selectAllPerson() {
		Connection connection = null;// �������Ӷ���
		PreparedStatement statement = null; // ����������
		ResultSet resultSet = null; // ������������
		ArrayList<Person> personList = new ArrayList<Person>();
		try {
			connection = DbUtil.getConnection();
			// 3�����������
			statement = connection.prepareStatement("select * from person");
			// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
			resultSet = statement.executeQuery();
			// ��������
			while (resultSet.next()) {// �ж��Ƿ����
				Person p = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4));
				personList.add(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 5���ر���Դ
				DbUtil.close(connection, statement, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return personList;
	}

	// ɾ������
	public boolean deletePersonById(int id) {
		Connection connection = null;// �������Ӷ���
		PreparedStatement ps = null; // ����������
		try {
			connection = DbUtil.getConnection();
			// 3�����������
			ps = connection.prepareStatement("delete from person where id=?");
			ps.setInt(1, id);
			// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
			int result = ps.executeUpdate();
			if(result>0) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 5���ر���Դ
				DbUtil.close(connection, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}
	
	// �޸Ĳ���
		public boolean updatePerson(Person person) {
			Connection connection = null;// �������Ӷ���
			PreparedStatement ps = null; // ����������
			try {
				connection = DbUtil.getConnection();
				// 3�����������
				ps = connection.prepareStatement("update person set name=?,pass=? where id=?");
				ps.setString(1, person.getName());
				ps.setString(2, person.getPassword());
				ps.setInt(3, person.getId());
				// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
				int result = ps.executeUpdate();
				if(result>0) {
					return true;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// 5���ر���Դ
					DbUtil.close(connection, ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return false;
		}
		// ����id��ѯ�û�
		public Person selectPersonById(int id) {
			Connection connection = null;// �������Ӷ���
			PreparedStatement statement = null; // ����������
			ResultSet resultSet = null; // ������������
			try {
				connection = DbUtil.getConnection();
				// 3�����������
				statement = connection.prepareStatement("select * from person where id=?");
				statement.setInt(1, id);
				// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
				resultSet = statement.executeQuery();
				// ��������
				if (resultSet.next()) {// �ж��Ƿ����
					return new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getInt(4));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// 5���ر���Դ
					DbUtil.close(connection, statement, resultSet);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return null;
		}
}
