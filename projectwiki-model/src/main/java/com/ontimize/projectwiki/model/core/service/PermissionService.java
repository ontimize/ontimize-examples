package com.ontimize.projectwiki.model.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.projectwiki.api.core.service.IPermissionService;

@Service("PermissionService")
@Lazy

public class PermissionService implements IPermissionService {

    public static final String PLANNER_PERMISSION = "{\"menu\": [{ \"attr\": \"menu\", \"visible\": false, \"enabled\": true }]}";

    @Override
    public EntityResult permissionQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EntityResult e = new EntityResultMapImpl();
        Map<String, String> map = new HashMap<>();
        String role = authentication.getAuthorities().toArray()[0].toString();
        if (!role.equals("candidate rol")) {
            map.put("permission", PermissionService.PLANNER_PERMISSION);
        }
        e.addRecord(map);
        return e;
    }
}
