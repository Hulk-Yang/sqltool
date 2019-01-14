package com.view.system.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.tree.TreeModel;

import com.dao.ConnectionPool;
import com.entity.DataBaseType;
import com.entity.DriverPathInfo;
import com.entity.LoginInfo;
import com.ui.XMLConnectionsConfig;
import com.ui.extensible.UITabbedPane;
import com.ui.tree.IconMutableTreeNode;
import com.ui.tree.UITree;
import com.view.sqloperate.Controller;
import com.view.sqloperate.QuerySqlTab;
import com.view.system.perferenc.xml.XMLJdbcConfig;

import main.SQLTool;

/**
 * �½��������ݿ�Ի���
 * 
 * @author Administrator
 * 
 */
public class FindDialog extends JDialog{

	private static FindDialog find;
	private Component parent;
	private LoginInfo loginInfo;
	private LoginInfo connInfo_old;
	private IconMutableTreeNode treeNode;

	private JComboBox dataTypeList;
	private JComboBox driverList;
	private JTextField name;
//	private JTextField dataBaseUrl;
	private JTextField user;
	
	private JTextField ip;
	private JTextField port;
	private JTextField example;


	private JPasswordField password;
	private JFileChooser fileChooser = new JFileChooser("D:\\");

	private final int WIDTH =300;
	private final int HEIGHT = 120;
//	private JDialog dialog;
	private final XMLConnectionsConfig info = XMLConnectionsConfig.getConnDataBaseInfo();
	private Hashtable<String, DriverPathInfo> driverPathsArr = XMLJdbcConfig.getXMLJdbcConfig().getDriverPathsArr();
	private JTextField pdm;

	private FindListener findL;
	private FindDialog(JFrame jFrame) {
		super( jFrame, "����/�滻", false);
		this.parent = jFrame;
		init();
	}

	public FindDialog() {
		this(SQLTool.getSQLTool().getToolFrame().getFrame());
	}

	public FindDialog(IconMutableTreeNode treeNode) {
		this(SQLTool.getSQLTool().getToolFrame().getFrame());
	}
	private static final long serialVersionUID = 1L;

