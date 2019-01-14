package com.sql;

import com.dao.entity.Table;

public interface ISQLMachine {

	final String INSERT=" INSERT ";
	final Object INTO = " INTO ";
	/**
	 * ƴ��INSERT���
	 * @param tableName ����
	 * @param colum     ����
	 * @param value     ֵ
	 * @return
	 */
	String[] getSqls(Table updateData);
	String getTableName(String sql);
}
