package com.example.utils;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

/**
 * 파일관련 헬프기능을 지원하는 클래스
 * @author song
 *
 */
public class FileUtils {
	
	/**
	 * 지정된 클래스패스에서 파일을 찾아서 반환한다.
	 * @param classpath 클래스패스   : classpath // src/main 안의 클래스나 파일, jar파일 안의 클래스
	 * @return 파일객체
	 * @throws FileNotFoundException 지정된 클래스패스에 파일이 존재하지 않으면 예외가 발생한다.
	 */
	public static File loadFile(String classpath) throws FileNotFoundException {
		//  파일에 대한 리소스 위치를 확인하기 위한 유틸리티 메서드
		return ResourceUtils.getFile(classpath);
	}
}
