package com.ui.menu;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

public interface MenuAndTool {
	/**
	 * ������
	 * @param name ����������
	 * @param type ��������Ϣ��ʶ����xml��Ϊxml��ʶ�����Ϊ���ݿ���Ϊ��Ӧid��ʶ��
	 * @return
	 */
	public JToolBar getToolBar(String name,String type);
	/**
	 * �����˵�
	 * @param type  �����˵���Ϣ��ʶ����xml��Ϊxml��ʶ�����Ϊ���ݿ���Ϊ��Ӧid��ʶ��
	 * @return
	 */
	public JPopupMenu getPopupMenu(String type) ;
	
	/**
	 * �˵���
	 * @param type
	 * @return
	 */
	public JMenuBar getMenu(String type)  ;
	/**
	 * ����ϡbuttons�����JPanel��
	 * @param type
	 * @return
	 */
	public JPanel getButtons(String type);
}
