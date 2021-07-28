package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.utils.MakeFileName;

public class FileDownloadResolver {
	
	public static void sendFile(String fileName, String savedPath
								, HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
		
		String filePath = savedPath + File.separator + fileName;
		
		// 보낼 파일 설정
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		
		// response 수정.
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		
		String headerKey = "Content-Disposition";
		String sendFileName = MakeFileName.parseFileNameFormUUID(downloadFile.getName(), "\\$\\$");
		
		String header = request.getHeader("User-Agent");
		if(header.contains("MSIE")) {
			sendFileName = URLEncoder.encode(sendFileName, "utf-8");
		} else {
			sendFileName = new String(sendFileName.getBytes("utf-8"), "ISO-8859-1");
		}
		
		String headerValue = String.format("attachment; filename=\"%s\"", sendFileName);
		response.setHeader(headerKey, headerValue);
		
		// 파일 내보내기
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int byteRead = -1;
		
		while((byteRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, byteRead);
		}
		inStream.close();
		outStream.close();
	}
}
