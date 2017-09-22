package com.muf.hr.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muf.hr.model.Jobs;
import com.muf.hr.service.JobsService;
import com.muf.hr.service.impl.JobsServiceImpl;
import com.muf.hr.util.JsonUtil;

@Controller
public class JobsController extends JsonUtil {

	// inisial logger
	private static final Logger logger = LoggerFactory.getLogger(JobsController.class);

	// service
	private JobsService jobsService = new JobsServiceImpl();

	private Map<String, Object> map = new HashMap<String, Object>();
	private ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/muf/listJobs", method = RequestMethod.GET)
	public void getAllJobs(HttpServletResponse response) {
		Collection<Jobs> listJobs = new ArrayList<Jobs>();
		try {
			listJobs = jobsService.getAllJobs();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		map.put("listJobs", listJobs);
		this.encodeToJSON(response, map);
	}
}
