package com.ontimize.projectwiki.ws.core.rest;


import com.ontimize.projectwiki.openapi.core.service.IUsersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.projectwiki.api.core.service.IUserService;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/users")
public class UserRestController extends ORestController<IUserService> implements IUsersApi {

	@Autowired
	private IUserService userSrv;

	@Override
	public IUserService getService() {
		return this.userSrv;
	}

	/* @RequestMapping(
		value = "/login",
		method = RequestMethod.POST,
		produces = MediaType.APPLICATION_JSON_VALUE) */
	@Override
	public ResponseEntity<EntityResult> login() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