	private void init() {

//		dialog = new JDialog((Frame) parent, "�������ݿ�", false);
		setSize(WIDTH, HEIGHT);
//		setLayout(new GridLayout(9, 1, 4, 8));
		JPanel p = new JPanel(new BorderLayout());
		GridBagLayout gridBagLayout = new GridBagLayout();
		JPanel logP = new JPanel(gridBagLayout);
		p.add(logP,BorderLayout.CENTER);
		setLayout(new BorderLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets.bottom=4;
		constraints.insets.left=4;
		constraints.insets.right=2;
		constraints.insets.right=2;
		constraints.fill = GridBagConstraints.BOTH;
		
		JLabel aL = new JLabel("���ң�", JLabel.RIGHT);
		constraints.gridwidth=2;
		constraints.weightx = 0;
		constraints.weighty=0;
		gridBagLayout.setConstraints(aL, constraints);
		logP.add(aL);
		
		constraints.gridwidth=0;
		constraints.weightx = 1;
		constraints.weighty=0;
		dataTypeList = new JComboBox();
		dataTypeList.setEditable(true);
		gridBagLayout.setConstraints(dataTypeList, constraints);
		logP.add(dataTypeList);
		
		JLabel bL = new JLabel("�滻��", JLabel.RIGHT);
		constraints.gridwidth=2;
		constraints.weightx = 0;
		constraints.weighty=0;
		gridBagLayout.setConstraints(bL, constraints);
		logP.add(bL);
		
		driverList = new JComboBox();
		
		driverList.setEditable(true);
		constraints.gridwidth=0;
		constraints.weightx = 1;
		constraints.weighty=0;
		gridBagLayout.setConstraints(driverList, constraints);
		logP.add(driverList);
		
//		JLabel cL = new JLabel("IP��", JLabel.RIGHT);
//		constraints.gridwidth=2;
//		constraints.weightx = 0;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(cL, constraints);
//		logP.add(cL);

//		ip = new JTextField(12);
//		constraints.gridwidth=0;
//		constraints.weightx = 1;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(ip, constraints);
//		logP.add(ip);
//		
//		JLabel portL = new JLabel("�˿ںţ�", JLabel.RIGHT);
//		constraints.gridwidth=2;
//		constraints.weightx = 0;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(portL, constraints);
//		logP.add(portL);
//		
//		
//		port = new JTextField();
//		constraints.gridwidth=0;
//		constraints.weightx = 1;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(port, constraints);
//		logP.add(port);
//
//		
//		
//		JLabel dL = new JLabel("ʵ����", JLabel.RIGHT);
//		constraints.gridwidth=2;
//		constraints.weightx = 0;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(dL, constraints);
//		logP.add(dL);
//		
//		example = new JTextField(12);
//		constraints.gridwidth=0;
//		constraints.weightx = 1;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(example, constraints);
//		logP.add(example);
//		
//		JLabel eL = new JLabel("�û�����", JLabel.RIGHT);
//		constraints.gridwidth=2;
//		constraints.weightx = 0;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(eL, constraints);
//		logP.add(eL);
//
//		user = new JTextField(12);
//		constraints.gridwidth=0;
//		constraints.weightx = 1;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(user, constraints);
//		logP.add(user);
//		
//		JLabel fL = new  JLabel("���룺", JLabel.RIGHT);
//		constraints.gridwidth=2;
//		constraints.weightx = 0;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(fL, constraints);
//		logP.add(fL);
//		
//		password = new JPasswordField(12);
//		constraints.gridwidth=0;
//		constraints.weightx = 1;
//		constraints.weighty=0;
//		gridBagLayout.setConstraints(password, constraints);
//		logP.add(password);

		JPanel butonP = new JPanel(new GridLayout(1, 3, 8, 8));
		
		
		
		
		
		constraints.gridwidth=0;
		constraints.weightx = 1;
		constraints.weighty=0;
		gridBagLayout.setConstraints(butonP, constraints);
		logP.add(butonP);
		JButton logon = new JButton("����");
		butonP.add(logon);
		logon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(dataTypeList.getSelectedItem()!=null){
					addItem("");
					find(dataTypeList.getSelectedItem().toString());
				}
				
				if(driverList.getSelectedItem()!=null){
					
					LinkedList<String> varr1 = new LinkedList();
					for (int i = 0; i<driverList.getItemCount(); i++) {
						Object itemAt1 = driverList.getItemAt(i);
						if(driverList.getSelectedItem().equals(itemAt1)){
							continue;
						}
						if(itemAt1!=null){
							varr1.addLast(itemAt1.toString());
						}
					}
					varr1.addFirst(driverList.getSelectedItem().toString());
					driverList.removeAllItems();
					
					for (int j = 0; j< varr1.size()&&j<8; j++) {
						driverList.addItem( varr1.get(j));	
					}
					driverList.repaint();
				}
			}
		});
		logon.addMouseListener(new LogOnMouse(treeNode));
		JButton cancel = new JButton("�滻");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
				Component selectedComponent = tabQuerySql.getSelectedComponent();
				QuerySqlTab editSqlTab = (QuerySqlTab)selectedComponent;
