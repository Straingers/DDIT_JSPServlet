package com.spring.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.PdsModifyCommand;
import com.spring.command.PdsRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;
import com.spring.service.PdsService;
import com.spring.utils.GetAttachesAsMultipartFiles;

@Controller
@RequestMapping("/pds")
public class PDSController {

	@Autowired
	private PdsService pdsService;
	
	@Resource(name="fileUploadPath")
	private String fileUploadPath;
	
	@RequestMapping("/main")
	public String main() throws Exception {
		String url = "pds/main.open";
		return url;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "pds/list.open";
		
		Map<String, Object> dataMap = pdsService.getList(cri);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(ModelAndView mnv, int pno, String from) throws Exception {
		String url = "pds/detail.open";
		
		PdsVO pds = null;
		if(from != null && from.equals("modify")) {
			pds = pdsService.getPds(pno);
		} else {
			pds = pdsService.read(pno);
		}
		
		// 첨부파일명 재정의
		List<AttachVO> attachList = pds.getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName().split("\\$\\$")[1];
				attach.setFileName(fileName);
			}
		}
		mnv.addObject("pds", pds);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/registForm")
	public String registForm() throws Exception {
		String url = "pds/regist.open";
		return url;
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String regist(PdsRegistCommand registReq, HttpServletRequest request) throws Exception {
		String url = "pds/regist_success";
		
		PdsVO pds = registReq.toPdsVO();
		pds.setTitle((String)request.getAttribute("XSStitle"));
		
		List<AttachVO> attachList = GetAttachesAsMultipartFiles.save(registReq.getUploadFile(), this.fileUploadPath);
		pds.setAttachList(attachList);
		
		pdsService.regist(pds);
		
		return url;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyFrom(ModelAndView mnv, int pno) throws Exception {
		String url = "pds/modify.open";
		
		PdsVO pds = pdsService.getPds(pno);
		
		// 첨부파일명 재정의
		List<AttachVO> attachList = pds.getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName().split("\\$\\$")[1];
				attach.setFileName(fileName);
			}
		}
		mnv.addObject("pds", pds);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String modify(PdsModifyCommand modifyReq, Model model, HttpServletRequest request) throws Exception {
		String url = "pds/modify_success";
		String fileUploadPath = this.fileUploadPath;
		
		if(modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for(int ano : modifyReq.getDeleteFile()) {
				String fileName = pdsService.getAttachByAno(ano).getFileName();
				File deleteFile = new File(fileUploadPath, fileName);
				pdsService.removeAttachByAno(ano);
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
		}
		// 추가 혹은 변경된 파일 저장
		List<AttachVO> attachList = GetAttachesAsMultipartFiles.save(modifyReq.getUploadFile(), fileUploadPath);
		
		PdsVO pds = modifyReq.toPdsVO();
		pds.setAttachList(attachList);
		pds.setTitle((String)request.getAttribute("XSStitle"));
		
		pdsService.modify(pds);
		model.addAttribute("pds", pds);
		
		return url;
	}
	
	@RequestMapping("/remove")
	public String remove(int pno) throws Exception {
		String url = "pds/remove_success";
		
		List<AttachVO> attachList = pdsService.getPds(pno).getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				File target = new File(attach.getUpLoadPath(), attach.getFileName());
				if(target.exists()) {
					target.delete();
				}
			}
		}
		
		pdsService.remove(pno);
		
		return url;
	}
	
	@RequestMapping("/getFile")
	public String getFile(int ano, Model model) throws Exception {
		String url = "downloadFile";
		
		AttachVO attach = pdsService.getAttachByAno(ano);
		model.addAttribute("savedPath", attach.getUpLoadPath());
		model.addAttribute("fileName", attach.getFileName());
		
		return url;
	}
	
}