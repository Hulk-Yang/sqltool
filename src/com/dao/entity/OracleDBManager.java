package com.dao.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import main.SQLTool;

import com.dao.DBManager;
import com.entity.LoginInfo;
import com.ico.LazyImageIcon;
import com.prompt.PromptLabel;
import com.ui.extensible.UITabbedPane;
import com.ui.menu.listenner.TabAction;
import com.ui.tree.IconMutableTreeNode;
import com.ui.tree.UITree;
import com.view.sqloperate.Cache;
import com.view.sqloperate.Controller;
import com.view.sqloperate.QuerySqlTab;
import com.view.tool.PowerDesigner;
import com.view.tool.entity.PDTableEntity;

/**
 * �������ݿ���Ϣ�Ĺ����ߣ�����������ӶΣ���ռ��С
 * @author Administrator
 *
 */
public class OracleDBManager implements DBManager{
	private static OracleDBManager manager = new OracleDBManager();

	private UITree dataBaseTree;

	private OracleDBManager() {
	}

	@Override
	public void tableResultPutDBTree(ArrayList<Table> listTable, LoginInfo info)
			throws SQLException {
		Table table = null;
		
		Collections.sort(listTable, new Comparator<Table>(){

			@Override
			public int compare(Table o1, Table o2) {
				int compareTo = o1.getTableCode().compareTo(o2.getTableCode());
				return compareTo>0?-1:1;
			}
			
		});
		IconMutableTreeNode needAddChile = (IconMutableTreeNode) getNeedAddChile("Table", info);
		while(needAddChile.getChildCount()>0){
			needAddChile.remove(0);
		}
		
		DefaultTreeModel mode = (DefaultTreeModel) dataBaseTree.getModel();
		mode.reload(needAddChile);
		
		String iconName = ("/imgs/dataBaseImgs/table.gif");
		int size = listTable.size();
		PDTableEntity pdTable;
		for (int i = 0; i <size; i++) {
			table = listTable.get(i);
			pdTable = PowerDesigner.initPowerDesigner().getTable(info, table.getTableCode());
			addChildTree(new IconMutableTreeNode(new PromptLabel(table.getTableCode(),pdTable.getTableName(),PromptLabel.TABLE), iconName), needAddChile);
		}
		Cache.getCache().loadTableName(info,listTable);
	}
	
	

	public void addChildTree(IconMutableTreeNode addNode,
			DefaultMutableTreeNode needAddChile) {
		dataBaseTree.addChild(addNode, needAddChile);
	}

	/**
	 * ����ָ����¼�û�����Ҫ��Ӻ��ӽڵ�Ľڵ�
	 * @param nodeName ��Ҫ��ѯ�Ľڵ�����
	 * @param info     ��¼��Ա��Ϣ
	 * @return
	 */
	private DefaultMutableTreeNode getNeedAddChile(String nodeName,
			LoginInfo info) {
		dataBaseTree = SQLTool.getSQLTool().getToolFrame().getSqlView()
				.getDataBaseTree();

		TreeModel model = dataBaseTree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		Enumeration children = root.children();
		DefaultMutableTreeNode needAddNode = null;
		while (children.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
			if (node.getUserObject() instanceof LoginInfo) {
				LoginInfo user = (LoginInfo) node.getUserObject();
				if (user.equals(info)) {
					needAddNode  = node;
					break;
				}
			}
		}
		DefaultMutableTreeNode node = null;
		if (needAddNode != null) {
			Enumeration breadthFirstEnumeration = needAddNode
					.breadthFirstEnumeration();
			while (breadthFirstEnumeration.hasMoreElements()) {
				DefaultMutableTreeNode nextElement = (DefaultMutableTreeNode) breadthFirstEnumeration.nextElement();
				if ((nextElement.getUserObject()).toString().equals(nodeName)) {
					node = nextElement;
					break;
				}
			}
		}
		return node;
		
	}

	public static OracleDBManager getOracleDBManager() {
		return manager;
	}

