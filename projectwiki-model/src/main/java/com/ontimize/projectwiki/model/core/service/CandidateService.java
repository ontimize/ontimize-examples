package com.ontimize.projectwiki.model.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.concurrent.DelegatingSecurityContextRunnable;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEEException;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.services.mail.IMailService;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import com.ontimize.projectwiki.api.core.service.ICandidateService;
import com.ontimize.projectwiki.model.core.dao.CandidateDao;

@Service("CandidateService")
@Lazy
public class CandidateService implements ICandidateService {

	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Autowired
	private IMailService mailService;

	@Override
	public EntityResult candidateQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.candidateDao, keyMap, attrList);
	}

	@Override
	public EntityResult candidateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		EntityResult toRet = this.daoHelper.insert(this.candidateDao, attrMap);

		if ((toRet.getCode() != EntityResult.OPERATION_WRONG)) {

			Runnable runnable = () -> {

				List<String> receiverList = new ArrayList<String>();
				receiverList.add("receiver@example.com");
				StringBuilder builder = new StringBuilder();
				builder.append("Created new user.");
				try {
					this.mailService.sendMailWithoutAttach("my.mail@example.com", receiverList, "New candidate",
							builder.toString());
				} catch (OntimizeJEEException e) {
				}
			};
			
			DelegatingSecurityContextRunnable wrappedRunnable = new DelegatingSecurityContextRunnable(runnable);
			new Thread(wrappedRunnable).start();
		}

		return toRet;
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