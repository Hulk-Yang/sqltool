//Source file: E:\\workspace\\com\\ui\\border\\BorderPanel.java

package com.ui.panel.border;

import java.awt.event.MouseEvent;

import com.ui.panel.JPanelSplit;

/**
 * ���б߽��JPanel��չ
 * @author wang.hh
 *
 */
public class BorderPanel extends AbsBorderPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * ���������Ϊ���С��ҡ����ĸ�����
	 * @borderType �߽�������� ���Ի�߽����
	 */
	public BorderPanel(int borderType){
		super(borderType);
	}

	/**
	 * ��ʼ�����
	 * 
	 */
	public void init() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("����");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("�˳�");
		
	}

	


	
	
	
	

}
