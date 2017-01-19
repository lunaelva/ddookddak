package com.ddook.ddak.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping(value="/file/ckeditorImageUpload.do", method=RequestMethod.POST)
	public void ckeditorImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile file) throws Exception {
			
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		String contextPath = request.getSession().getServletContext().getContextPath();
		String defaultPath = request.getRealPath("/");
		String fileUploadPathTail = "upload/";
		String fileUploadPath = defaultPath + "/" + fileUploadPathTail;
		
		try {
			OutputStream out = null;
			PrintWriter printWriter = null;	
			String fileName = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			String uploadPath = fileUploadPath + fileName;
			
			System.out.println(uploadPath);
			out = new FileOutputStream(new File(uploadPath));
			out.write(bytes);
			String callback = request.getParameter("CKEditorFuncNum");
			
			printWriter = response.getWriter();
			String fileUrl = request.getContextPath()+"/" + "/" +fileName; //url 경로
			
			printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
		               + callback
		               + ",'"
		               + fileUrl
		               + "','이미지를 업로드 하였습니다.'"
		               + ")</script>");
		       printWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
