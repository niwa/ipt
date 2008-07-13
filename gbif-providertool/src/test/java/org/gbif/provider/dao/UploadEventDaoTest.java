/***************************************************************************
* Copyright (C) 2008 Global Biodiversity Information Facility Secretariat.
* All Rights Reserved.
*
* The contents of this file are subject to the Mozilla Public
* License Version 1.1 (the "License"); you may not use this file
* except in compliance with the License. You may obtain a copy of
* the License at http://www.mozilla.org/MPL/
*
* Software distributed under the License is distributed on an "AS
* IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
* implied. See the License for the specific language governing
* rights and limitations under the License.

***************************************************************************/

package org.gbif.provider.dao;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.gbif.provider.model.UploadEvent;
import org.gbif.provider.util.Constants;
import org.junit.Test;
import org.springframework.orm.ObjectRetrievalFailureException;


public class UploadEventDaoTest extends BaseDaoTestCase{
	protected UploadEventDao uploadEventDao;

	public void setUploadEventDao(UploadEventDao uploadEventDao) {
		this.uploadEventDao = uploadEventDao;
	}
	
	@Test
	public void testGetUploadEventsByResource(){
		try {
			List<UploadEvent> events = uploadEventDao.getUploadEventsByResource(Constants.TEST_RESOURCE_ID);
			for (UploadEvent ev : events){
				logger.debug(ev);
			}
		}catch(ObjectRetrievalFailureException e){
			logger.debug(e.getMessage());
		}
	}
}
