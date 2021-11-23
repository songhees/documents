package example_09_15_override;

public class PrinterApp {
	public static void main(String[] args) {
		
	
		Printer printer = new Printer();	// Printer객체를 참조하는 printer참조변수를 형성 
	
		ColorPrinter colorPrinter = new ColorPrinter();	// ColorPrinter객체를 참조하는 colorPrinter변수를 형성
		colorPrinter.setColors(256);	// colorPrinter참조하는 객체의 color변수에 256값을 대입
		
		PhotoPrinter photoPrinter = new PhotoPrinter(); // PhotoPrinter객체를 참조하는 photoPrinter변수를 형성
		photoPrinter.setColors(256);	// photoPrinter가 참조한 PhotoPrinter의 부모객체 ColorPrinter의 메소드
		//setColors를 실행시켜 colors 변수에 256을 대입한다.
		photoPrinter.setWidth(3);	// photoPrinter가 참조한 PhotoPrinter객체의 setWidth메소드를 실행시켜 width변수에 3을 대입 
		photoPrinter.setHeight(4);	// photoPrinter가 참조한 PhotoPrinter객체의 setHeight메소드를 실행시켜 height변수에 4을 대입
		
		System.out.println("### Print객체의 출력기능 사용하기");
		printer.printBlackAndWhite("휴가신청서.hwp");		
		
		System.out.println("### ColorPrint객체의 출력기능 사용하기");
		colorPrinter.printBlackAndWhite("출장신청서.hwp");		//colorPrinter가 참조하는 객체의 상위 객체의 printBlackAndWhite메소드를 실행
		//하여 컬러프린트로 흑백을 출력
		colorPrinter.printColor("프로젝트발표자료.ppt");
		// 컬러프린트로 컬러출력
		
		System.out.println("### PhotoPrint객체의 출력기능 사용하기");
		photoPrinter.printBlackAndWhite("8월영업실적보고서.xlsx");
		//사진프린터로 흑백출력
		photoPrinter.printColor("8월영업실적.ppt");
		//사진프린터로 컬러출력
		photoPrinter.printPhoto("매장사진.png");
		//사진프린터로 사진출력
	}	
}
