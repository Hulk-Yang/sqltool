//Source file: E:\\workspace\\com\\ui\\border\\ILayout.java

package com.ui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.ui.panel.border.VerticalSplitPane;


/**
 * Janel��չ��SplitPanel���Ͽ���ֱ�ӽ��зָ�����
 */
public class JPanelSplit extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelSplit parents;
	/**
	 * ��������洰��
	 */
	private Component left;
	private Component right;
	private JSplitPane  split;
	public final static int VERTICAL_SPLIT = JSplitPane.VERTICAL_SPLIT;
	public final static int HORIZONTAL_SPLIT = JSplitPane.HORIZONTAL_SPLIT;
	/**
	 * ��������������Ϊ2��С��Ϊ0
	 */
	private int cont = 0;
	public JPanelSplit(){
		setLayout(new BorderLayout());
		split = new JSplitPane(VERTICAL_SPLIT);
	}
	/**
	 * �̳�JPanel�����ָ��������
	 */
	public JPanelSplit(int paramInt){
		setLayout(new BorderLayout());
		split = new JSplitPane(paramInt);
	}
	
	public Component addLeft(Component panel){
		
		split.setLeftComponent(panel);
		split.setLeftComponent(right);
		this.removeAll();
		add(split);
		return left = panel;
	}
	public Component addRight(Component panel){
		split.setLeftComponent(left);
		split.setRightComponent(panel);
		this.removeAll();
		add(split);
		return right =panel;
	}
	public JPanelSplit add(JPanelSplit panel) {
		 left =  panel;
		 super.add(panel);
		 return panel;
	}
	
	public void setDividerLocation(int dividerLocation){
		split.setDividerLocation(dividerLocation);
	}
	public void setParents(JPanelSplit comp){
		parents = comp;
	}
	public JPanelSplit getParents(){
		return parents ;
	}
}
