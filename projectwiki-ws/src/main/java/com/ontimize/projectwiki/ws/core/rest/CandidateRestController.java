package com.ontimize.projectwiki.ws.core.rest;

import com.ontimize.jee.sdms.rest.controller.OSdmsRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;
import com.ontimize.projectwiki.api.core.service.ICandidateService;

@RestController
@RequestMapping("/candidates")
@ComponentScan(basePackageClasses = { com.ontimize.projectwiki.api.core.service.ICandidateService.class })
public class CandidateRestController extends OSdmsRestController<ICandidateService> {

	@Autowired
	private ICandidateService candidateService;

	@Override
	public ICandidateService getService() {
		return this.candidateService;
	}
}
