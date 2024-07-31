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
    public static final String NAME = "tenant_name";
    public static final String URL = "url";
    public static final String REALM = "realm";
    public static final String CLIENT = "client";
}