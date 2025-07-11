package org.kosa.myproject.controller;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindMemberByIdController implements Controller {

	@Override
	public String handleReqeust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = null;
		MemberVo resultMember = MemberDao.getInstance().findMemberById((String)request.getParameter("memberId"));
		if(resultMember == null) {
			path = "findbyid-fail.jsp";
		}
		else {
			request.setAttribute("resultMember", resultMember);
			path= "findbyid-ok.jsp";
		}
		return path;
	}

}
