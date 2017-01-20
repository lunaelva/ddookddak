package com.ddook.ddak.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ddook.ddak.model.FileModel;


@Controller
@RequestMapping(value="/file")
public class FileUploadController {
	private PrintWriter printWriter;

	@RequestMapping(value="/imageUpload", method=RequestMethod.POST)
	public void imageUpload(FileModel fileModel,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");

		String defaultPath = request.getRealPath("/");
		String contextPath = request.getSession().getServletContext().getContextPath()+"/upload";
		Date date = new Date();

		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		String fileUploadPathTail = sf.format(date);
		String fileUploadPath = "D:\\dev\\workspace\\ddookddak\\src\\main\\resources\\static\\upload\\"+fileUploadPathTail;
		String ckEditorFuncNum = ""; 
		try{
			MultipartFile file = fileModel.getUpload();
			ckEditorFuncNum = fileModel.getCKEditorFuncNum();
			System.out.println(ckEditorFuncNum);
			if(file != null){
				String fileName = file.getOriginalFilename();
				String fileNameExt = fileName.substring(fileName.indexOf(".") + 1);
				
				if(!"".equals(fileName)){
					File destD = new File(fileUploadPath);
							
					if(!destD.exists()){
						destD.mkdirs();
					}
					
					File destination = File.createTempFile("ckeditor_", "."+fileNameExt, destD);
					file.transferTo(destination);

					System.out.println(contextPath + "/" + fileUploadPathTail +"/" + destination.getName());
					fileModel.setNewFilename(destination.getName());
					fileModel.setImageUrl(contextPath + "/" + fileUploadPathTail +"/" + destination.getName());
				}
			}
			

			printWriter = response.getWriter();			
			printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
		               + ckEditorFuncNum
		               + ",'"
		               + "http://localhost:8080" +fileModel.getImageUrl()
		               + "','이미지를 업로드 하였습니다.'"
		               + ")</script>");
		       printWriter.flush();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
	

}
