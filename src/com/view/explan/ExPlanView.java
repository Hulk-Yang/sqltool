package com.view.explan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import main.SQLTool;

import com.dao.ConnectionPool;
import com.dao.entity.Column;
import com.dao.entity.Table;
import com.entity.LoginInfo;
import com.excel.CheckException;
import com.excel.ExcelEntity;
import com.excel.ExcelReader;
import com.excel.ImpDefaultExcelCheckAndPack;
import com.ui.extensible.Cell;
import com.ui.extensible.UITable;
import com.ui.tree.UITree;
import com.view.movedata.execut.ExpDataToFileCtr;
import com.view.movedata.execut.ExpMsg;
import com.view.movedata.execut.ImpDataBaseCtr;
import com.view.sqloperate.Controller;
import com.view.system.dialog.WaringMsg;


/**
 * �������ݿ�����
 * @author wanghhc
 */
public class ExPlanView extends JPanel{
	private static final long serialVersionUID = 5129526252969274684L;
	private File[] file;
	private DefaultTableModel tableModel;
	private UITable table;
	private JComboBox connectionList;
	private JRadioButton impBut;
	private JRadioButton expBut;
	private JFileChooser fileChooser = new JFileChooser();
	
	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	private boolean run = false;

	public ExPlanView(){
		init();
	}
	public void init(){
		setLayout(new BorderLayout());
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setDividerLocation(0.4);
		JPanel contr = new JPanel();
		BoxLayout layout=new BoxLayout(contr, BoxLayout.Y_AXIS); 
		contr.setLayout(layout);
		
		contr.add(getChooseExpType());
		JPanel buttons = getButtons();
		contr.add(buttons);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("serial");
		tableModel.addColumn("sessionid");
		tableModel.addColumn("״̬");
		tableModel.addColumn("�û���");
		tableModel.addColumn("����Ա");
		tableModel.addColumn("������");
		tableModel.addColumn("����");
		
		table = new UITable(tableModel);
		
		JScrollPane scrollpane1 = new JScrollPane(table,   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contr.add(scrollpane1);
		
		
		
		split.setRightComponent(new JTextPane());
		JPanel panelCenter = new JPanel(new BorderLayout());
		split.setLeftComponent (contr);
		add(split,BorderLayout.CENTER);
		
		getChangeTableMsg();
	}
	
	private JPanel getButtons(){
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		connectionList = getDrowDown();
		JButton but = new JButton("�Զ�ˢ��");
		JButton refre = new JButton("ˢ��");
		JButton kill = new JButton("KILL");
		p.add(but);
		p.add(refre);
		p.add(kill);
		refre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
				refre();
			}
		});
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				refre();
				run = !run;
				Thread th = new Thread(){
					@Override
					public void run() {
						while(run){
							try {
								Thread.sleep(100);
								clear();
								refre();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("11");
						}
					}
				};
				if(run){
					th.start();
				}
			}
		});
		p.add(connectionList);
		return p;
	}
	private JPanel getSelectPath() {
		JPanel selectPath = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JPanel model = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		expBut = new JRadioButton("����ģʽ",true);
		impBut= new JRadioButton("����ģʽ");
		ButtonGroup group = new ButtonGroup();
		group.add(expBut);
		group.add(impBut);
		model.setBorder( BorderFactory.createLineBorder(Color.gray));
		model.add(expBut);
		model.add(impBut);
		selectPath.add(model);
		
		
		selectPath.add(new JLabel("   ·��:"));
		final JTextField field = new JTextField(40);
		field.setEditable(false);
		selectPath.add(field);
		
		final JButton chooser = new JButton("ѡ��·��");
		final JButton exp = new JButton("����");
		expBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int showConfirmDialog = WaringMsg.showConfirmDialog("�Ƿ���ص�����Ϣ",ExpDataView.this);
//				if(showConfirmDialog==JOptionPane.OK_OPTION){
					clearTableMsg();
					getChangeTableMsg();
					exp.setText("����");
					fileChooser.setMultiSelectionEnabled(false);
					field.setText("");
//				}else{
//					impBut.setSelected(true);
//				}
			}
		});
		impBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int showConfirmDialog = WaringMsg.showConfirmDialog("�Ƿ���ص�����Ϣ",ExpDataView.this);
