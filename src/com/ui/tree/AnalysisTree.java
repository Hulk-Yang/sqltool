package com.ui.tree;

import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * ������������ʽ�Ľӿ�
 * @author Administrator
 *
 */
public interface AnalysisTree {
	/**
	 * ��������
	 * @return
	 */
	IconMutableTreeNode addChilds();

	IconMutableTreeNode addChild() throws IOException;
}
