package com.ontimize.projectwiki.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("OCSettingsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/OCSettingsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class OCSettingsDao extends OntimizeJdbcDaoSupport {

  public OCSettingsDao() {
    super();
  }

}
