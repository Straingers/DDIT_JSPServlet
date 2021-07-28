package kr.or.ddit.handler.prod;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.FileUploadResolver;
import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;
import kr.or.ddit.utils.GetUploadPath;
import kr.or.ddit.utils.MultipartHttpServletRequestParser;

public class ProdModifyHandler implements Handler {

	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}
   // 업로드 파일 환경설정
   private static final int MEMORY_THRESHOLD = 1024 * 500;   // 500KB
   private static final int MAX_FILE_SIZE = 1024 * 1024 * 1;     // 1MB
   private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2MB
	   

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "prod/modify_success";
	      MultipartHttpServletRequestParser multiReq 
          = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);		
		
		String id = multiReq.getParameter("id");
		String name = multiReq.getParameter("name");
		String outline = multiReq.getParameter("outline");
		String detail = multiReq.getParameter("detail");
		int price = Integer.parseInt(multiReq.getParameter("price"));
		String category = multiReq.getParameter("category");
		String picture = multiReq.getParameter("uploadPicture");
		int qty = Integer.parseInt(multiReq.getParameter("qty"));
		ProdVO prod = new ProdVO();
		
		prod.setId(id);
		prod.setName(name);
		prod.setOutline(outline);
		prod.setDetail(detail);
		prod.setPrice(price);
		prod.setCategory(category);
		prod.setPicture(picture);
		prod.setQty(qty);
		// 저장경로
		String uploadPath = GetUploadPath.getUploadPath("prod.picture.upload");
		File file = new File(uploadPath);
		if (!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재하거나 생성을 실패했습니다.");
		}

		// 기존 사진 변경 유무 확인
		String uploadPicture = multiReq.getParameter("uploadPicture");
		if (uploadPicture != null && !uploadPicture.isEmpty()) {
			// 기존 사진이미지 삭제
			File deleteFile = new File(uploadPath, multiReq.getParameter("oldPicture"));
			if (deleteFile.exists()) {
				deleteFile.delete();
			}

			// 새로운 이미지 저장
			List<AttachVO> attachList = FileUploadResolver.fileUpload(multiReq.getFileItems("picture"), uploadPath);
			String saveFileName = attachList.get(0).getFileName();
			prod.setPicture(saveFileName);
		} else {
			prod.setPicture(multiReq.getParameter("oldPicture"));
		}	
		
		prodService.modify(prod);
		request.setAttribute("prod", prod);
		
		return url;
	}

}
