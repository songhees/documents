package com.example.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Book;
import com.example.service.BookService;
import com.example.web.view.FileDownloadView;
import com.example.web.view.excel.BestSellerExcelView;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private FileDownloadView fileDownloadView;
	@Autowired
	private BestSellerExcelView bestSellerExcelView;
	
	
	/*
	 *  요청 핸들러 메소드가 어떤 View를 사용할지 지정하지 않았다.
	 *  DispatcherServlet은 기본 ViewResolver로 지정된 InternalResourceViewResolver를 실행시켜서 사용할 View객체를 제공받는다.
	 *  InternalResourceViewResolver는 JstlView객체를 DispatcherServlet에게 제공한다.
	 *  JstlView는 요청을 /WEB-INF/views/book/list.jsp로 내부 이동시킨다. list.jsp가 실행되면 HTML 컨텐츠가 응답으로 제공된다.
	 */
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("books", bookService.getAllBooks());
		
		return "book/list";
	}
	
	/*
	 * 요청 핸들러 메소드가 ModelAndView객체에 FileDownloadView를 사용하도록 지정한다.
	 * 요청 핸들러 메소드가 ModelAndView객체에 다운로드할 파일의 클래스패스 경로 혹은 디렉토리, 파일명을 저장했다.
	 * DispatcherServlet은 ModelAndView에 포함된 FileDownloadView를 사용한다.
	 * FileDownloadView는 디렉토리명, 파일명 혹은 클래스 패스 경로에 해당하는 파일을 읽어서 응답으로 제공된다.
	 */
	@GetMapping("/books")
	public ModelAndView booksListFile() {
		ModelAndView mav = new ModelAndView();
		// ModelAndView객체에 View객체 저장
		mav.setView(fileDownloadView);
		// ModelAndView객체에 Model정보 저장 / 데이터 전달
		mav.addObject("classpath", "classpath:excel/도서목록.xlsx");
		
		// mav.addObject("directory", "전체 디렉토리 경로");
		// mav.addObject("filename", "파일명");
		
		return mav;
	}
	
	/*
	 * 요청 핸들러 메소드가 ModelAndView객체에 BestSellerExcelView를 사용하도록 지정한다.
	 * 요청 핸들러 메소드가 ModelAndView객체에 엑셀파일 생성에 필요한 데이터를 저장했다.
	 * DispatcherServlet은 ModelAndView에 포함된 BestSellerExcelView를 사용한다.
	 * FileDownloadView는 디렉토리명, 파일명 혹은 클래스 패스 경로에 해당하는 파일을 읽어서 응답으로 제공된다.
	 */
	@GetMapping("/bestseller")
	public ModelAndView bestsellerFile() {
		ModelAndView mav = new ModelAndView();
		
		mav.setView(bestSellerExcelView);
		// ModelAndView 객체에 베스트셀러 도서 목록 엑셀파일 생성에 필요한 데이터 구성해서 저장하기
		Map<String, Object> excelData = new HashedMap<String, Object>();
		String[] titles = {"번호", "제목", "저자", "출판사", "가격", "할인가격", "설명"};
		List<Book> bestsellerBooks = bookService.getAllBooks();
		
		excelData.put("titles", titles);
		excelData.put("books", bestsellerBooks);
		
		/*
		 * mav.addObject(excelData);
		 * 		ModelAndView의 model에 model.put("excelData", excelData) 된다. 
		 * mav.addObject("excelData", excelData);
		 * 		ModelAndView의 model에 model.put("excelData", excelData) 된다. 
		 * mav.addAllObjects(excelData);
		 * 		ModelAndView의 model이 excelData로 대체된다.
		 */
		mav.addAllObjects(excelData);
		
		return mav;
	}
}
