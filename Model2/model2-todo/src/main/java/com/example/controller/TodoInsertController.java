package com.example.controller;

import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.example.dao.TodoDao;
import com.example.vo.Todo;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * 1. "model2-todo/todo/inser.hta" 요청을 처리하는 컨트롤러다.
 * 2. todoform.jsp에서 제출한 폼입력값을 요청파라미터로 조회한다.
 * 3. 작성자는 로그인된 사용자이기 때문에 HttpSession에서 인증된 사용자 정보를 조회한다.
 * 4. Todo객체를 생성해서 카테고리번호, 제목, 처리예정일, 내용, 인증된 사용자의 번호를 저장한다.
 * 5. TodoDao의 insertTodo(todo) 메소드를 실행해서 테이블에 저장시킨다.
 * 6. 일정목록화면을 재요청하는 url("model2-todo/todo/list.hta")를 반환한다.
 */
public class TodoInsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 
		 * 1. 요청객체에서 HttpSession객체를 획득한다.
		 * 2. 세션 객체에서 로그인된 사용자정보를 조회한다.
		 * 3. 로그인 사용자정보가 null이면 "redirect:/model2-todo/loginform.hta?error=required"을 반환한다.
		 * 4. todo/form.jsp가 제출한 값을 조회한다.
		 * 	  처리예정일은 java.util.Date 타입으로 변환한다.
		 * 	  Date dueDate = DateUtils.parseDate(날짜, "yyyy-MM-dd")
		 * 5. Todo객체를 생성해서 조회된 값을 저장한다.
		 * 6. Todo객체를 dao에 전달해서 저장시킨다.
		 * 7. 화면목록을 재요청하는 URL을 응답으로 보낸다.
		 */
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		if (user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}

		int categoryNo = NumberUtils.toInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date dueDate = DateUtils.parseDate(request.getParameter("dueDate"), "yyyy-MM-dd");
		
		Todo todo = new Todo();
		todo.setCategoryNo(categoryNo);
		todo.setUserNo(user.getNo());
		todo.setContent(content);
		todo.setTitle(title);
		todo.setDueDate(dueDate);
		
		TodoDao todoDao = TodoDao.getInstance();
		todoDao.insertTodo(todo);
		
		return "redirect:/model2-todo/todo/list.hta";
	}
}
