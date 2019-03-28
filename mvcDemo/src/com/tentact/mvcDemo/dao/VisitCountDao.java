package com.tentact.mvcDemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import util.DbUtil;

public class VisitCountDao {
	public Integer selectCount() {
		Connection connection = null;// �������Ӷ���
		PreparedStatement statement = null; // ����������
		ResultSet resultSet = null; // ������������
		try {
			connection = DbUtil.getConnection();
			// 3�����������
			statement = connection.prepareStatement("select count from visit_count");
			// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
			resultSet = statement.executeQuery();
			// ��������
			if (resultSet.next()) {// �ж��Ƿ����
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
				// 5���ر���Դ
				DbUtil.close(connection, statement, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	// �޸Ĳ���
	public boolean updateCount(int count) {
		Connection connection = null;// �������Ӷ���
		PreparedStatement ps = null; // ����������
		try {
			connection = DbUtil.getConnection();
			// 3�����������
			ps = connection.prepareStatement("update visit_count set count=?");
			ps.setInt(1, count);
			// 4,ִ��sql,��ѯexecuteQuery�����ؽ����
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
				// 5���ر���Դ
				DbUtil.close(connection, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}
}
