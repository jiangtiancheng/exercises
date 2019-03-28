package com.tentact.mvcDemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import util.DbUtil;

public class VisitCountDao {
	public Integer selectCount() {
		Connection connection = null;// 定义连接对象
		PreparedStatement statement = null; // 定义语句对象
		ResultSet resultSet = null; // 定义结果集对象
		try {
			connection = DbUtil.getConnection();
			// 3，获得语句对象
			statement = connection.prepareStatement("select count from visit_count");
			// 4,执行sql,查询executeQuery，返回结果集
			resultSet = statement.executeQuery();
			// 处理结果集
			if (resultSet.next()) {// 判断是否存在
				return resultSet.getInt(1);
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

	// 修改操作
	public boolean updateCount(int count) {
		Connection connection = null;// 定义连接对象
		PreparedStatement ps = null; // 定义语句对象
		try {
			connection = DbUtil.getConnection();
			// 3，获得语句对象
			ps = connection.prepareStatement("update visit_count set count=?");
			ps.setInt(1, count);
			// 4,执行sql,查询executeQuery，返回结果集
			int result = ps.executeUpdate();
			if (result > 0) {
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
}
