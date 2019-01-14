package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	private File file = null;
	public ExcelWrite(File file){
		this.file = file;
	}
	
	public void writeExcelValue(ArrayList<String[]> arr) throws IOException  {
		//��һ��������һ��webbook����Ӧһ��Excel�ļ�
		XSSFWorkbook wb = new XSSFWorkbook();
	    //�ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
	    XSSFSheet sheet = wb.createSheet("��1");
	    //����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
//	    HSSFRow headName = sheet.createRow((int)0);
//	    HSSFRow headCode = sheet.createRow((int)1);
	    //���Ĳ���������Ԫ�񣬲�����ֵ��ͷ  ���ñ�ͷ����
	    XSSFCellStyle style = wb.createCellStyle();
	    int size = arr.size();
	    int columnSize = arr.get(0).length;
        for (int i = 0; i < size; i++) {
        	XSSFRow createRow = sheet.createRow(i);
        	for (short j = 0; j < columnSize; j++) {
        		createRow.createCell(j).setCellValue(arr.get(i)[j]);
			}
		}
        //�����������ļ��浽ָ��λ��
        FileOutputStream fout = new FileOutputStream(file.getPath());
        wb.write(fout);
        fout.close();
    }

}  
