package org.kb141.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	private int total;
	
	public Criteria() {
		this.page = 0;
		this.perPageNum = 12;
	}
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total / this.perPageNum;
	}


	public int getpage() {
		return page;
	}

	
	
	public void setpage(int page) {
		if(page <= 0){
			this.page = 0;
			return;
		}
		else if(page >= this.total){
			this.page = this.total;
			return;
		}
		this.page = page;
	}

	
	
	
	public int getPerPageNum() {
		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 12;
			return;
		}
		this.perPageNum = perPageNum;
	}


	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", total=" + total + "]";
	}



}
