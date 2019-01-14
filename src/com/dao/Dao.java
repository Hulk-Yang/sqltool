package com.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dao.entity.Column;
import com.dao.entity.Table;
import com.dao.imp.Page;

@SuppressWarnings("unused")
public interface Dao extends ITemplate{
	
	
	/**
	 * ��ѯ���ݿ������б���Ϣ
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Table> getTables(String userName,Connection conn) throws SQLException;
	public ArrayList<Table> getSequence(String userName,Connection conn) throws SQLException;

	/**
	 * ��ѯ���ݿ�ĳ��������Ϣ
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Column> getColumns(String userName,Connection conn,String tableName) throws SQLException;
	public ArrayList<Column> getColumnsFromSql(String userName,Connection conn,String tableName) throws SQLException;

	/**
	 * һ��sqlִ�з���
	 * @param conn 
	 * @param sql
	 * @param page 
	 * @return
	 * @throws SQLException
	 */
	Table executeSql(Connection conn, String sql)  throws SQLException ;
	/**
	 * update��䴦��
	 * @param conn 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	int[] executeBatchUpdata(Connection conn, String[] sql) throws SQLException;
//	/**
//	 * insert��������䴦��
//	 * @param conn 
//	 * @param sql
//	 * @return
//	 * @throws SQLException
//	 */
//	int[] executeBatchInsert(Connection conn, String[] sql) throws SQLException;
	public int[] executePreparedUpdata(Connection connection, String[] sql, Table updateData ) throws SQLException;
			
	HashMap<String, ArrayList<Column>> getPk(Connection conn) throws SQLException;
	public ArrayList<Table> getViews(String userName,Connection conn)
			throws SQLException ;

	
	/**
	 * ��ѯ����view��DDL���
	 * @param viewName
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public String getViewDDL(String viewName, Connection connection) throws SQLException;

	
	public String getTableDDL(String tableName, Connection connection);

	public ArrayList<String> getTableSpace(String userName, Connection connection) throws SQLException;
	String getTableSpaceDDL(String tableSpaceName, Connection conn)
			throws SQLException;
	public int getTablesRow(Connection connection,String tableName) throws SQLException;
	public int getTablesRowFromSql(Connection connection,String tableName) throws SQLException;

	Table getViewSessions(String viewName, Connection conn) throws SQLException;
	/**
	 * ���ֲ�ͬ���ݿ������Сд����
	 * @return
	 */
	String getTableName(String tableName);
	/**
	 * �Զ�Ĭ�ϼӷ�ҳ����
	 * @param sql
	 * @return
	 */
	String page(String sql);
	
	/**
	 * ���ݲ�ͬ���ݿ�ʵ��rowid�ֶ�
	 * @return
	 */
	String getROWID();
	/**
	 * ��������ʱ��һ���Լ�������
	 * @param connection
	 * @param bigSqlTable
	 * @return
	 */
	public Statement getLazyStatement(Connection connection) throws SQLException;
	
	public int getFetchSize() ;
	String getSelectSql(String userName, Connection connection, String tableName) throws SQLException;
	public void tryQuery(Connection conn) throws SQLException;
}