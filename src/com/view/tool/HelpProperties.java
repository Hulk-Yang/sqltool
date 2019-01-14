package com.view.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//����Properties�ೣ�õĲ���
public class HelpProperties {
	private static final String property = System.getProperty("user.dir");

	private static Map<String,Properties> cache =new HashMap<String, Properties>();
    //����Key��ȡValue
    public static String GetValueByKey(String fileName, String key) {
    	Properties properties2 = cache.get(fileName);
    	if(properties2!=null){
    		return (String) properties2.get(key);
    	}
    	Properties properties = getAllProperties(fileName);
    	return (String) properties.get(key);
    }
    
    //��ȡProperties��ȫ����Ϣ
    private static Properties getAllProperties(String fileName)  {
    	Properties properties = cache.get(fileName);
    	InputStreamReader in = null;
    		properties = new Properties();
		try {
			in = new InputStreamReader(new FileInputStream(property + "\\config\\"+fileName),"UTF-8");
			properties.load(in);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		cache.put(fileName, properties);
        return properties;
        
    }
    
    //��ȡProperties��ȫ����Ϣ
    public static Properties remove(String fileName,String key)   {
        Properties pps = new Properties();
        InputStreamReader in = null;
        FileOutputStream  out= null;
        OutputStreamWriter isr = null;
		try {
			in = new InputStreamReader(new FileInputStream(property + "\\config\\"+fileName),"UTF-8");
			pps.load(in);
			pps.remove(key);
			out = new FileOutputStream(property + "\\config\\"+fileName);
			isr = new OutputStreamWriter(out, "UTF-8");  
			pps.store(out, "==== after remove ====");
			pps = getAllProperties(fileName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(isr!=null){
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
        return pps;
        
    }
    
    //д��Properties��Ϣ
    public static void WriteProperties (String fileName, String pKey, String pValue)  {
        Properties pps = new Properties();
        InputStreamReader in = null;
        OutputStream out = null;
		try {
			in = new InputStreamReader(new FileInputStream(property + "\\config\\"+fileName),"UTF-8"); 
        //���������ж�ȡ�����б�����Ԫ�ضԣ� 
        pps.load(in);
        //���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�  
        //ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
        out = new FileOutputStream(property + "\\config\\"+fileName);
        OutputStreamWriter isr = new OutputStreamWriter(out, "UTF-8");   

        pps.setProperty(pKey, pValue);
        //���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��  
        //���� Properties ���е������б�����Ԫ�ضԣ�д�������  
        pps.store(isr, "Update " + pKey + " name");
		pps = getAllProperties(fileName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				out.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    
    
    public static void main(String [] args) throws IOException{
        //String value = GetValueByKey("Test.properties", "name");
        //System.out.println(value);
        //GetAllProperties("Test.properties");
        WriteProperties("Test.properties","long", "212");
    }

	public static Properties getAll(String fileName) {
		Properties properties2 = cache.get(fileName);
    	if(properties2!=null){
    		return properties2;
    	}
    	Properties properties = getAllProperties(fileName);
    	return properties;
	}
}