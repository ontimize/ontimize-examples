package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.boot.core.asynctask.IAsyncTaskDao;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "TaskDao")
@ConfigurationFile(configurationFile = "dao/TaskDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class TaskDao extends OntimizeJdbcDaoSupport implements IAsyncTaskDao {
	
	public static final String	ATTR_ID				= "ID";
	public static final String	ATTR_UUID			= "UUID";
	public static final String	ATTR_STATUS			= "STATUS";
	public static final String	ATTR_RESULT			= "RESULT";
	
	public TaskDao() {
		super();
	}

}
