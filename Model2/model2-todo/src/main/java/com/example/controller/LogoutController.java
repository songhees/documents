package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 * 1. "model2-todo/logout.hta" 요청을 처리하는 컨트롤러다.
 * 2. HttpSession객체를 폐기시킨다.
 * 3. 로그아웃 처리가 완료되면 홈화면을 재요청하는 URL("/model2-todo/home.hta")을 응답으로 보낸다.
 */
public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * 1. HttpSession객체를 획득(request.getSession())해서 session객체를 폐기시킨다(session.invalidate())시킨다.
		 * 2. 홈화면을 재요청한다.
		 */
		request.getSession().invalidate();
		return "redirect:/model2-todo/home.hta";
	}
}
