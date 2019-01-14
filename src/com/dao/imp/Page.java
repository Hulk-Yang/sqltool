package com.dao.imp;

/**
 * ��ҳ������
 * 
 */
public class Page {

	/**
	 * �ܼ�¼��
	 */
	private int totalRow;

	/**
	 * ÿҳ��¼��
	 */
	private int pageSize = 5;

	/**
	 * ��ǰҳ��
	 */
	private int currentCount;

	/**
	 * ��ҳ��
	 */
	private int total;

	/**
	 * ��ʼ��¼�±�
	 */
	private int beginIndex;

	/**
	 * ��ֹ��¼�±�
	 */
	private int endIndex;

	private String sql;

//	/**
//	 * ���췽����ʹ���ܼ�¼������ǰҳ��
//	 * 
//	 * @param totalRow
//	 *            �ܼ�¼��
//	 * @param currentCount
//	 *            ��ǰҳ�棬��1��ʼ
//	 */
//	public Page(int totalRow, int currentCount) {
//		this.totalRow = totalRow;
//		this.currentCount = currentCount;
//		calculate();
//	}
	/**
	 * 
	 * @param startIndex ��ʼindex
	 * @param size       ҳ���С
	 */
	public Page(int startIndex,int size) {
		if(startIndex<1){
			try {
				throw new Exception("ҳ�����������");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.beginIndex=startIndex;
		this.endIndex=startIndex;
		this.pageSize = size;
		this.endIndex = this.pageSize+startIndex;
	}
	
	public void nextPage(){
		beginIndex=endIndex;
		endIndex+=pageSize;
	}
	public void upPage(){
		if(beginIndex-pageSize<1){
			beginIndex = 1;
			endIndex = pageSize+1;
		}else{
			beginIndex = beginIndex-pageSize;
			endIndex -=pageSize;
		}
	}
//
//	/**
//	 * ���췽�� �������ܼ�¼������ǰҳ��
//	 * 
//	 * @param totalRow
//	 *            �ܼ�¼��
//	 * @param currentCount
//	 *            ��ǰҳ��
//	 * @param pageSize
//	 *            Ĭ��10��
//	 */
//	public Page(int totalRow, int currentCount, int pageSize) {
//		this.totalRow = totalRow;
//		this.currentCount = currentCount;
//		this.pageSize = pageSize;
//		calculate();
//	}

	private void calculate() {
		total = totalRow / pageSize + ((totalRow % pageSize) > 0 ? 1 : 0);

		if (currentCount > total) {
			currentCount = total;
		} else if (currentCount < 1) {
			currentCount = 1;
		}

		beginIndex = (currentCount - 1) * pageSize;
		endIndex = beginIndex + pageSize;
		if (endIndex > totalRow) {
			endIndex = totalRow;
		}
	}

	public int getTotalRow() {
		return totalRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public int getTotal() {
		return total;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	
}