package com.sxt.pagination;

public class Pagination {
	//当前页数
	private int currentPage;
	//每页记录数
	private int pageSize;
	//总记录数
	private int totalCount;
	//总页数
	@SuppressWarnings("unused")
	private int totalPage;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalCount % pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
