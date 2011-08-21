package com.pbs.xml.stax;

import java.util.List;

public class JournalAccessControlGroup implements AccessControlGroup {
	
	private String doi;
	private FreeInfo freeInfo;
	private List<String> freeArticleTypes;
	
	public JournalAccessControlGroup() {}
	
	public JournalAccessControlGroup(String doi, FreeInfo freeInfo,
			List<String> freeArticleTypes) {
		this.doi = doi;
		this.freeInfo = freeInfo;
		this.freeArticleTypes = freeArticleTypes;
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
	public List<String> getFreeArticleTypes() {
		return freeArticleTypes;
	}
	public void setFreeArticleTypes(List<String> freeArticleTypes) {
		this.freeArticleTypes = freeArticleTypes;
	}
}
