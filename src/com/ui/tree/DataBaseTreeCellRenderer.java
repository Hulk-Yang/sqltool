package com.ui.tree;

import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.prompt.PromptLabel;

/**
 * �Զ�����������,������ÿ���ڵ����óɲ�ͬ��ͼ��
 * 
 * @author RuiLin.Xie - xKF24276
 * 
 */

public class DataBaseTreeCellRenderer extends DefaultTreeCellRenderer  {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��д����DefaultTreeCellRenderer�ķ���
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		// �õ�ÿ���ڵ��TreeNode
		IconMutableTreeNode node = (IconMutableTreeNode) value;
		// ִ�и���ԭ�Ͳ���
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);

		if(node.getUserObject() instanceof PromptLabel){
			PromptLabel label =(PromptLabel)node.getUserObject();
			if(sel){
				label.setSelect(true);
			}else{
				label.setSelect(false);
			}
			setText(label.toString());
		}else{
			setText(value.toString());
		}
		if (sel) {
			setForeground(getTextSelectionColor());
		} else {
			setForeground(getTextNonSelectionColor());
		}

	
		setOpaque(false);
		// �õ�ÿ���ڵ��text
		String str = node.toString();

		// �ж����ĸ��ı��Ľڵ����ö�Ӧ��ֵ����������ڵ㴫�����һ��ʵ��,����Ը���ʵ�������һ��������������ʾ��Ӧ��ͼ�꣩
		this.setIcon(node.getIcon());

		return this;
	}
	
	
	

}
