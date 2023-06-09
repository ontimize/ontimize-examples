package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("CandidateDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CandidateDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CandidateDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID = "ID";
    public static final String ATTR_FIRST_NAME = "FIRST_NAME";
    public static final String ATTR_LAST_NAME = "LAST_NAME";
    public static final String ATTR_EMAIL = "EMAIL";
    public static final String ATTR_ADDRESS = "ADDRESS";
    public static final String ATTR_COUNTRY = "COUNTRY";
    public static final String ATTR_COMPANY = "COMPANY";
    public static final String ATTR_PHONE = "PHONE";


}