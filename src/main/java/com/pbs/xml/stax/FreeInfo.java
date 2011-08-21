package com.pbs.xml.stax;

import org.joda.time.DateTime;

public class FreeInfo {
	
	private DateTime startDate;
	private DateTime endDate;
	
	public FreeInfo() {}
	public FreeInfo(DateTime startDate, DateTime endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	public DateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
}
