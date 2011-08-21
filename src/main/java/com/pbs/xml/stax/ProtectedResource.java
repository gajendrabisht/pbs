package com.pbs.xml.stax;

import java.util.List;
import java.util.Set;

public class ProtectedResource {
	
	private String doi;
	private Set<String> subjectCodes;
	private List<AccessControlGroup> accessControlGroups;
	
	public ProtectedResource() {}
	
	public ProtectedResource(String doi, Set<String> subjectCodes,
			List<AccessControlGroup> accessControlGroups) {
		this.doi = doi;
		this.subjectCodes = subjectCodes;
		this.accessControlGroups = accessControlGroups;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public Set<String> getSubjectCodes() {
		return subjectCodes;
	}
	public void setSubjectCodes(Set<String> subjectCodes) {
		this.subjectCodes = subjectCodes;
	}
	public List<AccessControlGroup> getAccessControlGroups() {
		return accessControlGroups;
	}
	public void setAccessControlGroups(List<AccessControlGroup> accessControlGroups) {
		this.accessControlGroups = accessControlGroups;
	}
}
