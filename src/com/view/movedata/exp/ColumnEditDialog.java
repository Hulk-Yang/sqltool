package com.view.movedata.exp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ��Ĭ��ֵ�༭������
 * @author whh
 *
 */
public class ColumnEditDialog extends JDialog{
	
	public ColumnEditDialog(){
		this.setLayout(new BorderLayout());
		 JPanel one = new JPanel(new FlowLayout(FlowLayout.LEFT));
		 JComboBox check = new JComboBox();
//		 check.setEditable(true);;
		 check.addItem("�����ַ�������");
		 check.addItem("������������");
		 check.addItem("����");
		 check.addItem("������ֵ");
		 check.addItem("���������ֵ");
		 check.addItem("����ַ���");
		 one.add(new JLabel("���ɷ�ʽ:"));
		 one.add(check);
		 add(one,BorderLayout.NORTH);
		 
		 JPanel two = new JPanel(new GridLayout(2,1 ));
		 JPanel two1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		 JPanel two2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		 two1.add(new JLabel("��ʼֵ/����ֵ"));
		 two1.add(new JTextField(10));
		 two2.add(new JLabel("���ڸ�ʽ"));
		 two.add(two1);
		 two.add(two2);
		 
		 add(one,BorderLayout.NORTH);
		 add(two,BorderLayout.CENTER);
		 this.setSize(200, 150);
	}
	
	
	public static void main(String[] args) {
		new ColumnEditDialog().show();
	}
}

