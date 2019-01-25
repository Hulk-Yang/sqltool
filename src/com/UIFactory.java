package com;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import main.SQLTool;
   
 
public class UIFactory {  
 
    private static UIFactory instance;//��ǰ������һ��ʵ��  
    private  JFileChooser fileChooser = new JFileChooser();

    //˽�еĹ�����  
    private UIFactory(){  
          
    }  
    
  /**
   * 
   * @param frame
   * @param message
   * @return JOptionPane.YES_OPTION,JOptionPane.NO_OPTION
   */
    public  int createConfirmDialog(String message){
    	JFrame frame = SQLTool.getSQLTool().getToolFrame().getFrame();
    	return JOptionPane.showConfirmDialog(frame, message);
    }
    
    public  JFileChooser createFileChooser(int type,String extension){
		fileChooser.setFileSelectionMode(type );
		FileNameExtensionFilter filter = new FileNameExtensionFilter(extension,extension);//����������    
		fileChooser.setFileFilter(filter);//��ʼ����    
		return fileChooser;
    }
    //��õ�ǰ������ʵ��  
    public static UIFactory getInstance(){  
        if(instance==null){  
            synchronized("key1"){  
                instance=new UIFactory();  
            }  
        }  
        return instance;  
    }  
       
    //����һ����ǩ  
    public JLabel createJLabel(String text){  
        JLabel l=new JLabel(text);  
        return l;  
    }  
    //����һ����ͼ��ı�ǩ  
    public JLabel createJLabel(String text,Icon icon){  
        JLabel l=new JLabel(text);  
        l.setIcon(icon);  
        return l;  
    }  
      
      
    //ר�Ų�����ť��������ӿ�ݼ�      �ı���ʾ  ����  ����   ������  ������Χ  ������  �Ƿ��Խ�  
    public JButton createJButton(String text,int mn,String command,ImageIcon icon,int key_keyEvent,int input_inputEvent,int when_invoke_jComponent,ActionListener al,boolean isFocus){  
        JButton button=new JButton(text,icon);  
        //����Ĭ�ϻ���alt+'mn'  
        button.setMnemonic(mn);//���ø�����  
        button.setActionCommand(command);//���ö���  
        button.addActionListener(al);  
        KeyStroke stroke=KeyStroke.getKeyStroke(key_keyEvent,input_inputEvent,isFocus);  
        button.registerKeyboardAction(al,command,stroke,when_invoke_jComponent);  
        button.setFocusable(isFocus);  
        return button;  
    }  
    //ר�Ų�����ť                     �ı���ʾ  ����  ������  �Ƿ��Խ�  
    public JButton createJButton(String text,String command,ImageIcon icon,ActionListener al,boolean isFocus){  
        JButton button=new JButton(text,icon);  
        button.setActionCommand(command);//���ö���  
        button.addActionListener(al);//����¼�����  
        button.setFocusable(isFocus);  
        return button;  
    }  
    //ר�Ų�����ť��������ӿ�ݼ� �ı���ʾ  ����  ����   ������  ������Χ  ������  �Ƿ��Խ�  
    public JButton createJButton(String text,int mn,String command,ImageIcon icon,int width,int height,int key_keyEvent,int input_inputEvent,int when_invoke_jComponent,ActionListener al,boolean isFocus){  
 
        JButton button=new JButton(text,icon);//ָ����ť��  �ı���ͼƬ  
        //����Ĭ�ϻ���alt+'mn'  a    
        button.setMnemonic(mn);//���ø�����  
        button.setActionCommand(command);//���ö���  ����ӡ�  
 
 
        button.setPreferredSize(new Dimension(width,height));//ָ����ť�Ĵ�С  
        button.addActionListener(al);  
        KeyStroke stroke=KeyStroke.getKeyStroke(key_keyEvent,input_inputEvent,isFocus);  
        button.registerKeyboardAction(al,command,stroke,when_invoke_jComponent);  
        button.setFocusable(isFocus);  
        return button;  
    }  
    //ר�Ų�����ť                     �ı���ʾ  ����  ������  �Ƿ��Խ�  
    public JButton createJButton(String text,String command,ImageIcon icon,int width,int height,ActionListener al,boolean isFocus){  
        JButton button=new JButton(text,icon);  
        button.setActionCommand(command);//���ö���  
        button.setPreferredSize(new Dimension(width,height));  
        button.addActionListener(al);//����¼�����  
        button.setFocusable(isFocus);  
        return button;  
    }  
    //�����ı���   Ĭ���ı�  �ı����С�� �Ƿ�ɱ༭  
    public JTextField createJTextField(String text,int cols,boolean isEditable){  
        JTextField field=new JTextField(text,cols);  
        field.setEditable(isEditable);  
        return field;  
    }  
    //�����ı���   Ĭ���ı�  �ı����С�� �Ƿ�ɱ༭  ��������  
    public JTextField createJTextField(String text,int cols,boolean isEditable,Font f){  
        JTextField field=new JTextField(text,cols);  
        field.setEditable(isEditable);  
        field.setFont(f);  
        return field;  
    }  
    //�����ı���    Ĭ���ı�  ����  ����  �Ƿ�ɱ༭  
    public JTextArea createJTextArea(String text,int cols,int rows,boolean isEditable,boolean lineWrap,boolean wrapStyleWord){  
        JTextArea area=new JTextArea(text,cols,rows);  
        area.setEditable(isEditable);  
        area.setLineWrap(lineWrap);  
        area.setWrapStyleWord(wrapStyleWord);  
        return area;  
    }  
    //�����ı���    Ĭ���ı�  ����  ����  �Ƿ�ɱ༭  ��������   
    public JTextArea createJTextArea(String text,int cols,int rows,boolean isEditable,boolean lineWrap,boolean wrapStyleWord,Font f){  
        JTextArea area=new JTextArea(text,cols,rows);  
        area.setEditable(isEditable);  
        area.setFont(f);  
        area.setLineWrap(lineWrap);  
        area.setWrapStyleWord(wrapStyleWord);  
        return area;  
    }  
    //�����ı���    Ĭ���ı�  ����  ����  �Ƿ�ɱ༭  ��������  ������ɫ  ǰ����ɫ  
    public JTextArea createJTextArea(String text,int cols,int rows,boolean isEditable,Font f,boolean lineWrap,boolean wrapStyleWord,Color background, Color foreground){  
        JTextArea area=new JTextArea(text,cols,rows);  
        area.setEditable(isEditable);  
        area.setFont(f);  
        area.setLineWrap(lineWrap);  
        area.setWrapStyleWord(wrapStyleWord);  
        area.setBackground(background);  
        area.setForeground(foreground);  
        return area;  
    }  
    //����һ���������  
    public JScrollPane createJScrollPane(Container c){  
        JScrollPane sc=new JScrollPane(c);  
        return sc;  
    }  
    public static void main(String args[]){  
          
        UIFactory factory = UIFactory.getInstance();  
 
        //JScrollPane pan = factory.createJScrollPane(new JFrame(),JScrollPane.horizontalScrollBar,JScrollPane.verticalScrollBarPolicy);  
          
    }  
    //����һ��ָ����ֱ��ˮƽ�������ԵĹ������  ˮƽ��������  ��ֱ��������  
    public JScrollPane createJScrollPane(Container c,int horizontal_policy,int vertical_policy){  
        JScrollPane sc=new JScrollPane();  
        sc.setHorizontalScrollBarPolicy(horizontal_policy);  
        sc.setVerticalScrollBarPolicy(vertical_policy);  
        return sc;  
    }  
    //���ÿ������                    ����Ŀ��  �رղ���  x,y,width,height   
    public void setJFrameAttributes(JFrame f,String title,int close_policy,int x,int y,int width,int height,boolean isResizable){  
        f.setTitle(title);  
        f.setDefaultCloseOperation(close_policy);  
        f.setLocation(x,y);  
        f.setSize(width,height);  
        f.setResizable(isResizable);  
    }  
      
