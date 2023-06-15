package com.ontimize.projectwiki.model.core.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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

    public static final String CANDIDATE_PERMISSION;

    static {
        try {
            CANDIDATE_PERMISSION = FileUtils.readFileToString(new File("../../../resources/candidate_permissions.json"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntityResult permissionQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EntityResult e = new EntityResultMapImpl();
        Map<String, String> map = new HashMap<>();
        String role = authentication.getAuthorities().toArray()[0].toString();
        if (!role.equals("candidate rol")) {
            map.put("permission", PermissionService.CANDIDATE_PERMISSION);
        }
        e.addRecord(map);
        return e;
    }
}
