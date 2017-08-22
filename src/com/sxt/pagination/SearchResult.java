package com.sxt.pagination;

import java.util.List;

public class SearchResult<T> {
	private List<T> results;
	private Pagination page;
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public Pagination getPage() {
		return page;
	}
	public void setPage(Pagination page) {
		this.page = page;
	}
}
