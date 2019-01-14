package com.view.sqloperate.execut;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.Dao;
import com.dao.DatabaseFactory;
import com.dao.ManagerThreadPool;
import com.dao.entity.Table;
import com.dao.imp.Page;
import com.entity.LoginInfo;
import com.excel.CheckException;
import com.listener.ExcuteListener;
import com.view.system.dialog.WaringMsg;

/**
 * ����ִ��sql�����̳д���
 * @author Administrator
 *
 */
public abstract class Execute implements Runnable {
	protected LoginInfo loginInfo;
	private ManagerThreadPool managerThreadPool;
	protected StringBuffer error;
	protected Dao dao;
	protected ExcuteListener listener;
	protected boolean isSuccess = true;
	/**
	 * ���ؽ����
	 */
	protected Table table;
	
	/**
	 * ������update������
	 */
	protected int rows[];
	
//	public Execute(){
//		
//	}
	/**
	 * ִ�в�ѯ���� 
	 * @param logInfo  ��¼��Ϣ
	 * @param info  
	 */
	public Execute(LoginInfo loginfo){
		this.loginInfo = loginfo;
		error = new StringBuffer();
	}
	/**
	 * 
	 * @param loginInfo
	 *            ��¼��Ϣ
	 * @param sql
	 *            Ҫִ�е�sql���
	 * @param page 
	 */
	public Execute(LoginInfo loginInfo, Page page) {
		this.loginInfo = loginInfo;
		error = new StringBuffer();
	}

	public int[] getRows() {
		return rows;
	}
	public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException, InterruptedException, SQLException {
		DatabaseFactory dataBaseFactory = DatabaseFactory.getDataBaseFactory();
		dao = dataBaseFactory.createDataBaseTemplate(loginInfo);
//		System.out.println("getConnection");
		managerThreadPool = ManagerThreadPool.getManagerThreadPool();
		Connection connection = managerThreadPool.getConnection(loginInfo);
		if(connection==null){
//			WaringMsg.showMessageDialog("���ȵ�¼");
			throw new SQLException("");
		}
		return connection;
	}

	
	public void releasConnection(Connection connection){
//		System.out.println("releasConnection"+connection);
		try {
			if(connection!=null){
				if(connection.isClosed()){
					return ;
				}
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			managerThreadPool.releasConnection(loginInfo, connection);
		}
	}
	
	public Table getTable() {
		return table;
	}

	public String getError(){
		return error.toString();
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public static void closeAll(Object... objs) {
		for (Object obj : objs) {
			try {
				if (obj instanceof ResultSet){
					close((ResultSet) obj);
					obj = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (obj instanceof PreparedStatement){
					close((PreparedStatement) obj);
					obj = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (obj instanceof Statement){
					close((Statement) obj);
					obj = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void close(Statement statent) throws SQLException {
		if (statent != null) {
			statent.close();
		}
	}
	public static void close(PreparedStatement statent) throws SQLException {
		if (statent != null) {
			statent.close();
		}
	}
	private static void close(ResultSet result) throws SQLException {
		if (result != null) {
			result.close();
		}
	}

	private static void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
