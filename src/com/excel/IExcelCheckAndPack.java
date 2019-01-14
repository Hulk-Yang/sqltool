package com.excel;

public interface IExcelCheckAndPack {
	String success = "success";
	/**
	 * Excel У������
	 * @param row ��ǰ������
	 * @return    �������ʾ��Ϣ�����У��ɹ���Ż�success
	 * @throws Exception 
	 */
	public String check(RowEntity row) throws CheckException;
	/**
	 * Excel ����ǰ����Ϣת��Ϊָ��VO����
	 * @param readExcelTitle 
	 * @param row ��ǰ������
	 * @return
	 */
	public Object pack( RowEntity row);
}
