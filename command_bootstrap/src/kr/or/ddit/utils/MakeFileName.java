package kr.or.ddit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kr.or.ddit.dto.AttachVO;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		return uuid + delimiter + fileName;
	}
	
	public static String parseFileNameFormUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		
		return uuidFileName[uuidFileName.length - 1];
	}
	
	public static List<AttachVO> parseFileNameAttaches(List<AttachVO> attachList, String delimiter) {
		List<AttachVO> renamedAttachList = new ArrayList<AttachVO>();
		
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName();
				fileName = parseFileNameFormUUID(fileName, delimiter);
				
				attach.setFileName(fileName);
				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
	
}
