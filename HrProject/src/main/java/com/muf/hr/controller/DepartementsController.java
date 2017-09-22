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

import com.muf.hr.model.Departements;
import com.muf.hr.model.Jobs;
import com.muf.hr.service.DepartementsService;
import com.muf.hr.service.JobsService;
import com.muf.hr.service.impl.DepartementsServiceImpl;
import com.muf.hr.service.impl.JobsServiceImpl;
import com.muf.hr.util.JsonUtil;

@Controller
public class DepartementsController extends JsonUtil {

	// inisial logger
	private static final Logger logger = LoggerFactory.getLogger(DepartementsController.class);

	// service
	private DepartementsService departementsService = new DepartementsServiceImpl();

	private Map<String, Object> map = new HashMap<String, Object>();
	private ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/muf/listDepartements", method = RequestMethod.GET)
	public void getAllDepartements(HttpServletResponse response) {
		Collection<Departements> listDepartements = new ArrayList<Departements>();
		try {
			listDepartements = departementsService.getAllDepartements();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		map.put("listJobs", listDepartements);
		this.encodeToJSON(response, map);
	}
}