    //���ÿ������                    ����Ŀ��  �رղ���  x,y,width,height   
    public void setJFrameAttributes(JFrame f,String title,int close_policy,int x,int y,int width,int height,boolean isResizable,WindowListener wl){  
        f.setTitle(title);  
        f.setDefaultCloseOperation(close_policy);  
        f.setLocation(x,y);  
        f.setSize(width,height);  
        f.setResizable(isResizable);  
        f.addWindowListener(wl);  
    }  
    //����һ���б����   ��Ŀ���  
    public JList createJList(int cell_width){  
        JList list=new JList();  
        list.setFixedCellWidth(cell_width);  
        return list;  
    }  
    //����һ���б����   ��Ŀ���  �б�ѡ�������  
    public JList createJList(int cell_width,ListSelectionListener lsl){  
        JList list=new JList();  
        list.setFixedCellWidth(cell_width);  
        list.addListSelectionListener(lsl);  
        return list;  
    }  
    //����һ���б����   ��Ŀ���  ��Ŀ���  Դ����  
    public JList createJList(int cell_width,int cell_height,Vector<Object> v,ListSelectionListener lsl){  
        JList list=new JList(v);  
        list.setFixedCellWidth(cell_width);  
        list.setFixedCellHeight(cell_height);  
        list.addListSelectionListener(lsl);  
        return list;  
    }  
    //����һ���б����   ��Ŀ���  ��Ŀ���  Դ����  
    public JList createJList(int cell_width,int cell_height,Object[] data,ListSelectionListener lsl){  
        JList list=new JList(data);  
        list.setFixedCellWidth(cell_width);  
        list.setFixedCellHeight(cell_height);  
        list.addListSelectionListener(lsl);  
        return list;  
    }  
    //���һ������BorderLayout���ֵ����  
    public JPanel createBorderJPanel(){  
        JPanel p=new JPanel();  
        p.setLayout(new BorderLayout());  
        return p;  
    }  
    //���һ������BorderLayout���ֵ����  
    public JPanel createBorderJPanel(int row_distance,int col_distance){  
        JPanel p=new JPanel();  
        p.setLayout(new BorderLayout(row_distance,col_distance));  
        return p;  
    }  
    //���һ������GridLayout���ֵ����  ָ���������������о࣬�о�  
    public JPanel createGridJPanel(int rows,int cols,int col_distance,int row_distance){  
        JPanel p=new JPanel();  
        p.setLayout(new GridLayout(rows,cols,col_distance,row_distance));  
        return p;  
    }  
    //���һ������GridLayout���ֵ����  
    public JPanel createGridJPanel(int rows,int cols){  
        JPanel p=new JPanel();  
        p.setLayout(new GridLayout(rows,cols));  
        return p;  
    }  
    //���һ�����п�Ƭ���ֵ����  
    public JPanel createCardJPanel(CardLayout card){  
        JPanel p=new JPanel();  
        p.setLayout(card);  
        return p;  
    }  
    //���һ�����о��Բ��ֵĵ����  
    public JPanel createAbsoluteJPanel(){  
        JPanel p=new JPanel();  
        p.setLayout(null);  
        return p;  
    }  
    //���һ������FlowLayout��ʽ���ֵ����  
    public JPanel createFlowJPanel(){  
        JPanel p=new JPanel();  
        p.setLayout(new FlowLayout());  
        return p;  
    }  
    //���һ������FlowLayout��ʽ���ֵ����  
    public JPanel createFlowJPanel(int policy,int col_distance,int row_distance){  
        JPanel p=new JPanel();  
        p.setLayout(new FlowLayout( policy, col_distance, row_distance));  
        return p;  
    }  
    //���һ������FlowLayout��ʽ���ֵ����  ָ�����Ҷ��뷽ʽ  
    public JPanel createFlowJPanel(int leftOrRight_policy){  
        JPanel p=new JPanel();  
        p.setLayout(new FlowLayout(leftOrRight_policy));  
        return p;  
    }  
    //���һ�����м������Ĳ˵�ѡ��  
    public JMenuItem createJMenuItem(String text,String command,ActionListener al){  
        JMenuItem item=new JMenuItem(text);  
        item.addActionListener(al);  
        item.setActionCommand(command);  
        return item;  
    }  
    //���һ��JRadioButton��ť  
    public JRadioButton createJRadioButton(){  
        JRadioButton jrb=new JRadioButton();  
        return jrb;  
    }  
    //���һ����ItemListener��������JRadioButton��ť  
    public JRadioButton createJRadioButton(ItemListener il){  
        JRadioButton jrb=new JRadioButton();  
        jrb.addItemListener(il);  
        return jrb;  
    }  
    //���һ����ѡ��  
    public JCheckBox createJCheckBox(){  
        JCheckBox box=new JCheckBox();  
        return box;  
    }  
    //���һ�������б��  
    public JComboBox createJComboBox(String[] data){  
        JComboBox box=new JComboBox(data);  
        return box;  
    }  
    //���һ�������б��  
    public JComboBox createJComboBox(Vector data){  
        JComboBox box=new JComboBox(data);  
        return box;  
    }  
    //���һ�������б��  
    public JComboBox createJComboBox(String[] data,int width,int height){  
        JComboBox box=new JComboBox(data);  
        box.setPreferredSize(new Dimension(width,height));  
        return box;  
    }  
    //���һ�������б��  
    public JComboBox createJComboBox(Vector data,int width,int height){  
        JComboBox box=new JComboBox(data);  
        box.setPreferredSize(new Dimension(width,height));  
        return box;  
    }  
    //���һ����ItemListener�������б��  
    public JComboBox createJComboBox(Vector data,ItemListener il){  
        JComboBox box=new JComboBox(data);  
        box.addItemListener(il);  
        return box;  
    }  
    //���һ����ItemListener�������б��  
    public JComboBox createJComboBox(String[] data,ItemListener il){  
        JComboBox box=new JComboBox(data);  
        box.addItemListener(il);  
        return box;  
    }  
    //���һ����ItemListener�������б��  
    public JComboBox createJComboBox(Vector data,int width,int height,ItemListener il){  
        JComboBox box=new JComboBox(data);  
        box.setMaximumSize(new Dimension(width,height));  
        box.setMinimumSize(new Dimension(width,height));  
        box.addItemListener(il);  
        return box;  
    }  
    //���һ����ItemListener�������б��  
    public JComboBox createJComboBox(String[] data,int width,int height,ItemListener il){  
        JComboBox box=new JComboBox(data);  
        box.setMaximumSize(new Dimension(width,height));  
        box.setMinimumSize(new Dimension(width,height));  
        box.addItemListener(il);  
        return box;  
    }  
    //����һ��ѡ����  
    public JTabbedPane createJTabbedPane(){  
        JTabbedPane tab=new JTabbedPane();  
        return tab;  
    }  
    //����һ��ָ��λ�õ�ѡ����  
    public JTabbedPane createJTabbedPane(int pos){  
        JTabbedPane tab=new JTabbedPane(pos);  
        return tab;  
    }  
    //����һ����ChangeListener��ѡ����  
    public JTabbedPane createJTabbedPane(ChangeListener cl){  
        JTabbedPane tab=new JTabbedPane();  
        tab.addChangeListener(cl);  
        return tab;  
    }  
    //����һ���Ƿ���Ը����Ĺ�����  
    public JToolBar createJToolBar(boolean isFloatable){  
        JToolBar bar =new JToolBar();  
        bar.setFloatable(isFloatable);  
        return bar;  
    }  
    //����һ��JTextPane���  
    public JTextPane createJTextPane(boolean isEditable){  
        JTextPane p=new JTextPane();  
        p.setEditable(isEditable);  
        return p;  
    }  
    //����һ��JTextPane���  
    public JTextPane createJTextPane(boolean isEditable,Color background,Color foreground){  
        JTextPane p=new JTextPane();  
        p.setEditable(isEditable);  
        p.setBackground(background);  
        p.setForeground(foreground);  
        return p;  
    }  
    //����һ��������  
    public JProgressBar createJProgressBar(int min,int max,int value,boolean stringPainted,boolean borderPainted){  
        JProgressBar bar=new JProgressBar();  
        bar.setMinimum(min);  
        bar.setMaximum(max);  
        bar.setBorderPainted(borderPainted);  
        bar.setStringPainted(stringPainted);  
        bar.setValue(value);  
        return bar;  
    }  
    //����һ��ָ����С�Ľ�����  
    public JProgressBar createJProgressBar(int min,int max,int value,boolean stringPainted,boolean borderPainted,Dimension d){  
        JProgressBar bar=new JProgressBar();  
        bar.setMinimum(min);  
        bar.setMaximum(max);  
        bar.setBorderPainted(borderPainted);  
        bar.setStringPainted(stringPainted);  
        bar.setValue(value);  
        bar.setPreferredSize(d);  
        return bar;  
    }  
    //����һ���ָ����                       �ָ����1  �ָ����2   ˮƽ��ֱ�ָ�  �ָ���λ��   �ָ������  �Ƿ������  
    public JSplitPane createJSplitPane(Container c1,Container c2,int horizontalOrVertical,int dividerLoaction,int dividerSize,boolean expandable){  
        JSplitPane splitPane=new JSplitPane(horizontalOrVertical,  
                true,c1,c2);  
        splitPane.setDividerLocation(dividerLoaction);  
        splitPane.setOneTouchExpandable(expandable);  
        splitPane.setDividerSize(dividerSize);  
        return splitPane;  
    }  
    //����һ��JToggleButton  
    public JToggleButton createJToggleButton(String text,String command,Icon icon,int width,int height,ActionListener al, boolean selected){  
        JToggleButton button=new JToggleButton(text,icon,selected);  
        button.setActionCommand(command);  
        button.addActionListener(al);  
        button.setPreferredSize(new Dimension(width,height));  
        return button;  
    }  
    //����һ��JToggleButton  
    public JToggleButton createJToggleButton(String text,String command,Icon icon,int width,int height,ActionListener al){  
        JToggleButton button=new JToggleButton(text,icon);  
        button.setActionCommand(command);  
        button.addActionListener(al);  
        button.setPreferredSize(new Dimension(width,height));  
        return button;  
    }  
    //���������������������  
    public JPanel createJPanelWithComponents(JLabel label,Container field,int policy){  
        JPanel p=this.createFlowJPanel(policy);  
        p.add(label);  
        p.add(field);  
        return p;  
    }  
    //��������������������������  
    public JPanel createJPanelWithComponents(Container c1,Container c2,int policy){  
        JPanel p=this.createFlowJPanel(policy,0,0);  
        p.add(c1);  
        p.add(c2);  
        return p;  
    }  
    //��������������������������  
    public JPanel createJPanelWithComponents(Container c1,Container c2,Container c3,int policy){  
        JPanel p=this.createFlowJPanel(policy,0,0);  
        p.add(c1);  
        p.add(c2);  
        p.add(c3);  
        return p;  
    }  
    //�������ĸ�����������������  
    public JPanel createJPanelWithComponents(Container c1,Container c2,Container c3,Container c4,int policy){  
        JPanel p=this.createFlowJPanel(policy,0,0);  
        p.add(c1);  
        p.add(c2);  
        p.add(c3);  
        p.add(c4);  
        return p;  
    }  
    //����һ����ͨ���  
    public JTable createJTable(){  
        JTable table=new JTable();  
        return table;  
    }  
    //����һ����AbstractTableModel�ı��  
    public JTable createJTable(AbstractTableModel model){  
        JTable table=new JTable(model);  
        return table;  
    }  
    //����һ�������  
    //�����ı���   Ĭ���ı�  �ı����С�� �Ƿ�ɱ༭  
    public JPasswordField createJPasswordField(String text,int cols,boolean isEditable){  
        JPasswordField field=new JPasswordField(text,cols);  
        field.setEditable(isEditable);  
        return field;  
    }  
       
    //����һ�����������Ĳ˵���  
    public MenuItem createMenuItem(String text,ActionListener al){  
        MenuItem mi=new MenuItem(text);  
        mi.addActionListener(al);  
        return mi;  
    }  
    //����һ�����������Ĳ˵���  
    public MenuItem createMenuItem(String text,String command,ActionListener al){  
        MenuItem mi=new MenuItem(text);  
        mi.setActionCommand(command);  
        mi.addActionListener(al);  
        return mi;  
    }  
}  