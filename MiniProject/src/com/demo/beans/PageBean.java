package com.demo.beans;

public class PageBean {

	// 최소 페이지 번호
	private int min;
	// 최대 페이지 번호
	private int max;
	// 이전 버튼의 페이지 번호
	private int prevPage;
	// 다음 버튼의 페이지 번호
	private int nextPage;
	// 전체 페이지 개수
	private int pageCnt;
	// 현재 페이지 번호
	private int currentPage;
	
	// contentCnt : 전체글 개수(DB검색), currentPage : 현재 페이지, 
	// contentPageCnt : 페이지당 글의 개수(옵션), paginationCnt : 페이지 버튼의 개수(옵션)
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		this.currentPage = currentPage; //현재 페이지
		
		pageCnt = contentCnt / contentPageCnt; //전체 페이지 수 
		if(contentCnt % contentPageCnt > 0) pageCnt++; //나눠서 남으면 페이지+1
		
		//페이지네이션 최소값, 최대값
		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		max = min + paginationCnt - 1;
		//최대페이지보다 크면 안된다
		if(max > pageCnt) {
			max = pageCnt;
		}
		//이전 페이지값, 다음페이지값
		prevPage = min - 1;
		nextPage = max + 1;
		//다음페이지도 최대페이지보다 크면 안된다
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}	
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}
}