//				String selectedText = editSqlTab.getEditSqlText().getSelectedText();	
				String string = driverList.getSelectedItem().toString();
				if(string==null||"".equals(string)){
					return;
				}
				editSqlTab.getEditSqlText().replaceSelection(string);
				Object selectedItem = dataTypeList.getSelectedItem();
				if(selectedItem!=null){
					find(selectedItem.toString());
				}
			}
		});
		butonP.add(cancel);
		cancel.addMouseListener(new LogOnMouse(treeNode));
		add(p,BorderLayout.NORTH);
		setLocationRelativeTo(null);
	}
	
	private void addItem(String str) {
		LinkedList<String> varr = new LinkedList();
		for (int i = 0; i<dataTypeList.getItemCount(); i++) {
			Object itemAt = dataTypeList.getItemAt(i);
			if(dataTypeList.getSelectedItem().equals(itemAt)){
				continue;
			}
			if(itemAt!=null){
				varr.addLast(itemAt.toString());
			}
		}
		if(str!=null&&!"".equals(str)){
			varr.addFirst(str);
		}else{
			varr.addFirst(dataTypeList.getSelectedItem().toString());
		}
		dataTypeList.removeAllItems();

//		Collections.reverse(varr);
		for (int j = 0; j< varr.size()&&j<8; j++) {
			dataTypeList.addItem( varr.get(j));	
		}
		dataTypeList.repaint();
	}
	/**
	 * 
	 * @param treeNode ��������ڵ㣨��½ʱѡ��ĵ�¼�ڵ㣩
	 */
	public void setTreeNode(IconMutableTreeNode treeNode) {
		this.treeNode = treeNode;
		this.loginInfo = (LoginInfo) treeNode.getUserObject();
		name.setText(this.loginInfo.getName());
		dataTypeList.setSelectedItem(XMLJdbcConfig.getXMLJdbcConfig().getDataBaseTypes().get(this.loginInfo.getDataType()));
		driverList.setSelectedItem(XMLJdbcConfig.getXMLJdbcConfig().getDriverPaths().get(this.loginInfo.getDriverClass()));
//		dataBaseUrl.setText(this.loginInfo.getUrl());
		
//		DriverPathInfo driverPathInfo = driverPathsArr.get(((DriverPathInfo) driverList.getSelectedItem()).getName());
		ip.setText(this.loginInfo.getIp());
		pdm.setText(this.loginInfo.getPdm());
		port.setText(this.loginInfo.getPort());
		example.setText(this.loginInfo.getExample());
		user.setText(this.loginInfo.getUserName());
		password.setText(this.loginInfo.getPassword());
		
		
		
		try {
			connInfo_old = (LoginInfo) this.loginInfo.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	private void updata() throws CloneNotSupportedException{
		
		loginInfo.setName(name.getText());
		if( dataTypeList.getSelectedItem()!=null)
			loginInfo.setDataType(((DataBaseType) dataTypeList.getSelectedItem()).getName());
		if( driverList.getSelectedItem()!=null)
		loginInfo.setDriverClass(((DriverPathInfo) driverList.getSelectedItem()).getName());
//		loginInfo.setUrl(this.dataBaseUrl.getText());
		loginInfo.setIp(ip.getText());
		loginInfo.setPort(port.getText());
		loginInfo.setExample(example.getText());
		loginInfo.setUserName(user.getText());
		loginInfo.setPassword(password.getText());
		loginInfo.setPdm(pdm.getText());
	}
	class LogOnMouse extends MouseAdapter{
		private IconMutableTreeNode node;
		public LogOnMouse(IconMutableTreeNode treeNode){
			this.node =treeNode;
		}
		@Override
		public void mouseClicked(MouseEvent event) {
			if(((JButton)event.getSource()).getText().equals("��¼")){
				int ecp = 0;
				try {
					try {
						updata();
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
					
					boolean addConnectionInfo = info.updateConnectionInfo(loginInfo,connInfo_old);
					if(!addConnectionInfo){
						JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "����Դ���ƣ�"+name.getText()+" �Ѵ���,��������д��");
						ecp = -1;
						name.selectAll();
						name.grabFocus();
					}
					else{
						try {
							loginInfo.setIsLive(ConnectionPool.DENG);
							if(loginInfo.getDataType()==null){
								JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "���ݿ����Ͳ���Ϊ�գ�");
								return;
							}
							if(loginInfo.getDriverClass()==null){
								JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "��������Ϊ�գ�");
								return;
							}
							if(loginInfo.getUserName()==null){
								JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "�û�������Ϊ�գ�");
								return;
							}
							if(loginInfo.getUrl()==null){
								JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "���ݿ�url����Ϊ�գ�");
								return;
							}
							if(loginInfo.getUrl()==null){
								JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "���ݿ�url����Ϊ�գ�");
								return;
							}
							if(loginInfo.getPassword()==null){
								JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "���벻��Ϊ�գ�");
								return;
							}
							Controller.newController().loginIn(loginInfo);
							treeNode.setUserObject(loginInfo);
							 UITree dataBaseTree = SQLTool.getSQLTool().getToolFrame().getSqlView().getDataBaseTree();
								TreeModel model = dataBaseTree.getModel();
								IconMutableTreeNode root = (IconMutableTreeNode) model.getRoot();
								Enumeration children = root.children();
								IconMutableTreeNode needAddNode = null;
								while (children.hasMoreElements()) {
									IconMutableTreeNode node = (IconMutableTreeNode) children.nextElement();
									if (node.getUserObject() instanceof LoginInfo) {
										LoginInfo user = (LoginInfo) node.getUserObject();
										if (user.equals(loginInfo)) {
											needAddNode  = node;
											break;
										}
									}
								}
								needAddNode.runIoc();
						} catch (ClassNotFoundException e) {
							ecp = -1;
							JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "û���ҵ�jar����");
							e.printStackTrace();
						} catch (SQLException e) {
							ecp = -1;
							JOptionPane.showMessageDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "�û������������");
							e.printStackTrace();
						}
					}
					if(ecp ==0){
						setVisible(false);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(((JButton)event.getSource()).getText().equals("ȡ��")){
//				updata();
//				int showConfirmDialog =-999;
//				if(!loginInfo.equals(connInfo_old)){
//					showConfirmDialog = JOptionPane.showConfirmDialog(SQLTool.getSQLTool().getToolFrame().getFrame(), "��Ϣ�Ѹ����Ƿ����ȡ���༭��","��ʾ",JOptionPane.YES_OPTION);
//				}
//				if(showConfirmDialog==0){
					loginInfo.setDataType(connInfo_old.getDataType());
					loginInfo.setDriverClass(connInfo_old.getDriverClass());
					loginInfo.setName(connInfo_old.getName());
					loginInfo.setPassword(connInfo_old.getPassword());
					loginInfo.setUrl(connInfo_old.getUrl());
					loginInfo.setUserName(connInfo_old.getUserName());
					treeNode.setUserObject(loginInfo);
					SQLTool.getSQLTool().getToolFrame().getSqlView().getDataBaseTree().updateUI();
//					
//					setVisible(false);
//				}
//				else{
					setVisible(false);
//				}
			}
		}
	}
	
	private void loadTables(){
		
	}
	
	private void find(String findStr){
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		Component selectedComponent = tabQuerySql.getSelectedComponent();
		QuerySqlTab editSqlTab = (QuerySqlTab)selectedComponent;
		String text = editSqlTab.getText();
		int indexOf = text.toUpperCase().indexOf(findStr.toUpperCase(),editSqlTab.getEditSqlText().getSelectionEnd());
		if(indexOf==-1||text.length()==0){
			editSqlTab.getEditSqlText().setSelectionStart(0);
			editSqlTab.getEditSqlText().setSelectionEnd(0);
			return;
		}
		editSqlTab.getEditSqlText().setSelectText(indexOf, indexOf+findStr.length());
//		editSqlTab.getEditSqlText().set
	}
	@Override
	public void setVisible(boolean paramBoolean) {
		super.setVisible(paramBoolean);
		
	}
	
	
	@Override
	public String toString() {
		return name.getText();
	}

	public void addFindListener(FindListener find){
		this.findL = find;
	}
	@Override
	public void show() {
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		Component selectedComponent = tabQuerySql.getSelectedComponent();
		QuerySqlTab editSqlTab = (QuerySqlTab)selectedComponent;
		String selectedText = editSqlTab.getEditSqlText().getSelectedText();
//		dataTypeList.set(selectedText);
		if(selectedText!=null){
			addItem(selectedText);
		}
		super.show();
	}
	public synchronized static FindDialog newFindDialog() {
		if(find==null){
			find = new FindDialog(SQLTool.getSQLTool().getToolFrame().getFrame());
		}
		return find;
	}
}


