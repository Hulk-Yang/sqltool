package com.excel;

import java.util.HashMap;
import java.util.Map;

public class RowEntity {
	private Map<String,String> row = new HashMap<String, String>();
	void put(String col,String value) throws CheckException{
		if(row.containsKey(col)){
			throw new CheckException("Excel�д�����ͬ��������");
		}else{
			row.put(col, value);
		}
		
	}
	/**
	 * @param colName ����
	 * @return �����ж���������ֵ
	 * @throws Exception 
	 */
	public String getValue(String colName) throws CheckException{
		if(row.containsKey(colName.toUpperCase())){
			return row.get(colName.toUpperCase())==null?"": row.get(colName.toUpperCase()).trim();
		}else{
			throw new CheckException("Excel�в�����["+colName+"]������");
		}
	}
}
