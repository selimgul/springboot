package com.gul.selim.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UriHelper {

	private UriComponentsBuilder uriBuilder;
	private Map<String, String> pathParams = new HashMap<String, String>();
	private Map<String, Object> queryParams = new HashMap<String, Object>();

	public void setEndpoint(String endpoint) {
		if (StringUtils.isNotBlank(endpoint)) {
			uriBuilder = UriComponentsBuilder.fromUriString(endpoint);
			pathParams.clear();
			queryParams.clear();
		}
	}

	public void addOptionalQueryParam(String paramName, Object obj) {
		if (obj != null)
			queryParams.put(paramName, obj);
	}

	public void addPathParam(String paramName, String paramValue) {
		if (StringUtils.isNotBlank(paramName) && StringUtils.isNotBlank(paramValue))
			pathParams.put(paramName, paramValue);
	}

	@Override
	public String toString() {
		queryParams.forEach((paramName, paramValue) -> uriBuilder.queryParam(paramName, paramValue));
		return uriBuilder.buildAndExpand(pathParams).toUriString();
	}
}
