package com.tutor.api.dto;

import java.util.List;

public class TutorListDto {

	private long page;
	private long totalCount;
	private long totalPages;
	private List<TutorListViewDto> tutorList;
    private long size;
	public long getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<TutorListViewDto> getTutorList() {
		return tutorList;
	}
	public void setTutorList(List<TutorListViewDto> tutorList) {
		this.tutorList = tutorList;
	}
	public long getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
    
    
}
