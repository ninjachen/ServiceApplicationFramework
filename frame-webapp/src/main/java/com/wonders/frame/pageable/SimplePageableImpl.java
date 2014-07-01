package com.wonders.frame.pageable;

import com.wonders.frame.Constants;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class SimplePageableImpl implements Pageable {
	
	private int pageNumber;
	
	public static Pageable getInstance(int pageNumber) {
		return new SimplePageableImpl(pageNumber);
	}
	
	private SimplePageableImpl(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public int getPageNumber() {
		return this.pageNumber;
	}

	@Override
	public int getPageSize() {
		return Constants.DEFAULT_PAGE_SIZE;
	}

	@Override
	public int getOffset() {
		return 0;
	}

	@Override
	public Sort getSort() {
		return null;
	}
}
