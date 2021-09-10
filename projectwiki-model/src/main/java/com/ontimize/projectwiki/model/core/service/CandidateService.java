package com.ontimize.projectwiki.model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.DmsException;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.naming.DMSNaming;
import com.ontimize.jee.common.services.dms.DocumentIdentifier;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.jee.server.services.dms.DMSCreationHelper;
import com.ontimize.projectwiki.api.core.service.ICandidateService;
import com.ontimize.projectwiki.model.core.dao.CandidateDao;

@Service("CandidateService")
@Lazy
public class CandidateService implements ICandidateService {

	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private DMSCreationHelper dmsHelper;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Override
	public EntityResult candidateQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.candidateDao, keyMap, attrList);
	}

	@Override
	public EntityResult candidateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		try {
			DocumentIdentifier docId = this.dmsHelper.createDocument((String) attrMap.get(CandidateDao.ATTR_DNI));
			attrMap.put(DMSNaming.DOCUMENT_ID_DMS_DOCUMENT, docId.getDocumentId());
		} catch (DmsException e) {
			throw new OntimizeJEERuntimeException("ERROR_CREATING_DMS_DOC", e);
		}
		return this.daoHelper.insert(this.candidateDao, attrMap);
	}

	@Override
	public EntityResult candidateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.candidateDao, attrMap, keyMap);
	}

	@Override
	public EntityResult candidateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.candidateDao, keyMap);
	}

}