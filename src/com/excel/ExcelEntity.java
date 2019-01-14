package com.excel;

import java.util.ArrayList;
import java.util.List;

public class ExcelEntity<T> {
	private int i=0;
	private List<T> rows ;
	public ExcelEntity(){
		rows = new ArrayList<T>();
	}
	
	void add(T row){
		rows.add(row);
	}
	

	/**
	 *
	 * @return Excel��������������������ͷ��
	 */
	public int getRowNum(){
		return rows.size();
	}
	
	/**
	 *
	 * @return �õ���������Ϣ
	 */
	public T getRowEntity(int lineNumber){
		return rows.get(lineNumber);
	}
	
	public void clear(){
		rows.clear();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getList(){
		return  rows;
	}
}
