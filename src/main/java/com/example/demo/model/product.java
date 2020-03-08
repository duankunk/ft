package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class product {
	private String category ;
	private String name ;
	private String attachment ;
	private String releasetime ;
	private String attachmentname ;
	private String productintroduce ;
	private String productimag ;
	private String context ;
	
}
