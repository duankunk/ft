package com.example.demo.view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/")
public class update {
	
	@RequestMapping
	public String update_index() {
		
		return "fu";
	}
	@ResponseBody
	@RequestMapping(value="/upload")
	public String update_product(HttpServletRequest request,@RequestParam("file1") MultipartFile[] file ) {
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String attachment = request.getParameter("attachment");
		String releasetime = request.getParameter("releasetime");
		String attachmentname = request.getParameter("attachmentname");
		String productintroduce = request.getParameter("productintroduce");
		String context = request.getParameter("context");
		
		System.out.println(file);
		
		return "ss";
	}
	
	
}
