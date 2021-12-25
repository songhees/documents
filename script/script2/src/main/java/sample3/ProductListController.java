package sample3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 요청 url = http://localhost/script2/product/list.hta
@WebServlet("/product/list.hta")
public class ProductListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> productList = List.of(new Product(100, "갤럭시z플립", "삼성전자", 1500000, 1350000, true),
				new Product(200, "ipone 13 Pro", "애플", 1600000, 1400000, true),
				new Product(300, "apple watch", "애플", 600000, 550000, false));
		
		Gson gson = new Gson();
		String jsonText = gson.toJson(productList);
		System.out.println(jsonText);
		
		// 응답컨텐츠의 타입을 json으로 설정한다.
		response.setContentType("application/json; charset=UTF-8");
		// 브라우저로 텍스트 컨텐츠를 내려보내는 출력스트림을 획득한다. 
		PrintWriter writer = response.getWriter();
		// 브라우저로 jsonText를 내려보낸다.
		writer.write(jsonText);
		writer.flush();
	}
}
