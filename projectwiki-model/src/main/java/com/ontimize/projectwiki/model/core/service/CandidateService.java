package com.ontimize.projectwiki.model.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ontimize.jee.sdms.common.dto.OSdmsRestDataDto;
import com.ontimize.jee.sdms.server.service.IOSdmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.projectwiki.api.core.service.ICandidateService;
import com.ontimize.projectwiki.model.core.dao.CandidateDao;
import org.springframework.web.multipart.MultipartFile;

@Service("CandidateService")
@Lazy
public class CandidateService implements ICandidateService {

	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	private @Autowired IOSdmsService oSdmsService;

// ------------------------------------------------------------------------------------------------------------------ \\
// -------| CRUD |--------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

	@Override
	public EntityResult candidateQuery(Map<?, ?> keyMap, List<?> attrList) {
		return this.daoHelper.query(candidateDao, keyMap, attrList);
	}

	@Override
	public EntityResult candidateInsert(Map<?, ?> attrMap) {
		return this.daoHelper.insert(candidateDao, attrMap);
	}

	@Override
	public EntityResult candidateUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
		return this.daoHelper.update(candidateDao, attrMap, keyMap);
	}

	@Override
	public EntityResult candidateDelete(Map<?, ?> keyMap) {
		return this.daoHelper.delete(candidateDao, keyMap);
	}

// ------------------------------------------------------------------------------------------------------------------ \\
// -------| DMS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

	@Override
	public EntityResult candidateSdmsFindById(final Serializable id, final OSdmsRestDataDto data ) {
		return this.oSdmsService.findById( id, data );
	}

	@Override
	public EntityResult candidateSdmsFind( final OSdmsRestDataDto data ) {
		return this.oSdmsService.find( data );
	}

	@Override
	public EntityResult candidateSdmsDownloadById( final Serializable id, final OSdmsRestDataDto data ) {
		return this.oSdmsService.downloadById( id, data );
	}

	@Override
	public EntityResult candidateSdmsDownload( final OSdmsRestDataDto data ) {
		return this.oSdmsService.download( data );
	}

	@Override
	public EntityResult candidateSdmsUpload(final OSdmsRestDataDto data, final MultipartFile file ) {
		return this.oSdmsService.upload( data, file );
	}

	@Override
	public EntityResult candidateSdmsCreate( final OSdmsRestDataDto data ) {
		return this.oSdmsService.create( data );
	}

	@Override
	public EntityResult candidateSdmsUpdate( final OSdmsRestDataDto data ) {
		return this.oSdmsService.update( data );
	}

	@Override
	public EntityResult candidateSdmsCopy( final OSdmsRestDataDto data ) {
		return this.oSdmsService.copy( data );
	}

	@Override
	public EntityResult candidateSdmsMove( final OSdmsRestDataDto data ) {
		return this.oSdmsService.move( data );
	}

	@Override
	public EntityResult candidateSdmsDeleteById( final Serializable id, final OSdmsRestDataDto data ) {
		return this.oSdmsService.deleteById( id, data );
	}

	@Override
	public EntityResult candidateSdmsDelete( final OSdmsRestDataDto data ) {
		return this.oSdmsService.delete( data );
	}

// ------------------------------------------------------------------------------------------------------------------ \\
}
