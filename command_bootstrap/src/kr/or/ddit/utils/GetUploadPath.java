package kr.or.ddit.utils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class GetUploadPath {
	private static Properties properites = new Properties();
	
	static {
		String resource = "kr/or/ddit/properties/uploadPath.properties";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properites.load(reader);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUploadPath(String key) {
		String uploadpath = null;
		uploadpath = properites.getProperty(key);
		uploadpath = uploadpath.replace("/", File.separator);
		
		return uploadpath;
	}
}
