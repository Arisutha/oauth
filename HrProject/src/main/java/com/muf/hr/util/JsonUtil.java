package com.muf.hr.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	protected void encodeToJSON (HttpServletResponse response, Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		
		PrintWriter out;
		
		try {
			out = response.getWriter();
			mapper.writeValue(out, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void encodeToJSONWithDateTime (HttpServletResponse response, Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		
		PrintWriter out;
		
		try {
			out = response.getWriter();
			mapper.writeValue(out, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
