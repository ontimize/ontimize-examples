package com.ontimize.projectwiki.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.common.services.dms.IDMSService;
import com.ontimize.jee.server.dms.rest.DMSRestController;
import com.ontimize.jee.server.dms.rest.IDMSNameConverter;

@RestController
@RequestMapping("/filemanager")
@ComponentScan(basePackageClasses = { com.ontimize.jee.common.services.dms.IDMSService.class,
		com.ontimize.jee.server.dms.rest.IDMSNameConverter.class })
public class FileManagerRestController extends DMSRestController<IDMSService, IDMSNameConverter> {

	@Autowired
	private IDMSService dmsService;

	@Override
	public IDMSService getService() {
		return this.dmsService;
	}

}