/**
 * 
 */
package com.muf.hr.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muf.hr.model.Employees;
import com.muf.hr.service.EmployeesService;
import com.muf.hr.service.impl.EmployeesServiceImpl;
import com.muf.hr.util.JsonUtil;

/**
 * @author 15997049
 *
 */
@Controller
public class EmployeesController extends JsonUtil{
	
	// inisial logger
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
	//service
	private EmployeesService employeesService = new EmployeesServiceImpl();
	
	//common
	private Map<String, Object> map = new HashMap<String, Object>();
	private ObjectMapper objectMapper = new ObjectMapper();
	private boolean isNoError = false;

	@RequestMapping(value = "/muf/saveEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	public void saveEmployee(HttpServletResponse response, @RequestBody String data){
		Employees employees = null;
		objectMapper.setDateFormat(new SimpleDateFormat("dd-mm-yyyy"));
		try {
			employees = objectMapper.readValue(data, Employees.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		try {
			isNoError = this.employeesService.save(employees);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e));
		}
		
		map.put("status", isNoError);
		this.encodeToJSON(response, map);
	}

	@RequestMapping(value = "/muf/employeesList", method ={ RequestMethod.POST, RequestMethod.GET})
	public void employeesList(HttpServletResponse response, @RequestBody String data){
		logger.info("ambil data karyawan");
		Collection<Employees> listEmployees = null;
		Employees employees = null;
		try {
			employees = objectMapper.readValue(data, Employees.class);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			if(employees == null || employees.getEmployeeId() == 0){
				listEmployees = this.employeesService.getAllEmployees();
			}else{
				listEmployees = new ArrayList<Employees>();
				employees = this.employeesService.get(employees);
				if(employees != null){
					listEmployees.add(employees);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put("errorConsole", ExceptionUtils.getRootCauseMessage(e));
		}
		
		map.put("aaData", listEmployees);
		this.encodeToJSON(response, map);
	}
	
	@RequestMapping(value = "/muf/employeesDeleteByID", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody  void empoyeesDeleteByID(HttpServletResponse response, @RequestBody String data){
		Employees employees = null;
		try {
			employees = objectMapper.readValue(data, Employees.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			map.put("errorConsole", ExceptionUtils.getRootCauseMessage(e));
		} catch (JsonMappingException e) {
			e.printStackTrace();
			map.put("errorConsole", ExceptionUtils.getRootCauseMessage(e));
		} catch (IOException e) {
			e.printStackTrace();
			map.put("errorConsole", ExceptionUtils.getRootCauseMessage(e));
		}
		
		try {
			this.isNoError  = this.employeesService.delete(employees);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put("errorConsole", ExceptionUtils.getRootCauseMessage(e));
		}
		map.put("status", isNoError);
		this.encodeToJSON(response, map);
	}
	
}
