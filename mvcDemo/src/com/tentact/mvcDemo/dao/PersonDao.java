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
	// 根据用户名和密码查询用户
	public Person selectPersonByNameAndPassword(String name, String password) {
		Connection connection = null;// 定义连接对象
		PreparedStatement statement = null; // 定义语句对象
		ResultSet resultSet = null; // 定义结果集对象
		try {
			connection = DbUtil.getConnection();
			// 3，获得语句对象
			statement = connection.prepareStatement("select * from person where name=? and pass=?");
			statement.setString(1, name);
			statement.setString(2, password);
			// 4,执行sql,查询executeQuery，返回结果集
			resultSet = statement.executeQuery();
			// 处理结果集
			if (resultSet.next()) {// 判断是否存在
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
				// 5，关闭资源
				DbUtil.close(connection, statement, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	// 获得所有员工信息
	public ArrayList<Person> selectAllPerson() {
		Connection connection = null;// 定义连接对象
		PreparedStatement statement = null; // 定义语句对象
		ResultSet resultSet = null; // 定义结果集对象
		ArrayList<Person> personList = new ArrayList<Person>();
		try {
			connection = DbUtil.getConnection();
			// 3，获得语句对象
			statement = connection.prepareStatement("select * from person");
			// 4,执行sql,查询executeQuery，返回结果集
			resultSet = statement.executeQuery();
			// 处理结果集
			while (resultSet.next()) {// 判断是否存在
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
				// 5，关闭资源
				DbUtil.close(connection, statement, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return personList;
	}

	// 删除操作
	public boolean deletePersonById(int id) {
		Connection connection = null;// 定义连接对象
		PreparedStatement ps = null; // 定义语句对象
		try {
			connection = DbUtil.getConnection();
			// 3，获得语句对象
			ps = connection.prepareStatement("delete from person where id=?");
			ps.setInt(1, id);
			// 4,执行sql,查询executeQuery，返回结果集
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
				// 5，关闭资源
				DbUtil.close(connection, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}
	
	// 修改操作
		public boolean updatePerson(Person person) {
			Connection connection = null;// 定义连接对象
			PreparedStatement ps = null; // 定义语句对象
			try {
				connection = DbUtil.getConnection();
				// 3，获得语句对象
				ps = connection.prepareStatement("update person set name=?,pass=? where id=?");
				ps.setString(1, person.getName());
				ps.setString(2, person.getPassword());
				ps.setInt(3, person.getId());
				// 4,执行sql,查询executeQuery，返回结果集
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
					// 5，关闭资源
					DbUtil.close(connection, ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return false;
		}
		// 根据id查询用户
		public Person selectPersonById(int id) {
			Connection connection = null;// 定义连接对象
			PreparedStatement statement = null; // 定义语句对象
			ResultSet resultSet = null; // 定义结果集对象
			try {
				connection = DbUtil.getConnection();
				// 3，获得语句对象
				statement = connection.prepareStatement("select * from person where id=?");
				statement.setInt(1, id);
				// 4,执行sql,查询executeQuery，返回结果集
				resultSet = statement.executeQuery();
				// 处理结果集
				if (resultSet.next()) {// 判断是否存在
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
					// 5，关闭资源
					DbUtil.close(connection, statement, resultSet);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return null;
		}
}