//				if(showConfirmDialog==JOptionPane.OK_OPTION){
					clearTableMsg();
					exp.setText("����");
					fileChooser.setMultiSelectionEnabled(true);
					field.setText("");
//				}else{
//					expBut.setSelected(true);
//				}
			}
		});
		
		selectPath.add(chooser);
		exp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = table.getRowCount();
				if(impBut.isSelected()){
					for (int i = 0; i < rowCount; i++) {
						Boolean valueAt = (Boolean) table.getValueAt(i, 0);
						if(valueAt){
							new ImpDataBaseCtr((LoginInfo)connectionList.getSelectedItem(),file[i],table,i);
						}
					}
				}
				if(expBut.isSelected()){
					for (int i = 0; i < rowCount; i++) {
						Boolean valueAt = (Boolean) table.getValueAt(i, 0);
						if(valueAt){
							new ExpDataToFileCtr((LoginInfo)connectionList.getSelectedItem(), table.getValueAt(i, 1).toString(),file[0],table,i);
						}
						
					}
				}
			}
			
		});
		selectPath.add(exp);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		
		chooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int showSaveDialog = fileChooser.showSaveDialog(null);
				if (JFileChooser.APPROVE_OPTION == showSaveDialog) {
					file = null;
					
					StringBuffer pathStr = new StringBuffer();
					file = fileChooser.getSelectedFiles();
					File selectedFile = fileChooser.getSelectedFile();
					if(selectedFile!=null&&expBut.isSelected()){
						file = new File[]{selectedFile.isFile()?selectedFile.getParentFile():selectedFile};
					}
					for (int i = 0; i < file.length; i++) {
						file[i].getPath();
						pathStr.append(file[i].getPath());
						pathStr.append(";");
					}
					field.setText(pathStr.toString());
					
					if(impBut.isSelected()){
						clear();
						for (int j = 0; j < file.length; j++) {
							if(!file[j].isFile()){
								WaringMsg.showConfirmDialog("��ѡ���ļ�", null);
								break;
							}
							if(file[j].getName().endsWith(".xls")){
								try {
									ExcelReader<String[]> exacelReader = new ExcelReader<String[]>(file[j].getPath());
									exacelReader.setCheckAndPackModel(new ImpDefaultExcelCheckAndPack(exacelReader));
									ExcelEntity<String[]> readExcelContent = exacelReader.readExcelContent();
									readExcelContent.getList();
									int rowNum = readExcelContent.getRowNum();
									
									ExpMsg exp = new ExpMsg(rowNum); 	 
									tableModel.addRow(new Object[]{false,file[j].getName(),exp});
									
								} catch (IOException e) {
									ExpMsg exp = new ExpMsg(0); 	 
									tableModel.addRow(new Object[]{false,"�ļ� "+file[j].getName()+" ��ʽ�����ȡʧ��",exp});
								} catch (CheckException e) {
									e.printStackTrace();
								}
							}else {
								tableModel.addRow(new Object[]{false,"�ļ� "+file[j].getName()+" �ݲ�֧�� "+file[j].getName().split("\\.")[1]+"��ʽ����",exp});

							}
						}
					}
				}
			}
		});
		return selectPath;
	}
	private JPanel getModel() {
		JPanel model = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		impBut = new JRadioButton("����ģʽ");
		expBut = new JRadioButton("����ģʽ",true);
		ButtonGroup group = new ButtonGroup();
		group.add(expBut);
		group.add(impBut);
		model.setBorder( BorderFactory.createLineBorder(Color.gray));
		
		model.add(expBut);
		model.add(impBut);
		return model;
	}
	private JPanel getSelectPanel() {
		JPanel selectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
		JButton all = new JButton("ȫѡ");
		JButton cancel = new JButton("ȡ��");
		selectPanel.add(all);
		selectPanel.add(cancel);
		return selectPanel;
	}
	

	private JPanel getChooseExpType() {
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,10));
		panel1.setBorder( BorderFactory.createTitledBorder("������ʽ"));
		JCheckBoxMenuItem tableData = new JCheckBoxMenuItem("����������.sql");
		JCheckBoxMenuItem tableDataDb = new JCheckBoxMenuItem("����������.db");
		JCheckBoxMenuItem tableStructure = new JCheckBoxMenuItem("������ṹ");
		JCheckBoxMenuItem views = new JCheckBoxMenuItem("������ͼ");
		JCheckBoxMenuItem procedures = new JCheckBoxMenuItem("�����洢����");
		JCheckBoxMenuItem functions = new JCheckBoxMenuItem("��������");
		JCheckBoxMenuItem indexs = new JCheckBoxMenuItem("��������");
		JCheckBox box = new JCheckBox();
