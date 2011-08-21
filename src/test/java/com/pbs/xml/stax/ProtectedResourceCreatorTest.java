package com.pbs.xml.stax;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.junit.Test;

public class ProtectedResourceCreatorTest {
	
	private ProtectedResourceCreator protectedResourceCreator = new ProtectedResourceCreator();
	
	@Test
	public void shouldCreateProtectedResource() throws Exception {
		// given
		String xml = IOUtils.toString(this.getClass().getResourceAsStream("/xml/stax/sampleProtectedResource.xml"), "utf-8");
		
		// when
		ProtectedResource protectedResource = protectedResourceCreator.create(xml);
		
		// then
		assertThat(protectedResource.getDoi(), is("someDoi"));
		// and
		assertThat(protectedResource.getSubjectCodes().contains("subjectCode1"), is(true));
		assertThat(protectedResource.getSubjectCodes().contains("subjectCode2"), is(true));
		// and
		List<AccessControlGroup> accessControlGroups = protectedResource.getAccessControlGroups();
		assertThat(accessControlGroups.size(), is(2));
		// and
		BookAccessControlGroup bookAccessControlGroup = (BookAccessControlGroup) accessControlGroups.get(0);
		assertThat(bookAccessControlGroup.getDoi(), is("someBookDoi"));
		assertThat(bookAccessControlGroup.getFreeInfo().getStartDate(), is(new DateTime("2011-08-21")));
		assertThat(bookAccessControlGroup.getFreeInfo().getEndDate(), is(new DateTime("2012-08-21")));
		// and
		JournalAccessControlGroup journalAccessControlGroup = (JournalAccessControlGroup) accessControlGroups.get(1);
		assertThat(journalAccessControlGroup.getFreeInfo().getStartDate(), is(new DateTime("2011-08-21")));
		assertThat(journalAccessControlGroup.getFreeInfo().getEndDate(), is(new DateTime("2012-08-21")));
		assertThat(journalAccessControlGroup.getFreeArticleTypes().contains("someArticleType1"), is(true));
		assertThat(journalAccessControlGroup.getFreeArticleTypes().contains("someArticleType2"), is(true));
	}
}
