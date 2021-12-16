package com.example.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.hta")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 339661543186959731L;
	// 요청 URL을 key로 Controller객체를 value로 가지는 Map객체 생성
	private Map<String, Controller> controllers = new HashMap<>();
	
	// FrontControllerServlet의 초기화 메소드에서 애플리케이션에서 사용하는 모든 Controller객체를 생성해서
	// 요청 URL, Controller객체의 쌍으로 Map객체에 저장한다.
	public void init() throws ServletException {
		controllers.put("/home.hta", new HomeController());
		controllers.put("/loginform.hta", new LoginFormController());
		controllers.put("/login.hta", new LoginController());
		controllers.put("/logout.hta", new LogoutController());
		controllers.put("/todo/list.hta", new TodoListController());
		controllers.put("/todo/detail.hta", new TodoDetailController());
		controllers.put("/todo/form.hta", new TodoFormController());
		controllers.put("/todo/insert.hta", new TodoInsertController());
		controllers.put("/todo/update.hta", new TodoUpdateController());
	}
	
	/*
	 *  FrontControllerServlet의 서비스 메소드는 *.hta 요청이 올때마다 실행되는 메소드다.
	 *  1. 요청URL을 알아낸다.
	 *  2. 요청URL에 맞는 Controller객체를 Map객체에서 가져온다.
	 *  3. Map객체에서 가져온 Controller객체의 execute(request, response)메소드르 실행하고 URL을 반환값으로 받는다
	 *  4. execute(request, response)메소드가 반환한 URL을 분석해서 JSP로 내부이동해서 JSP를 실행시켜 HTML 응답을 제공하거나.
	 *  	재요청 URL을 응답으로 제공한다.
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1. 요청URL을 알아낸다.
			String requestURI = request.getRequestURI().replace(request.getContextPath(), "");
			// 2. 요청URL에 맞는 Controller객체를 Map객체에서 가져온다.
			Controller controller = controllers.get(requestURI);
			if (controller == null) {
				throw new RuntimeException("요청 URI에 대응되는 컨트롤러가 존재하지 않습니다.");
			}
			// 3. Map객체에서 가져온 Controller객체의 execute(request, response)메소드르 실행하고 URL을 반환값으로 받는다
			String path = controller.execute(request, response);
			if (path == null) {
				throw new RuntimeException("내부이동 혹은 재요청할 경로가 null입니다.");
			}
			// 4. execute(request, response)메소드가 반환한 URL을 분석해서 JSP로 내부이동해서 JSP를 실행시켜 HTML 응답을 제공하거나.
			//	  재요청 URL을 응답으로 제공한다.
			if (path.startsWith("redirect:")) {
				// 재요청 URL을 응답으로 제공한다.
				response.sendRedirect(path.replace("redirect:", ""));
			} else {
				// /WEB-INF/views/ 폴더의 jsp로 클라이언트의 요청을 내부이동시켜서 JSP를 실행하고, HTML을 응답으로 제공하게 한다.
				path = "/WEB-INF/views/" + path;
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
