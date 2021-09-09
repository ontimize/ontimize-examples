package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import com.ontimize.jee.server.services.dms.dao.IDMSDocumentFileDao;

@Repository("DMSDocumentFileDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/DMSDocumentFileDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class DMSDocumentFileDao extends OntimizeJdbcDaoSupport implements IDMSDocumentFileDao{

	public static final String ATTR_ID_DMS_DOC_FILE = "ID_DMS_DOC_FILE";         
	public static final String ATTR_FILE_NAME = "FILE_NAME";         
    public static final String ATTR_ID_DMS_DOC = "ID_DMS_DOC";         
    public static final String ATTR_FILE_TYPE = "FILE_TYPE";         
    public static final String ATTR_ID_DMS_DOC_CATEGORY = "ID_DMS_DOC_CATEGORY";         
    
}