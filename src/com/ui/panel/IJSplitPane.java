package com.ui.panel;

import java.awt.Component;

/**
 * JSplitPane��չ����
 * @author Administrator
 *
 */
public interface IJSplitPane {
	public void init();

	/**
	 * �����·�����
	 * 
	 * @param comp
	 * @roseuid 5282E1600292
	 */
	public void setDownPanel(Component comp);

	/**
	 * �����Ϸ�����
	 * 
	 * @param comp
	 * @roseuid 5282E16002A2
	 */
	public void setUpPanel(Component comp);

	/**
	 * ����������
	 * 
	 * @param comp
	 * @roseuid 5282E1600292
	 */
	public void setLeftPanel(Component comp);

	/**
	 * �����ҷ�����
	 * 
	 * @param comp
	 * @roseuid 5282E16002A2
	 */
	public void setRightPanel(Component comp);

}
