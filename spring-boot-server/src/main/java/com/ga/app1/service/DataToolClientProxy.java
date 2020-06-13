package com.ga.app1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "dtclient", url = "https://datatool-uat.corp.apple.com/DataToolService/auth/integration/")
public interface DataToolClientProxy {

	@RequestMapping(value = "/saveFile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> saveFile(@RequestBody HashMap<String, String> requestMap);
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void downloadFile(@RequestBody HashMap<String, Object> requestMap);
	
	@RequestMapping(value = "/getProcessHeaders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String, Object>> getProcessHeaders(@RequestBody Map<String, String> requestMap);
}
