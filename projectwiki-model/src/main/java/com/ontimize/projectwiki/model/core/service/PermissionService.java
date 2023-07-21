package com.ontimize.projectwiki.model.core.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
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

    public final String CANDIDATE_PERMISSION;
    public final String DEMO_PERMISSION;

    private String readFromInputStream(String fileName) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(fileName))))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (IOException e){
            return "";
        }
        return resultStringBuilder.toString();
    }

    public PermissionService (){
        try {
            CANDIDATE_PERMISSION = readFromInputStream("candidate_permissions.json");
            DEMO_PERMISSION = readFromInputStream("demo_permissions.json");
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
        if (role.equals("candidate role")) {
            map.put("permission", CANDIDATE_PERMISSION);
        }
        else if (role.equals("admin")) {
            map.put("permission", DEMO_PERMISSION);
        }
        e.addRecord(map);
        return e;
    }
}
