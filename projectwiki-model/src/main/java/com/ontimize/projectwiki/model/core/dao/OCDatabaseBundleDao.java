package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "OCDatabaseBundleDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/OCDatabaseBundleDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class OCDatabaseBundleDao extends OntimizeJdbcDaoSupport {

  public OCDatabaseBundleDao() {
    super();
  }
}