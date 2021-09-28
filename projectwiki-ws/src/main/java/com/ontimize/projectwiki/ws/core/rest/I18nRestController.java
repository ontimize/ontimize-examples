package com.ontimize.projectwiki.ws.core.rest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.gui.i18n.DatabaseBundleValues;
import com.ontimize.jee.common.services.i18n.II18nService;
import com.ontimize.jee.server.rest.DeleteParameter;
import com.ontimize.jee.server.rest.InsertParameter;
import com.ontimize.jee.server.rest.UpdateParameter;

@RestController
@RequestMapping("/i18n")
@ComponentScan(basePackageClasses = { com.ontimize.jee.common.services.i18n.II18nService.class })
public class I18nRestController {

	@Autowired
	@Qualifier("I18nService")
	private II18nService iI18nService;

	@RequestMapping(value = "/bundle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntityResult> getBundle(@RequestBody InsertParameter parameter) {
		Map<Object, Object> data = parameter.getData();
		ResourceBundle resource = iI18nService.getBundle(String.valueOf(data.get("bundle")),
				new Locale(String.valueOf(data.get("lang")), String.valueOf(data.get("country"))));
		return new ResponseEntity<EntityResult>(bundleToEntityResult(resource), HttpStatus.OK);
	}

	private EntityResult bundleToEntityResult(ResourceBundle resource) {
		Map<String, String> values = new HashMap<>();
		Enumeration<String> keys = resource.getKeys();
		EntityResult eR = new EntityResultMapImpl();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			values.put("key", key);
			values.put("value", resource.getString(key));
			eR.addRecord(values);
			values = new HashMap<>();
		}
		return eR;
	}
	
	@RequestMapping(value = "/bundle/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateBundleValues(@RequestBody UpdateParameter parameter) {
		
		DatabaseBundleValues values = new DatabaseBundleValues(iI18nService.getAvailableLocales());
		String bundleClass = String.valueOf(parameter.getData().get("bundleClass"));
		String key = String.valueOf(parameter.getFilter().get("key"));
		ArrayList e = (ArrayList) parameter.getData().get("bundleValues");
		Map<String, Object> translationValues = new HashMap<>(); 
		for (int i = 0; i < e.size(); i++) {
			Map<String,Object> map = (Map<String, Object>) e.get(i);
			translationValues.put(String.valueOf(map.get("language")), map.get("value"));
		}
		values.addBundleValue(key, bundleClass, translationValues);
		iI18nService.updateBundleValues(values);
	}
	
	@RequestMapping(value = "/bundle/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteBundleValues(@RequestBody DeleteParameter parameter) {
		DatabaseBundleValues values = new DatabaseBundleValues(iI18nService.getAvailableLocales());

		String bundleClass = String.valueOf(parameter.getFilter().get("bundleClass"));
		String key = String.valueOf(parameter.getFilter().get("key"));
		
		values.addBundleValue(key, bundleClass, null);
		iI18nService.deleteBundleValues(values);
	}
}