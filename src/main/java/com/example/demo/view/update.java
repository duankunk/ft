package com.example.demo.view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.product;
import com.example.demo.service.productservice;


@Controller
@RequestMapping(value="/")
public class update {
	@Autowired
	private productservice pp;
	@RequestMapping
	public String update_index() {
		
		return "fu";
	}
	@Autowired
	private productservice s;
	@ResponseBody
	@RequestMapping(value="/upload")
	public String update_product(HttpServletRequest request,@RequestParam("file1") MultipartFile file ) {
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String attachment = request.getParameter("attachment");
		String releasetime = request.getParameter("releasetime");
		String  attachmentname = request.getParameter("attachmentname");
		String productintroduce = request.getParameter("productintroduce");
		String context = request.getParameter("context");
		if (!file.isEmpty()) {    
            try {    
                BufferedOutputStream out = new BufferedOutputStream(
                		new FileOutputStream(
                				new File("D:\\java_work\\productinfo\\src\\main\\resources\\static\\"+file.getOriginalFilename())));    
                System.out.println(file.getName()); 
                product p = new product(category, name, attachment, releasetime, attachmentname, productintroduce, "", context);
                pp.createUser(p);
                out.write(file.getBytes());    
                out.flush();    
                out.close();    
            } catch (FileNotFoundException e) {    
                e.printStackTrace();    
                return "上传失败," + e.getMessage();    
            } catch (IOException e) {    
                e.printStackTrace();    
                return "上传失败," + e.getMessage();    
            }    
    
            return "上传成功";    
    
        } else {    
            return "上传失败，因为文件是空的.";    
        }
	}
	
	
}
