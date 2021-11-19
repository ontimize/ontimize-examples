package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.report.server.dao.IReportParameterDao;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "ReportParameterDao")
@ConfigurationFile(configurationFile = "dao/ReportParameterDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ReportParameterDao extends OntimizeJdbcDaoSupport implements IReportParameterDao {
	
	public static final String	ATTR_ID			 = "ID";
	public static final String	ATTR_REPORT_ID	 = "REPORT_ID";
	public static final String	ATTR_NAME		 = "NAME";
	public static final String	ATTR_DESCRIPTION = "DESCRIPTION";
	public static final String	ATTR_NESTED_TYPE = "NESTED_TYPE";
	public static final String	ATTR_VALUE_CLASS = "VALUE_CLASS";

	public ReportParameterDao() {
		super();
	}
}
