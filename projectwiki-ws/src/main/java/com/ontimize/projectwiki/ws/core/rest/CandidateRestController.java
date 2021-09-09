package com.ontimize.projectwiki.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;
import com.ontimize.projectwiki.api.core.service.ICandidateService;

@RestController
@RequestMapping("/candidates")
@ComponentScan(basePackageClasses = { com.ontimize.projectwiki.api.core.service.ICandidateService.class })
public class CandidateRestController extends ORestController<ICandidateService>{

	@Autowired
	private ICandidateService candidateService;

	@Override
	public ICandidateService getService() {
		return this.candidateService;
	}
}
