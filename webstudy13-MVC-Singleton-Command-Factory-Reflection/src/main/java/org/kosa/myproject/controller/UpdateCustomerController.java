package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MockDao.getInstance()
			.updateCustomer(new CustomerVo(request.getParameter("id"), request.getParameter("name"), request.getParameter("address")));
		return "redirect:update-result.jsp";
	}

}
