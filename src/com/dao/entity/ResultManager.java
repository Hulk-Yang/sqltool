package com.dao.entity;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.SQLTool;

import com.dao.imp.Page;
import com.entity.LoginInfo;
import com.ui.extensible.UITabbedPane;
import com.view.sqloperate.Cache;
import com.view.sqloperate.QuerySqlTab;

/**
 * sql���ִ�к������ռ����ַ��Ĺ�����
 * 
 * @author Administrator
 * 
 */
public class ResultManager {
	private static ResultManager manager;
	private QuerySqlTab editSqlTab;
	private static Object o = new Object();
	private ResultManager() {getSqlEdit();};
	public static  ResultManager getResultManager(){
		if(manager ==null){
			synchronized (o) {
				if(manager==null){
					manager = new ResultManager();
				}
			}
		}
		return manager;
	}
	
	/**
	 * 
	 * @param editSqlTab 
	 * 			sql����ѯ����
	 * @param resultSet
	 * 			��ѯ���ݷ��ؽ����
	 * @param sql
	 * 			������ҳʹ�õ�sql���
	 * @param error
	 * 			�����ѯ�����򽫴�����Ϣ���û�ǰ̨����
	 * @param isSuccess
	 * 			�Ƿ�Ϊ�ɹ�
	 * @throws SQLException
	 */
	public void setResultData(QuerySqlTab editSqlTab, Table resultSet,String error, boolean isSuccess) {
		editSqlTab.setResultInfo(resultSet,error,isSuccess);
	}
	public void getSqlEdit(){
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		Component selectedComponent = tabQuerySql.getSelectedComponent();
		editSqlTab = (QuerySqlTab)selectedComponent;
	}
	/**
	 * ����ִ��sql����Ӱ�������
	 * @param editSqlTab 
	 * @param rows
	 * @param error  ִ�к����������Ϣ
	 * @param isSuccess ִ���Ƿ����
	 */
//	public void setResultInfluenceRows(QuerySqlTab editSqlTab, int[] rows, String error,boolean isSuccess) {
//		editSqlTab.setResultInfluenceRows(rows,error,isSuccess);
//	}
	public void setResultPks(LoginInfo connInfo,
			HashMap<String, ArrayList<Column>> pks, String error,
			boolean success) {
		Cache.getCache().loadPks(connInfo,pks);
	}
}
