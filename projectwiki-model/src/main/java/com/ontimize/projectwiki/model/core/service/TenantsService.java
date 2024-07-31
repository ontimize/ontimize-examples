package com.ontimize.projectwiki.model.core.services;

import com.ontimize.jee.common.multitenant.ITenantAuthenticationInfo;
import com.ontimize.jee.server.security.keycloak.OntimizeKeycloakConfigResolver;
import com.ontimize.jee.server.security.keycloak.store.TenantAuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("TenantsService")
public class TenantsService {
	private final Map<String, ITenantAuthenticationInfo> authenticationMap = new HashMap<>();

	@Autowired
	public TenantsService(final OntimizeKeycloakConfigResolver keycloakConfigResolver) {
		this.AddTenant("tenant1", "Tenant 1", "http://localhost:8082", "demo1", "projectwiki1");
		this.AddTenant("tenant2", "Tenant 2", "http://localhost:8082", "demo2", "projectwiki2");
		keycloakConfigResolver.setTenantsAuthenticationInfo(this.authenticationMap);
	}

	private void AddTenant(final String tenantId, final String tenantName, final String url, final String realm, final String client) {
		final TenantAuthenticationInfo frontAuthInfo = new TenantAuthenticationInfo();
		frontAuthInfo.setTenantId(tenantId);
		frontAuthInfo.setTenantName(tenantName);
		frontAuthInfo.setUrl(url);
		frontAuthInfo.setRealm(realm);
		frontAuthInfo.setClient(client);
		this.authenticationMap.put(tenantId, frontAuthInfo);
	}
}
