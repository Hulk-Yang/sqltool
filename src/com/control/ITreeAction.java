package com.control;

import javax.swing.tree.MutableTreeNode;

import com.ui.tree.IconMutableTreeNode;

/**
 * ִ�����ڵ����ܲ������ܽӿڣ�������Բ�ͬ�ڵ�ʵ�ֲ�ͬ�������ܣ�
 * @author Administrator
 */
public interface ITreeAction {
	/**
	 * ִ�е�������
	 */
	public void doClick();
	/**
	 * ִ��˫������
	 */
	void doDoubleClick(IconMutableTreeNode treeNode);
}
