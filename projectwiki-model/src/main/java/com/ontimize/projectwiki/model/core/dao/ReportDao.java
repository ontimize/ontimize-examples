package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.report.server.dao.IReportDao;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "ReportDao")
@ConfigurationFile(configurationFile = "dao/ReportDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ReportDao extends OntimizeJdbcDaoSupport implements IReportDao {

	public static final String	ATTR_ID					  = "id";
	public static final String	ATTR_NAME		 		  = "name";
	public static final String	ATTR_DESCRIPTION		  = "description";
	public static final String	ATTR_REPORT_TYPE 		  = "report_type";
	public static final String	ATTR_MAIN_REPORT_FILENAME = "main_report_filename";
	public static final String	ATTR_ZIP				  = "zip";
	public static final String	ATTR_COMPILED			  = "compiled";
	
	public ReportDao() {
		super();
	}
}
