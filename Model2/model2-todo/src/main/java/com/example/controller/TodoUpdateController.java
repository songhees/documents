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

public class TodoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. HttpSession 객체 획득하기
		 * 2. 인증된 사용자정보 조회하기
		 * 3. 사용자 정보가 null이면 로그인폼을 재요청하는 URL을 반환한다.
		 * 4. 제출된 요청파라미터 값을 조회하기, no/page/categoryNo/title/dueDate/statusNo/content 값을 조회한다.
		 * 5. 일정번호에 해당하는 일정정보(TodoDto)를 조회한다.
		 * 6. 일정정보의 사용자번호와 로그인한 사용자번호를 비교해서 서로 다르면 상세화면을 재요청하는 URL을 응답으로 보낸다.
		 * 7. Todo객체를 생성해서 no, category, title, dueDate, status, content 정보를 저장한다.
		 * 8. TodoDao객체의 updateTodo(Todo todo)를 실행해서 변경된 내용을 테이블에 반영한다.
		 * 9. 일정상세화면을 요청하는 URL을 반환한다. 
		 */
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		if (user == null) {
			return "redirect:/model2-todo/loginform.hta?error=required";
		}
		
		int todoNo = NumberUtils.toInt(request.getParameter("no"));
		int pageNo = NumberUtils.toInt(request.getParameter("page"));
		TodoDao todoDao = TodoDao.getInstance();
		int userNo = todoDao.getTodoByNo(todoNo).getUserNo();
		if (user.getNo() != userNo) {
			return "redirect:/model2-todo/todo/detail.hta?no=" + todoNo + "&page=" + pageNo;
		}
		
		int categoryNo = NumberUtils.toInt(request.getParameter("categoryNo"));
		int statusNo = NumberUtils.toInt(request.getParameter("statusNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date dueDate = DateUtils.parseDate(request.getParameter("dueDate"), "yyyy-MM-dd");
		
		Todo todo = new Todo();
		todo.setNo(todoNo);
		todo.setCategoryNo(categoryNo);
		todo.setStatusNo(statusNo);
		todo.setTitle(title);
		todo.setContent(content);
		todo.setDueDate(dueDate);
		
		todoDao.updateTodo(todo);
		
		return "redirect:/model2-todo/todo/detail.hta?no=" + todoNo + "&page=" + pageNo;
	}
}
