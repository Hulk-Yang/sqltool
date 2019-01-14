package main;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 2017/5/9
 */
public class testCellRangeAddress {

    public static void main(String arg[]) throws IOException {
        // ����һ��webbook����Ӧһ��Excel�ļ�
        XSSFWorkbook wb = new XSSFWorkbook();
        // ��webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        XSSFSheet sheet = wb.createSheet("������������ѡ������ϸ���̼�����");
        //�����ϲ���Ԫ��
        CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(cra);
        cra = new CellRangeAddress(0, 0, 3, 6);
        sheet.addMergedRegion(cra);
        cra = new CellRangeAddress(0, 0, 7, 10);
        sheet.addMergedRegion(cra);
        // ��sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
        XSSFRow row = sheet.createRow(0);
        // ������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
        XSSFCellStyle style = wb.createCellStyle();
//        style.setBorderBottom(XSSFCellStyle.BORDER_THIN); //�±߿�
//        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);//��߿�
//        style.setBorderTop(XSSFCellStyle.BORDER_THIN);//�ϱ߿�
//        style.setBorderRight(XSSFCellStyle.BORDER_THIN);//�ұ߿�
//        style.setAlignment(XSSFCellStyle.VERTICAL_CENTER); // ����һ�����и�ʽ
//        style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ

        sheet.setColumnWidth((short) 0, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 1, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 2, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 3, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 4, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 5, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 6, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 7, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 8, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 9, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 10, (short) (35.7 * 100));
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("�ƶ���Ƶ");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("�տ�");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellStyle(style);

        //��һ��д���ͷ
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("paygate������");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("�����̻���");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("������");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("���տ��");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("������");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("�����ܶ�");
        cell.setCellStyle(style);
        //ģ������Դ
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(0);
        for (int i = 1; i <= list.size(); i++) {
            row = sheet.createRow(i + 1);
            // ��������Ԫ�񣬲�����ֵ
            cell = row.createCell(0);//����
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(1);//paygate������
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(2);//�����̻���
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(3);//����
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(4);//���
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(5);//������
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(6);//���տ��
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(7);//����
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(8);//���
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(9);//������
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);

            cell = row.createCell(10);//�����ܶ�
            cell.setCellValue(1000000000);
            cell.setCellStyle(style);
        }
        cra = new CellRangeAddress(list.size()+2, list.size()+2, 0, 2);
        sheet.addMergedRegion(cra);
        row = sheet.createRow(list.size()+2);
        cell = row.createCell(0);
        cell.setCellValue("�ϼ�");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("nihao");
        cell.setCellStyle(style);

        //�ڶ�������
        cra = new CellRangeAddress(list.size()+5, list.size()+5, 0, 2);
        sheet.addMergedRegion(cra);
        cra = new CellRangeAddress(list.size()+5, list.size()+5, 3, 6);
        sheet.addMergedRegion(cra);

        row = sheet.createRow(list.size()+5);
        cell = row.createCell(0);
        cell.setCellValue("�ƶ���Ƶ");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellStyle(style);

        row = sheet.createRow(list.size()+6);
        cell = row.createCell(0);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("paygate������");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("�����̻���");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("������");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("������");
        cell.setCellStyle(style);

        //ģ������Դ
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(0);
        for (int i = 1; i <= list1.size(); i++) {
            row = sheet.createRow(i + 6+list.size());
            // ��������Ԫ�񣬲�����ֵ
            cell = row.createCell(0);//����
            cell.setCellValue(1);
            cell.setCellStyle(style);

            cell = row.createCell(1);//paygate������
            cell.setCellValue(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);//�����̻���
            cell.setCellValue(1);
            cell.setCellStyle(style);

            cell = row.createCell(3);//����
            cell.setCellValue(1);
            cell.setCellStyle(style);

            cell = row.createCell(4);//���
            cell.setCellValue(1);
            cell.setCellStyle(style);

            cell = row.createCell(5);//������
            cell.setCellValue(1);
            cell.setCellStyle(style);

            cell = row.createCell(6);//������
            cell.setCellValue(1);
            cell.setCellStyle(style);
        }
        cra = new CellRangeAddress(list.size()+list1.size()+7, list.size()+list1.size()+7, 0, 2);
        sheet.addMergedRegion(cra);
        row = sheet.createRow(list.size()+list1.size()+7);
        cell = row.createCell(0);
        cell.setCellValue("�ϼ�");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("nihao");
        cell.setCellStyle(style);

        //����������
        cra = new CellRangeAddress(list.size()+list1.size()+10, list.size()+list1.size()+12, 0, 0);
        sheet.addMergedRegion(cra);

        cra = new CellRangeAddress(list.size()+list1.size()+10, list.size()+list1.size()+10, 1, 2);
        sheet.addMergedRegion(cra);

        cra = new CellRangeAddress(list.size()+list1.size()+10, list.size()+list1.size()+10, 3, 4);
        sheet.addMergedRegion(cra);

        cra = new CellRangeAddress(list.size()+list1.size()+10, list.size()+list1.size()+10, 5, 6);
        sheet.addMergedRegion(cra);

        cra = new CellRangeAddress(list.size()+list1.size()+10, list.size()+list1.size()+10, 7, 8);
        sheet.addMergedRegion(cra);

        row = sheet.createRow(list.size()+list1.size()+10);
        cell = row.createCell(0);
        cell.setCellValue("�ƶ���Ƶ");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("�������");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("�̼�����");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellStyle(style);

        row = sheet.createRow(list.size()+list1.size()+11);
        cell = row.createCell(0);
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("���");
        cell.setCellStyle(style);

        row = sheet.createRow(list.size()+list1.size()+12);
        cell = row.createCell(0);
        cell.setCellStyle(style);
        String name = "D://1.xlsx";
        FileOutputStream out = new FileOutputStream(new File(name));
        wb.write(out);
        wb.close();
        out.close();
    }
}
