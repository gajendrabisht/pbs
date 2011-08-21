package com.pbs.xml.stax;

public class BookAccessControlGroup implements AccessControlGroup {

	private String doi;
	private FreeInfo freeInfo;
	
	public BookAccessControlGroup() {}
	
	public BookAccessControlGroup(String doi, FreeInfo freeInfo) {
		this.doi = doi;
		this.freeInfo = freeInfo;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public FreeInfo getFreeInfo() {
		return freeInfo;
	}
	public void setFreeInfo(FreeInfo freeInfo) {
		this.freeInfo = freeInfo;
	}
	
}
