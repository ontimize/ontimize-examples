package com.ontimize.projectwiki.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.ontimize.boot.autoconfigure.security.DefaultSecurityAutoConfiguration;
import com.ontimize.jee.server.security.authentication.IAuthenticationMechanism;
import com.ontimize.jee.server.security.authentication.OntimizeAuthenticationFilter;
import com.ontimize.jee.server.security.authentication.OntimizeAuthenticationSuccessHandler;

@Configuration 
@EnableWebSecurity
@EnableAutoConfiguration
@ConditionalOnProperty(name = "ontimize.security.mode", havingValue = "ldap", matchIfMissing = false) 
public class CustomSecurityAutoConfiguration extends DefaultSecurityAutoConfiguration { 

    @Value("${ontimize.security.service-path:/**}") 
    private String servicePath; 

    @Value("${ontimize.security.ignore-paths:}") 
    private String[] ignorePaths; 
 
    @Override 
    public OntimizeAuthenticationFilter preAuthFilterOntimize() throws Exception { 
        OntimizeAuthenticationFilter filter = new OntimizeAuthenticationFilter(this.servicePath); 
        filter.setUserDetailsService(this.userDetailsService()); 
        filter.setUserCache(this.userCache()); 
        filter.setTokenGenerator(this.tokenGenerator()); 
        filter.setGenerateJwtHeader(true); 
        filter.setAuthenticationManager(this.authenticationManager()); 
        filter.setAuthenticationEntryPoint(this.authenticationEntryPoint()); 
        filter.setAuthenticationMechanismList(new ArrayList<>()); 
		filter.getAuthenticationMechanismList().add(this.jwtAuthenticator());
		filter.getAuthenticationMechanismList().add(this.ldapAuthenticator()); 
        filter.setAuthenticationSuccessHandler(new OntimizeAuthenticationSuccessHandler()); 
        filter.afterPropertiesSet(); 
        return filter; 

    } 
  
    @Bean 
    public IAuthenticationMechanism ldapAuthenticator() { 
        return new LdapAuthenticationMechanism(); 
    } 
} 