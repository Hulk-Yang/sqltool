
package com.view.system.perferenc.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.entity.DataBaseType;
import com.entity.DdlEntity;

public class XMLDDLConfig {
	private final String property = System.getProperty("user.dir");
	private static XMLDDLConfig jdbcConfig;
	private static Object o = new Object();
	private Hashtable<String , DdlEntity> typeDdl;
	/**
	 * ���ݿ������������б�ʹ��
	 */
	ArrayList<DataBaseType> dataBaseTypeList ;
	private XMLDDLConfig(){
//		getDDLDataBase();
		initDdls();
	}

	public static XMLDDLConfig getXMLDDLConfig(){
		if(jdbcConfig==null){
			synchronized (o) {
				jdbcConfig = new XMLDDLConfig();
			}
		}
		return jdbcConfig;
	}
	
	
	private Document getXMLRoot(){
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(property + ""+File.separator+"config"+File.separator+"ddlConfig.xml");
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		return document;
	}

	/**
	 * �õ��������ݿ�ddl���
	 * @return 
	 */
	private Hashtable<String, DdlEntity> initDdls(){
		typeDdl = new Hashtable<String, DdlEntity>();
		Element xmlRoot = getXMLRoot().getRootElement();
		Iterator element = xmlRoot.elementIterator("ddl");
		dataBaseTypeList= new ArrayList<DataBaseType>();
		DdlEntity ddl;
		while (element.hasNext()) {
			Element name = (Element) element.next();
			String attributeValue = name.attributeValue("name");
			Iterator iterator = name.elementIterator();
			ddl = new DdlEntity();
			typeDdl.put(attributeValue, ddl);
			while(iterator.hasNext()){
				Element elem = (Element)iterator.next();
				String name_script = elem.attributeValue("name");
				String script = elem.getText();
				ddl.setScript(name_script, script);
			}
		}
		return typeDdl;
	}
	public String getScript(String type,String name) {
		return typeDdl.get(type).getScript(name);
	}
}
