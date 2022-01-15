package com.sample.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.form.EmployeeSaveForm;
import com.sample.service.EmployeeService;
import com.sample.vo.Employee;

@Controller
@RequestMapping("/emp")		// 접두사
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	// Spring을 안썼을 때는 하나의 url에 하나의 컨트롤 클래스가 적용됐는데
	// @RequestMapping를 사용함으로 써 하나의 url에 하나의 메소드를 적용하여 클래스 수를 줄일 수 있게 되었다.
	
	/*
	 * http://localhost/emp/list.do 요청을 처리하는 요청 핸들러 메소드다.
	 * 요청핸들러 메소드가 반환하는 값은 내부이동 혹은 재요청할 URL이다.
	 * 요청처리를 완료하면 /WEB-INF/jsp/employee/list.jsp로 내부이동시킨다.
	 */
	@RequestMapping(path="/list.do")
	//Model 데이터를 담는 ui
	public String list(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		// employee/list.jsp에서 표현할 데이터를 Model객체에 저장한다.
		model.addAttribute("employees", employees);
		
		return "employee/list.jsp";
	}
	
	// @RequestMapping(path="detail.do")
	/*
	 * http://localhost/emp/detail.do 요청을 처리하는 요청 핸들러 메소드다.
	 * 요청처리를 완료하면 /WEB-INF/jsp/employee/detail.jsp로 내부이동시킨다.
	 * 
	 * 쿼리스트링으로 전달된 요청파라미터값은 요청핸들러 메소드에 요청파라미터 이름과 같은 이름의 매개변수를 선언하면 값을 획득할 수 있다.
	 */
	@GetMapping("/detail.do")
	// detail.do?id=102 쿼리스트링과 똑같은 이름으로 매개변수를 설정하면 알아서 값이 들어간다. 숫자면 형변환도 저절로 한다.
	public String detail(Model model, int id) {
		System.out.println("사원아이디: " + id);
		Employee employee = employeeService.getEmployeeDetail(id);
		model.addAttribute("employee" ,employee);
		return "employee/detail.jsp";
	}
	
	/*
	 * 요청방식 : GET 이고,
	 * 요청URL : http://localhost/emp/insert.do 요청을 처리하는 요청 핸들러 메소드다.
	 */
	// 요청방식에 따라 매핑을 다르게 한다. get방식의 insert.do를 요청하면 @GetMapping 메소드를 post방식으로 요청하면 @PostMapping 메소드를 호출한다.
	@GetMapping("/insert.do")
	public String form() {
		return "employee/form.jsp";
	}
	
	// List<String> skill 이라고 하면 한꺼번에 들어 있다.
	// 혹은 form의 name과 같은 멤버변수를 갖는 객체를 만들어 매개변수로 사용하면 된다.
	/**
	 * 요청방식 : POST 이고, 
	 * 요청URL : http://localhost/emp/insert.do 요청을 처리하는 요청 핸들러 메소드다.
	 * 폼 입력데이터가 아래와 같은 형식으로 전달된다.
	 * 		firstName=%EA%B9%80&lastName=%EC%9C%A0%EC%8B%A0&phoneNumber=010-1231-1231&email=kim%40gmail.com
	 * 요청핸들러 메소드의 매개변수에 사용자정의 클래스타입의 변수를 선언하면 스프링 폼입력값을 담는 Form객체로 인지한다. ★★★★★
	 *  1. EmployeeSaveForm 객체를 생성한다.
	 *  2. EmployeeSaveForm 객체의 멤버변수 타입과 이름을 조사한다.
	 *  3. 요청객체의 요청파라미터에 동일한 이름의 요청파라미터가 있으면 값을 조회해서 EmployeeSaveForm객체의 setter메소드를 호출해서 값을 저장한다.
	 *  4. 모든 멤버변수에 대한 처리가 완료되면 요청핸들러 메소드를 실행하고, 매개변수 인자로 요청파라미터값이 저장된 EmployeeSaveForm객체를 전달한다.
	 * @param employeeForm
	 * @return
	 */
	@PostMapping("/insert.do")
	public String insert(EmployeeSaveForm employeeForm) {
		// 1. Spring의 자동화방법 - 중간에 수정할 수 없다.
//		Employee employee = new Employee();
//		// 객체/멤버변수 복제 (변수명이 똑같은 값을 복사한다.)
//		BeanUtils.copyProperties(employeeForm, employee);
		
		// 2. 노가다.
//		employee.setFirstName(employeeForm.getFirstName());
//		employee.setLastName(employeeForm.getLastName());
//		employee.setPhoneNumber(employeeForm.getPhoneNumber());
//		employee.setEmail(employeeForm.getEmail());
		
		// 3. 폼 객체에서 미리 담아두기 - 중간에 수정 가능
		employeeService.addNewEmployee(employeeForm.toEmployee());
		return "redirect:list.do";
	}
	
}
