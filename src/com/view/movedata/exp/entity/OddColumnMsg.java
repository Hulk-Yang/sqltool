package com.view.movedata.exp.entity;

import java.io.Serializable;

/**
 * ����Ǩ��ʱ�������ݼ��бȶ�
 * @author whh
 *
 */
public class OddColumnMsg implements Serializable{

	private Object fcolumnName;
	private String tcolumnName;
	private ColumnType defindMate;
	
//	public final static int 0
	/**
	 * 
	 * @param ColumnType Ĭ��ת�������±�����ҪĬ��ֵ��
	 * @param fromCName	�����Ǹ��ֶ�
	 * @param toCName	ת�����Ǹ��ֶ� 	
	 */
	public OddColumnMsg(ColumnType defindMate,Object fromCName,String toCName){
		this(fromCName,toCName);
		this.defindMate = defindMate;
	}
	public OddColumnMsg(Object fromCName,String toCName){
		this.fcolumnName = fromCName;
		this.tcolumnName = toCName;
	}
	public Object getFcolumnName() {
		return fcolumnName;
	}
	public void setFcolumnName(Object fcolumnName) {
		this.fcolumnName = fcolumnName;
	}
	public String getTcolumnName() {
		return tcolumnName;
	}
	public void setTcolumnName(String tcolumnName) {
		this.tcolumnName = tcolumnName;
	}
	public ColumnType getDefindMate() {
		return defindMate;
	}
	
}
