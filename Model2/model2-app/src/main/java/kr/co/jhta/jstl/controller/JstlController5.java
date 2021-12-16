package kr.co.jhta.jstl.controller;

import com.sample.model2.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JstlController5 implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("content", "데이터베이스에서 조회한 컨텐츠 입니다.");
		request.getRequestDispatcher("/WEB-INF/views/jstl/sample5.jsp").forward(request, response);
	}
}
