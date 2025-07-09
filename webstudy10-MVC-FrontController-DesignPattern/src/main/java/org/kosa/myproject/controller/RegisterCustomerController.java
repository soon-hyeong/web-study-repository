package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCustomerController {
	public String registerCustomer(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		MockDao.getInstance().registerCustomer(new CustomerVo(request.getParameter("id"),
				request.getParameter("name"), request.getParameter("address")));
		path = "register-result.jsp";
		return path;
	}
}
