package com.ontimize.projectwiki.model.core.dao;

import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;

@Lazy
@Repository(value = "TenantDao")
@ConfigurationFile(
        configurationFile = "dao/TenantDao.xml",
        configurationFilePlaceholder = "dao/placeholders.properties")
public class TenantDao extends OntimizeJdbcDaoSupport {
	public static final String ID = "tenant_id";
	public static final String DRIVER_CLASS = "driver_class";
	public static final String JDBC_URL = "jdbc_url";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
}
