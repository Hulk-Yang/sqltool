package com.page;

public interface PageInfo {
	/**
	 * ���ط�ҳ��С
	 * @return
	 */
	int getPageSize();

	String formatPageSql(String sql);
}
