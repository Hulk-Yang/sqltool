package com.view.movedata.exp.entity;

import java.io.Serializable;

/**
 * ����Ǩ�ƻ���ѹ������ʱʹ�õĹ�������
 * @author wanghh
 *
 */
public class ColumnType implements Serializable{
	public static final String DEFULTCOLUMN = "Ĭ���ֶ�";
	public static final String FINAL = "����ֵ";
	public static final String GROUPCOLUMN = "�����ֶ�";
	public static final String NOW_TIME = "��ǰʱ��";
	public static final String TEST = "���ֵ";
	public static final String CUSTOM_MADE = "����������Դ";
	public static final String ALL_CHANGE = "ȫ�ֱ����趨";
	public static final String FORCE_WHERE = "ǿ������";
	public static final String CHANGE_WHERE = "ǿ����������";
	public static final String DEFULT_WHERE = "������";

	private String type;
	public ColumnType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}
	@Override
	public String toString() {
		return type;
	}
}