//		tableStructure.setEnabled(false);
		tableData.setSelected(true);
		box.add(tableData);
		box.add(tableDataDb);
		box.add(tableStructure);
		box.add(views);
		box.add(indexs);
		box.add(procedures);
		box.add(functions);
		panel1.add(tableData);
		panel1.add(tableDataDb);
		panel1.add(tableStructure);
		panel1.add(views);
		panel1.add(procedures);
		panel1.add(functions);
		panel1.add(indexs);
		return panel1;
	}
	
	
	public void addRows(Object[] rowData){
		tableModel.addRow(rowData);
	}
	public void clear(){
		int rowCount = tableModel.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			tableModel.removeRow(0);
		}
	}
	
	
	public JComboBox getDrowDown() {
		connectionList = new JComboBox();	
		connectionList.removeAllItems();
		UITree dataBaseTree = SQLTool.getSQLTool().getToolFrame().getSqlView()
				.getDataBaseTree();
		DefaultTreeModel model = (DefaultTreeModel) dataBaseTree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		int childCount = root.getChildCount();
		LoginInfo[] please = new LoginInfo[childCount];
		LoginInfo login = new LoginInfo();
		login.setName("---��ѡ��---");
		connectionList.addItem(login);

		LoginInfo conn;
		for (int i = 0; i < childCount; i++) {
			DefaultMutableTreeNode childAt = (DefaultMutableTreeNode) root
					.getChildAt(i);
			please[i] = (LoginInfo) childAt.getUserObject();
		}
		Arrays.sort(please, new Comparator<LoginInfo>(){

			@Override
			public int compare(LoginInfo o1, LoginInfo o2) {
				int i = o1.getIsLive()>o2.getIsLive()==true?1:-1;
				return i;
			}
			
		});
		for (int i = 0; i < childCount; i++) {
			connectionList.addItem(please[i]);
		}
		connectionList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
//				getChangeTableMsg();
//				if(e.getStateChange()==ItemEvent.SELECTED){
//					if(expBut.isSelected()){
//						clearTableMsg();
//						getChangeTableMsg();
//					}
//				}
				
			}
		});
		return connectionList;
	}
	/**
	 * ��������Ϣ
	 */
	private void getChangeTableMsg() {
		Thread th = new Thread(){
			public void run() {
				while(true){
						try {
							sleep(50);
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
						
					}
				}
		};
		th.start();
		
	}
	
	private void refre(){
		try {
			LoginInfo  log = (LoginInfo) connectionList.getSelectedItem();
			if(log.getIsLive()==ConnectionPool.IS_DIE){
				return ;
			}
			
			Table resultSet = Controller.newController().ExecutSqlConfig(log, "SESSIONS");
			
			int rows = resultSet.getRowNum();
			Cell[] columnValus;
			for (int i = 0; i < rows; i++) {
				columnValus = resultSet.getRow(i);
				if(map.containsKey(columnValus[0].toString()+columnValus[1].toString())){
					
				}else{
					map.put(columnValus[0].toString()+columnValus[1].toString(),i);
					tableModel.addRow(columnValus);
				}
			}
		} catch (InterruptedException e1) {
			table.removeAll();
			e1.printStackTrace();
		}
	}
	/**
	 * ������뵼��������Ϣ
	 */
	private void clearTableMsg() {
		clear();
	}
}
