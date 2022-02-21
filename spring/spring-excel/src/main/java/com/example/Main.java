package com.example;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	public static void main(String[] args) throws Exception {
		// https://poi.apache.org/components/spreadsheet/quick-guide.html#NewWorkbook
		// 엑셀파일 만들기
		// Workbook = 엑셀파일 
		Workbook workbook = new XSSFWorkbook();
		// 엑셀시트를 생성한다.
		Sheet sheet = workbook.createSheet("sample sheet");
		// 엑셀 시트에서 행을 생성한다.
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("번호");
		headerRow.createCell(1).setCellValue("제목");
		headerRow.createCell(2).setCellValue("저자");
		headerRow.createCell(3).setCellValue("출판사");
		headerRow.createCell(4).setCellValue("설명");
		headerRow.createCell(5).setCellValue("가격");
		headerRow.createCell(6).setCellValue("할인가격");
		headerRow.createCell(7).setCellValue("재고");
		
		workbook.write(new FileOutputStream("sample.xlsx"));
		workbook.close();
	}
}
