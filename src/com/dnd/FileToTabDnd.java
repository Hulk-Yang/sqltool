package com.dnd;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

import main.SQLTool;

import com.file.ReaderFile;
import com.ico.LazyImageIcon;
import com.ui.extensible.UITabbedPane;
import com.ui.menu.listenner.TabAction;
import com.view.sqloperate.QuerySqlTab;

public class FileToTabDnd implements DropTargetListener {
    public void dragEnter( DropTargetDragEvent e ) {}
    public void dragOver( DropTargetDragEvent e ) {
    	Object target = e.getSource();
		if (!bTargetIsTab(target))
		{
			return;
		}
//		if(target instanceof UITabbedPane){
//			
//		}
//		UITabbedPane destTabbedPane = (UITabbedPane) ((DropTarget) target).getComponent();
//		
//		Point location = e.getLocation();
    }
    public void dropActionChanged( DropTargetDragEvent e ) {}
    public void dragExit( DropTargetEvent e ) {}
    public void drop( DropTargetDropEvent dtde ) {
    	try
		{ 
			Object target = dtde.getSource();
			
          if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor))//���������ļ���ʽ��֧��
          {
              dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//������ק��������
              List<File> list =  (List<File>) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
              UITabbedPane tab = SQLTool.getSQLTool().getToolFrame().getSqlView().getTabQuerySql();
              for(File file:list){
	        		LazyImageIcon lazyImageIcon = new LazyImageIcon("/imgs/tab/tabedit.png");
	        		QuerySqlTab querySqlTab = new QuerySqlTab(tab);
	        		ReaderFile reder = new ReaderFile(file.getAbsolutePath());
	        		querySqlTab.addTabActionListener(new TabAction(querySqlTab));
	        		String reader = reder.reader();
	        		querySqlTab.setFile(file.getAbsolutePath());
	        		tab.addTab("��ѯ����", lazyImageIcon, querySqlTab);
//	        		querySqlTab.setChange();
	        		querySqlTab.setText(reader);

              }
              dtde.dropComplete(true);//ָʾ��ק���������
          }
          else
          {
              dtde.rejectDrop();//����ܾ���ק��������
          }
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
    	dtde.dropComplete(true);
    }
    private String getTitle(JTabbedPane tabbedPane)
	{
		return (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
	}
	private boolean bTargetIsTab (Object target)
	{
		return true;
	}
	private Icon getIcon(JTabbedPane tabbedPane)
	{
		return tabbedPane.getIconAt(tabbedPane.getSelectedIndex());
	}
	
//	 {
//         @Override
//         public void drop(DropTargetDropEvent dtde)//��д��������drop����
//         {
//             try
//             {
//                 if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor))//���������ļ���ʽ��֧��
//                 {
//                     dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//������ק��������
//                     List<File> list =  (List<File>) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
//                     String temp="";
//                     for(File file:list)
//                         temp+=file.getAbsolutePath()+";\n";
//                     JOptionPane.showMessageDialog(null, temp);
//                     dtde.dropComplete(true);//ָʾ��ק���������
//                 }
//                 else
//                 {
//                     dtde.rejectDrop();//����ܾ���ק��������
//                 }
//             }
//             catch (Exception e)
//             {
//                 e.printStackTrace();
//             }
//         }
//     });
}