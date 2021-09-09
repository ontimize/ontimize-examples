package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import com.ontimize.jee.server.services.dms.dao.IDMSRelatedDocumentDao;

@Repository("DMSRelatedDocumentDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/DMSRelatedDocumentDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class DMSRelatedDocumentDao extends OntimizeJdbcDaoSupport implements IDMSRelatedDocumentDao {

	public static final String ATTR_ID_DMS_RELATED_PROPERTY = "ID_DMS_RELATED_PROPERTY";
	public static final String ATTR_ID_DMS_DOC_MASTER = "ID_DMS_DOC_MASTER";
	public static final String ATTR_ID_DMS_DOC_CHILD = "ID_DMS_DOC_CHILD";

}
