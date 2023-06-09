package com.ontimize.projectwiki.ws.core.rest;

import com.ontimize.jee.server.rest.ORestController;
import com.ontimize.projectwiki.api.core.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public class CandidateRestController extends ORestController<ICandidateService> {

    @Autowired
    private ICandidateService candidateService;

    @Override
    public ICandidateService getService() {
        return this.candidateService;
    }
}