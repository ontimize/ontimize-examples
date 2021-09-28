package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "OCDatabaseBundleValueDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/OCDatabaseBundleValueDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class OCDatabaseBundleValueDao extends OntimizeJdbcDaoSupport {

  public OCDatabaseBundleValueDao() {
    super();
  }
}