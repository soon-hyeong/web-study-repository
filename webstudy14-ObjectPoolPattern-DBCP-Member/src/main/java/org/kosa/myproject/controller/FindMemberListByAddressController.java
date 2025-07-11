package org.kosa.myproject.controller;

import java.util.ArrayList;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindMemberListByAddressController implements Controller {

	@Override
	public String handleReqeust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberVo> list = MemberDao.getInstance().findMemberByAddress(request.getParameter("address"));
		request.setAttribute("list", list);
		for(int i = 0; i < list.size();i++) {
			System.out.println(list.get(i));
		}
		return "member-list.jsp";
	}

}
