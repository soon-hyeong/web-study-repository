package org.kosa.myproject.test1;

public class RedirectUnitTest {
	public static void main(String[] args) {
		String url = "redirect:register-result.jsp";
		// 서두 prefx가 redirect로 시작되는가?
		System.out.println(url.trim().startsWith("redirect"));
		//
		// trim() : 양 여백을 제거
		System.out.println(url.trim().substring(9));
	}
}
