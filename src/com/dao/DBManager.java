package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.entity.Table;
import com.entity.LoginInfo;

public interface DBManager {
	
	/**
	 * ������������¼����
	 * @param resultSet �����
	 * @param info      user��Ϣ
	 * @throws SQLException
	 */
	void tableResultPutDBTree(ArrayList<Table> listTable, LoginInfo info)
			throws SQLException; 
}
