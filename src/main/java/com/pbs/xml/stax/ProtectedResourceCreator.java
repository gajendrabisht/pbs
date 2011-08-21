package com.pbs.xml.stax;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;

public class ProtectedResourceCreator {
	
	public ProtectedResource create(String xml) throws XMLStreamException {
		ProtectedResource protectedResource = new ProtectedResource();
		List<AccessControlGroup> accessControlGroups = new ArrayList<AccessControlGroup>();
		XMLInputFactory factory = (XMLInputFactory) XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = (XMLStreamReader) factory.createXMLStreamReader(new BufferedInputStream(IOUtils.toInputStream(xml)));
		for(int event = xmlStreamReader.next(); event!=XMLStreamReader.END_DOCUMENT; event=xmlStreamReader.next()) {
			switch(event) {
			case XMLStreamReader.START_ELEMENT:
				if(xmlStreamReader.getLocalName() == "doi") {
					protectedResource.setDoi(xmlStreamReader.getElementText());
				}
				if(xmlStreamReader.getLocalName() == "subjectCodes") {
					protectedResource.setSubjectCodes(getSubjectCodes(xmlStreamReader));
				}
				if(xmlStreamReader.getLocalName() == "accessControlGroup") {
					accessControlGroups.add(getAccessControlGroup(xmlStreamReader));
				}
			}
		}
		protectedResource.setAccessControlGroups(accessControlGroups);
		return protectedResource;
	}

	private AccessControlGroup getAccessControlGroup(XMLStreamReader xmlStreamReader) throws XMLStreamException {
		for(int event = xmlStreamReader.next(); event!=XMLStreamReader.END_ELEMENT; event=xmlStreamReader.next()) {
			switch(event) {
			case XMLStreamReader.START_ELEMENT:
				String doi = xmlStreamReader.getAttributeValue(null, "doi");
				if(xmlStreamReader.getLocalName() == "bookAccessControlGroup") {
					return new BookAccessControlGroup(doi, getFreeInfo(xmlStreamReader));
				}
				if(xmlStreamReader.getLocalName() == "journalAccessControlGroup") {
					return new JournalAccessControlGroup(doi, getFreeInfo(xmlStreamReader), getFreeArticleTypes(xmlStreamReader));
				}
			}
		}
		return null;
	}

	private List<String> getFreeArticleTypes(XMLStreamReader xmlStreamReader) throws XMLStreamException {
		List<String> freeArticleTypes = new ArrayList<String>();
		for(int event = xmlStreamReader.next(); event!=XMLStreamReader.END_ELEMENT; event=xmlStreamReader.next()) {
			switch(event) {
			case XMLStreamReader.START_ELEMENT:
				if(xmlStreamReader.getLocalName() == "freeArticleTypes") {
					freeArticleTypes.addAll(getFreeArticleList(xmlStreamReader));
				}
			}
		}
		return freeArticleTypes;
	}
	
	private List<String> getFreeArticleList(XMLStreamReader xmlStreamReader) throws XMLStreamException {
		List<String> freeArticleTypes = new ArrayList<String>();
		for(int event = xmlStreamReader.next(); event!=XMLStreamReader.END_ELEMENT; event=xmlStreamReader.next()) {
			switch(event) {
			case XMLStreamReader.START_ELEMENT:
				if(xmlStreamReader.getLocalName() == "type") {
					freeArticleTypes.add(xmlStreamReader.getElementText());
				}
			}
		}
		return freeArticleTypes;
	}

	private FreeInfo getFreeInfo(XMLStreamReader xmlStreamReader) throws XMLStreamException {
		FreeInfo freeInfo = new FreeInfo();
		for(int event = xmlStreamReader.next(); event!=XMLStreamReader.END_ELEMENT; event=xmlStreamReader.next()) {
			switch(event) {
			case XMLStreamReader.START_ELEMENT:
				if(xmlStreamReader.getLocalName() == "free") {
					freeInfo.setStartDate(new DateTime(xmlStreamReader.getAttributeValue(null, "startDate")));
					freeInfo.setEndDate(new DateTime(xmlStreamReader.getAttributeValue(null, "endDate")));
				}
			}
		}
		return freeInfo;
	}

	private Set<String> getSubjectCodes(XMLStreamReader xmlStreamReader) throws XMLStreamException {
		Set<String> subjectCodes = new HashSet<String>();
		for(int event = xmlStreamReader.next(); event!=XMLStreamReader.END_ELEMENT; event=xmlStreamReader.next()) {
			switch(event) {
			case XMLStreamReader.START_ELEMENT:
				if(xmlStreamReader.getLocalName() == "code") {
					subjectCodes.add(xmlStreamReader.getElementText());
				}
			}
		}
		return subjectCodes;
	}

}
