package com.util;

import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComboBox;

import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.oracle.parser.OracleStatementParser;
import com.alibaba.druid.sql.dialect.postgresql.visitor.PGSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.stat.TableStat.Column;
import com.alibaba.druid.stat.TableStat.Name;
import com.alibaba.druid.util.JdbcConstants;
import com.entity.LoginInfo;
import com.prompt.PromptLabel;
import com.ui.extensible.UITabbedPane;
import com.view.sqloperate.QuerySqlTab;

import main.SQLTool;
 

public class SQLUtils {
 
	public static String getJdbcConstants() {
		QuerySqlTab tab = null;
		UITabbedPane tabQuerySql = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
		Component component = tabQuerySql.getSelectedComponent();
		if (component instanceof QuerySqlTab) {
			 tab = (QuerySqlTab) component;
		}
		JComboBox connectionList = tab.getConnectionList();
		LoginInfo info = (LoginInfo) ((PromptLabel)connectionList.getSelectedItem()).getUser();
		String dataType = info.getDataType();
		String oracleDriver = JdbcConstants.MARIADB_DRIVER;
		switch (dataType) {
		case "Oracle":
			oracleDriver = JdbcConstants.ORACLE_DRIVER;
			break;
		case "mysql":
			oracleDriver = JdbcConstants.MYSQL_DRIVER;
			break;
		default:
			break;
		}
		return oracleDriver;
	}
	public static String  getTableName(String aliasTableName ,String sql) {
		try {
			List<SQLStatement> stmtList = com.alibaba.druid.sql.SQLUtils.parseStatements(sql.replace(aliasTableName+".", aliasTableName), getJdbcConstants());
			for (int i = 0; i < stmtList.size(); i++) {
				SQLStatement stmt = stmtList.get(i);
				PGSchemaStatVisitor visitor = new PGSchemaStatVisitor();
				stmt.accept(visitor);
				Map<String, String> aliasmap = visitor.getAliasMap();
				return aliasmap.get(aliasTableName)==null?"":aliasmap.get(aliasTableName);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
        return "";
	}
    public static void main(String[] args) {
 
        String sql= ""
                + "insert into tar select * from boss_table bo, ("
                    + "select a.f1, ff from emp_table a "
                    + "inner join log_table b "
                    + "on a.f2 = b.f3"
                    + ") f "
                    + "where bo.f4 = f.f5 "
                    + "group by bo.f6 , f.f7 having count(bo.f8) > 0 "
                    + "order by bo.f9, f.f10;"
                    + "select func(f) from test1; "
                    + "";
        String dbType = JdbcConstants.ORACLE_DRIVER;
 
        //��ʽ�����
        String result = com.alibaba.druid.sql.SQLUtils.format(sql, dbType);
        System.out.println(result); // ȱʡ��д��ʽ
        List<SQLStatement> stmtList = com.alibaba.druid.sql.SQLUtils.parseStatements(sql, dbType);
 
        //�������Ķ������ĸ���
        System.out.println("size is:" + stmtList.size());
        for (int i = 0; i < stmtList.size(); i++) {
 
            SQLStatement stmt = stmtList.get(i);
            
            PGSchemaStatVisitor visitor = new PGSchemaStatVisitor();
            stmt.accept(visitor);
            Map<String, SQLObject> variants = visitor.getVariants();
            Map<String, String> aliasmap = visitor.getAliasMap();
            for (Iterator iterator = aliasmap.keySet().iterator(); iterator.hasNext();) {
                String key = iterator.next().toString();
                System.out.println("[ALIAS]" + key + " - " + aliasmap.get(key));
            }
            Set<Column> groupby_col = visitor.getGroupByColumns();
            //
            for (Iterator iterator = groupby_col.iterator(); iterator.hasNext();) {
                Column column = (Column) iterator.next();
                System.out.println("[GROUP]" + column.toString());
            }
            //��ȡ������
            System.out.println("table names:");
            Map<Name, TableStat> tabmap = visitor.getTables();
            for (Iterator iterator = tabmap.keySet().iterator(); iterator.hasNext();) {
                Name name = (Name) iterator.next();
                System.out.println(name.toString() + " - " + tabmap.get(name).toString());
            }
            //System.out.println("Tables : " + visitor.getCurrentTable());
            //��ȡ������������,�����ڱ�����
            System.out.println("Manipulation : " + visitor.getTables());
            //��ȡ�ֶ�����
            System.out.println("fields : " + visitor.getColumns());
        }
 
    }
 
}