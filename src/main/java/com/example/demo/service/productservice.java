package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
public class productservice {
	@Autowired
	private JdbcTemplate jb;
	public void createUser(product p) {
		jb.update("insert into product values(default,?,?,?,?,?,?,?,?);", 
				p.getCategory(),p.getName(),p.getAttachment(),p.getReleasetime(),p.getAttachmentname(),p.getProductintroduce(),"地方",p.getContext());
	}
}
