package com.ontimize.projectwiki.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.boot.core.asynctask.OAsyncTask;
import com.ontimize.jee.common.dto.EntityResult;
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
	
    @OAsyncTask
    @Override
    public ResponseEntity<EntityResult> query(@PathVariable("name") String name,
            @RequestParam(name = "filter", required = false) String filter,
            @RequestParam(name = "columns", required = false) String columns) {
        return super.query(name, filter, columns);
    }
}