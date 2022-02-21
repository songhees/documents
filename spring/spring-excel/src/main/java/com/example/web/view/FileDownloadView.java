package com.example.web.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.example.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileDownloadView extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// Model객체에는 classpath가 있거나 directory, filename이 있다. 
		String classpath = (String) model.get("classpath");
		String directory = (String) model.get("directory");
		String filename = (String) model.get("filename");
		
		log.info("클래스 패스: " + classpath);
		log.info("디렉토리 경로: " + directory);
		log.info("파일명: " + filename);
		
		File file = null;
		if (classpath != null) {
			// 리소스 경로로 file를 찾기위한 메소드
			file = FileUtils.loadFile(classpath);
		} else {
			// 경로 정보를 바탕으로 해당 파일 객체를 생성
			file = new File(directory, filename);
		}
		
		// 바이너리 파일을 내려보내기 위한 응답헤더 설정하기
		// https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		// attachment; 다운로드로 동작하는 첨부파일이라는 뜻 // 안쓰면 브라우저에 바로 열림
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
		
		// 파일을 읽어오는 스트림객체 생성
		InputStream in = new FileInputStream(file);
		
		// 응답객체에서 브라우저로 보내는 스트림객체 생성
		OutputStream out = response.getOutputStream();
		
		// 브라우저로 파일을 보내기
		// in으로 읽어들인것 output으로 출력
		// 주어진 입력 파일의 내용을 주어진 출력 파일로 복사
		FileCopyUtils.copy(in, out);
	}
	
}
