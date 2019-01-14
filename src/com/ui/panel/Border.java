package com.ui.panel;

import java.awt.Component;

import javax.swing.JPanel;


/**
 * @author Administrator
 *
 */
public interface Border {
	/**
	 * ����߽�
	 */
	final int ROUTINE = 0;
	final int MOVEMENT = 1;
	/**
	 * ����������
	 * @param comp
	 */
	public void addLeftPanel(Component comp);
	/**
	 * �����ұ����
	 * @param comp
	 */
	public void addRightPanel(Component comp);
	/**
	 * �����ϱ����
	 * @param comp
	 */
	public void addUpPanel(Component comp);
	/**
	 * �����±����
	 * @param comp
	 */
	public void addDownPanel(Component comp);
	/**
	 * ���������
	 * @param comp
	 */
	public void addMainPanel(Component comp);
	
	/**
	 * �õ�������
	 * @param comp
	 */
	public JPanel getLeftPanel();
	/**
	 * �õ��ұ����
	 * @param comp
	 */
	public JPanel getRightPanel();
	/**
	 * �õ��ϱ����
	 * @param comp
	 */
	public JPanel getUpPanel();
	/**
	 * �õ��±����
	 * @param comp
	 */
	public JPanel getDownPanel();
	/**
	 * �õ������
	 * @param comp
	 */
	public JPanel getMainPanel();
	
	
	/**
	 * ��ʼ��
	 */
	public void init();
	/**
	 * borderType �߽�����
	 */
	public int getBorderType();
	/**
	 * 
	 * @param borderType ���ñ߽�����
	 */
	public void setBorderType(int borderType);
}
