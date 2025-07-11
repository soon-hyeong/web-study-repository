package org.kosa.myproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestController implements Controller {

	@Override
	public String handleReqeust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "result.jsp";
	}

}
