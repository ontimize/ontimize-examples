package com.ontimize.projectwiki.api.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.sdms.common.dto.OSdmsRestDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface ICandidateService {
	// ------------------------------------------------------------------------------------------------------------------ \\
// -------| CRUD |--------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

	public EntityResult candidateQuery(Map<?, ?> keyMap, List<?> attrList);

	public EntityResult candidateInsert(Map<?, ?> attrMap);

	public EntityResult candidateUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap);

	public EntityResult candidateDelete(Map<?, ?> keyMap);

// ------------------------------------------------------------------------------------------------------------------ \\
// -------| DMS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

	EntityResult candidateSdmsFindById(Serializable id, OSdmsRestDataDto data);

	EntityResult candidateSdmsFind(OSdmsRestDataDto data);

	EntityResult candidateSdmsDownloadById(Serializable id, OSdmsRestDataDto data);

	EntityResult candidateSdmsDownload(OSdmsRestDataDto data);

	EntityResult candidateSdmsUpload(OSdmsRestDataDto data, MultipartFile file);

	EntityResult candidateSdmsCreate(OSdmsRestDataDto data);

	EntityResult candidateSdmsUpdate(OSdmsRestDataDto data);

	EntityResult candidateSdmsCopy(OSdmsRestDataDto data);

	EntityResult candidateSdmsMove(OSdmsRestDataDto data);

	EntityResult candidateSdmsDeleteById(Serializable id, OSdmsRestDataDto data);

	EntityResult candidateSdmsDelete(OSdmsRestDataDto data);

// ------------------------------------------------------------------------------------------------------------------ \\
}
