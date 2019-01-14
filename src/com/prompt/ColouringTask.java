package com.prompt;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 * �����ɫ����
 * 
 * @author Biao
 * 
 */
public class ColouringTask implements Runnable {
	private StyledDocument doc;
	private MutableAttributeSet style;
	private int pos;
	private int len;

	public ColouringTask(StyledDocument doc, int pos, int len, MutableAttributeSet style) {
		this.doc = doc;
		this.pos = pos;
		this.len = len;
		this.style = style;
	}

	public void run() {
		try {
			// ������Ƕ��ַ�������ɫ
			doc.setCharacterAttributes(pos, len, style, true);
		} catch (Exception e) {
		}
	}
}