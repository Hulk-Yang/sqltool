package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ScanMain {
	public static void main(String[] args) {
    int codeLine = 0;
    //����ɨ��·��
//    String scanPath = "D:/tool/eclipse/sqltool/sqltool/src/com/jtattoo/plaf";
    String scanPath = "D:/tool/eclipse/workspace/wallet-junior";
 
    File rootFile = new File(scanPath);   // ������ʵ���س�ʼ��������ȫ��д��static�ľ����ˣ��˴���֮ǰ������ȫ�ֱ���û���ü���
    ScanMain sm = new ScanMain();
    List<File> files = new ArrayList<>();
    files = sm.scan(getAllFiles(rootFile),files);
    System.out.println(files.size());
    for(File fn :files){
     codeLine+=sm.countCode(fn);
    }
    System.out.println(codeLine);
 } // ���ж�ȡ�ļ������ۼ�����

	public int countCode(File file) {
		int i = 0;
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");// ���ǵ������ʽ
			BufferedReader bufferedReader = new BufferedReader(read);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	} // ��һ��������һ���ˡ�

	public static File[] getAllFiles(File f) {
		File[] files = f.listFiles();
		return files;
	} // ʹ�õݹ鷽ʽɨ���ļ��У�����Ŀ¼���¼������ң������ļ�����result�С�

	public List<File> scan(File[] files, List<File> result) {
		for (File fn : files) {
			if (fn.isDirectory()) {
				scan(fn.listFiles(), result);
			} else {
//				System.out.println("shi");
				result.add(fn);
			}
		}
		return result;
	}
}