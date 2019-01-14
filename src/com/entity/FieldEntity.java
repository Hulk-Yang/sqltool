package com.entity;

public class FieldEntity {
	public  final static String FORMAT = "���ڸ�ʽ��";
	public  final static String TOBEIGDATA = "ת����������";
	public  final static String DATATODATA = "�����滻";
	private String expField;
	private String impField;
	private String opertaion;//������ʽ
	private String aim;//����Ŀ��
	
	public FieldEntity(String expField, String impField,String opertaion,String aim){
		this.expField = expField;
		this.impField = impField;
		this.opertaion = opertaion;
		this.aim = aim;
	}
	/**
	 * �����·���Ļ�
	 * @return ���� D:/...
	 */
	public String getPath(){
		return aim.substring(0, aim.lastIndexOf("/"))+"/";
	}
	public String getName(){
		return aim.substring(aim.indexOf("/")+1);
	}
	public String getExpField() {
		return expField;
	}
	public void setExpField(String expField) {
		this.expField = expField;
	}
	public String getImpField() {
		return impField;
	}
	public void setImpField(String impField) {
		this.impField = impField;
	}
	public String getOpertaion() {
		return opertaion;
	}
	public void setOpertaion(String opertaion) {
		this.opertaion = opertaion;
	}
	public String getAim() {
		return aim;
	}
	public void setAim(String aim) {
		this.aim = aim;
	}
	
	
}