	public void viewResultPutDBTree(ArrayList<Table> views, LoginInfo info) {
		Table table = null;
		
		
		IconMutableTreeNode needAddChile = (IconMutableTreeNode) getNeedAddChile("View", info);
		while(needAddChile.getChildCount()>0){
			needAddChile.remove(0);
		}
		
		DefaultTreeModel mode = (DefaultTreeModel) dataBaseTree.getModel();
		mode.reload(needAddChile);
		
		String iconName = ("/imgs/dataBaseImgs/table.gif");
		int size = views.size();
		for (int i = 0; i <size; i++) {
			table = views.get(i);
			addChildTree(new IconMutableTreeNode(new PromptLabel(table.getTableCode(),"",PromptLabel.TABLE), iconName), needAddChile);
		}		
		
		Cache.getCache().loadViewName(info,views);

	}

	/**
	 * �˵��༭ʱ������DDL����������ĵ�sql������
	 * @param viewDDL
	 * @param info
	 */
	public void viewDDLResult(String viewDDL, LoginInfo info) {
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		LazyImageIcon lazyImageIcon = new LazyImageIcon("/imgs/tab/tabedit.png");

		QuerySqlTab querySqlTab = new  QuerySqlTab(tabQuerySql);
		querySqlTab.getEditSqlText().setText(viewDDL);
		querySqlTab.getEditSqlText().setSemiColor(0,viewDDL);
		querySqlTab.addTabActionListener(new TabAction(querySqlTab));
		tabQuerySql.addTab("DDL���",lazyImageIcon.getIcon(),querySqlTab);
	}
	/**
	 * �˵��༭ʱ������DDL����������ĵ�sql������
	 * @param viewDDL
	 * @param info
	 */
	public void viewSelectSql(String sql, LoginInfo info) {
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		LazyImageIcon lazyImageIcon = new LazyImageIcon("/imgs/tab/tabedit.png");
		
		QuerySqlTab querySqlTab = new  QuerySqlTab(tabQuerySql);
		querySqlTab.getEditSqlText().setText(sql);
		querySqlTab.getEditSqlText().setSemiColor(0,sql);
		querySqlTab.addTabActionListener(new TabAction(querySqlTab));
		tabQuerySql.addTab("SELECT���",lazyImageIcon.getIcon(),querySqlTab);
	}
	/**
	 * ���ݲ�ѯ���������insert���
	 * @param viewDDL
	 * @param info
	 */
	public void viewDMLResult(StringBuffer[] viewDDL) {
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		LazyImageIcon lazyImageIcon = new LazyImageIcon("/imgs/tab/tabedit.png");
		
		QuerySqlTab querySqlTab = new  QuerySqlTab(tabQuerySql);
		StringBuffer buf =new StringBuffer();
		for (int i = 0; i < viewDDL.length; i++) {
			buf.append(viewDDL[i]);
			buf.append(";");
			buf.append("\n");
		}
		
		querySqlTab.getEditSqlText().setText(buf.toString());
//		querySqlTab.getEditSqlText().setSemiColor(0,buf.toString());
		tabQuerySql.addTab("����INSERT���",lazyImageIcon.getIcon(),querySqlTab);
	}

	public void tableSpacesResult(ArrayList<String> tableSpace, LoginInfo info) {
		
		
		IconMutableTreeNode needAddChile = (IconMutableTreeNode) getNeedAddChile("TableSpace", info);
		while(needAddChile.getChildCount()>0){
			needAddChile.remove(0);
		}
		
		DefaultTreeModel mode = (DefaultTreeModel) dataBaseTree.getModel();
		mode.reload(needAddChile);
		
		String iconName = ("/imgs/dataBaseImgs/tablespace.png");
		int size = tableSpace.size();
		for (int i = 0; i <size; i++) {
			addChildTree(new IconMutableTreeNode(new PromptLabel(tableSpace.get(i),"",PromptLabel.TABLE), iconName), needAddChile);
		}	
	}

	public void tableSpaceDDLResult(String tableSpaceDDL, LoginInfo info) {
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		LazyImageIcon lazyImageIcon = new LazyImageIcon("/imgs/tab/tabedit.png");
		QuerySqlTab querySqlTab = new  QuerySqlTab();
		querySqlTab.getEditSqlText().setText(tableSpaceDDL);
		tabQuerySql.addTab("aaa",lazyImageIcon.getIcon(),querySqlTab);		
	}

	public void refresh(LoginInfo info) throws InterruptedException, SQLException {
		Controller.newController().getTables(info);
		Controller.newController().getViews(info);
		Controller.newController().getTableSpaces(info);		
	}
	
}
