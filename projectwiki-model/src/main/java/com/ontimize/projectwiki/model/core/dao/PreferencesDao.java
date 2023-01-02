package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.IPreferencesDao;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "PreferencesDao")
@ConfigurationFile(configurationFile = "base-dao/PreferencesDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class PreferencesDao extends OntimizeJdbcDaoSupport implements IPreferencesDao {

    public static final String ATTR_ID = "ID";
    public static final String ATTR_NAME = "NAME";
    public static final String ATTR_DESCRIPTION = "DESCRIPTION";
    public static final String ATTR_PREFERENCES = "PREFERENCES";
    public static final String ATTR_TYPE = "TYPE";

}